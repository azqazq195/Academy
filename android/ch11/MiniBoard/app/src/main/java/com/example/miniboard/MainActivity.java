package com.example.miniboard;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.example.miniboard.adapter.CommunityAdapter;
import com.example.miniboard.model.Community;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity
    implements View.OnClickListener, AdapterView.OnItemClickListener, AbsListView.OnScrollListener {
    List<Community> list;
    CommunityAdapter adapter;
    Button button;
    ListView listView;
    AsyncHttpClient client;
    HttpResponse response;
    //String url = "http://192.168.0.96:8080/miniboard/community/community_list.jsp";
    String url = "http://192.168.0.96:8080/miniboard/community/community_index_list.jsp";

    LinearLayout layoutProgress;
    // 페이징 처리
    final int PAGE_SIZE = 15;
    int PAGE = 1;
    boolean lastItemVisibleFlag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = new ArrayList<>();
        adapter = new CommunityAdapter(this, R.layout.list_item, list);
        button = findViewById(R.id.button);
        listView = findViewById(R.id.listView);
        layoutProgress = findViewById(R.id.layoutProgress);
        client = new AsyncHttpClient();
        response = new HttpResponse();
        // 리스트뷰 설정
        listView.setAdapter(adapter);
        // 이벤트 설정
        button.setOnClickListener(this);
        listView.setOnItemClickListener(this);
        listView.setOnScrollListener(this);
        // 화면 초기화
        layoutProgress.setVisibility(View.GONE);
    }

    @Override
    protected void onResume() {
        super.onResume();
        adapter.clear();  // 기존 데이터 삭제
        getData();
    }

    public void getData() {
        RequestParams params = new RequestParams();
        params.put("page", PAGE);
        params.put("size", PAGE_SIZE);
        client.post(url, params, response);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, WriteActivity.class);
        startActivity(intent);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Community item = adapter.getItem(position);
        Intent intent = new Intent(this, ReadActivity.class);
        intent.putExtra("item", item);
        startActivity(intent);
    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
        if(scrollState == SCROLL_STATE_IDLE && lastItemVisibleFlag) {
            PAGE++;
            getData();
        }
    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        lastItemVisibleFlag = (totalItemCount > 0) &&
                (firstVisibleItem + visibleItemCount >= totalItemCount);
    }

    class HttpResponse extends AsyncHttpResponseHandler {
        ProgressDialog dialog;

        @Override
        public void onStart() {
           layoutProgress.setVisibility(View.VISIBLE);
            Log.d("[TEST]", getRequestURI().toString());
        }

        @Override
        public void onFinish() {
            layoutProgress.setVisibility(View.GONE);
        }

        @Override
        public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
            String str = new String(responseBody);
            try {
                JSONObject json = new JSONObject(str);
                Community.setRt(json.getString("rt"));
                Community.setTotal(json.getInt("total"));

                JSONArray item = json.getJSONArray("item");
                for(int i=0; i<item.length(); i++) {
                    JSONObject temp = item.getJSONObject(i);
                    Community community = new Community();
                    community.setReg_date(temp.getString("reg_date"));
                    community.setUser_name(temp.getString("user_name"));
                    community.setSubject(temp.getString("subject"));
                    community.setSeq(temp.getInt("seq"));
                    // 리스트에 저장
                    adapter.add(community);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
            Toast.makeText(MainActivity.this, "통신 실패" + statusCode, Toast.LENGTH_SHORT).show();
        }
    }
}




