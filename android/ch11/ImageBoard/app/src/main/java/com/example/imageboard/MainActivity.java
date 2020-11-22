package com.example.imageboard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.example.imageboard.adapter.CommunityAdapter;
import com.example.imageboard.model.Community;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity
    implements View.OnClickListener, AdapterView.OnItemClickListener {
    List<Community> list;
    CommunityAdapter adapter;
    Button button;
    ListView listView;
    LinearLayout layoutProgress;
    AsyncHttpClient client;
    HttpResponse response;
    String url = "http://192.168.0.96:8080/imageboard/community/community_list.do";
    //String url = "http://192.168.0.96:8080/imageboard/community/community_list.jsp";

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
        // listView 설정
        listView.setAdapter(adapter);
        // 이벤트 설정
        button.setOnClickListener(this);
        listView.setOnItemClickListener(this);
        // 화면 초기화
        layoutProgress.setVisibility(View.INVISIBLE);
    }

    @Override
    protected void onResume() {
        super.onResume();
        adapter.clear();
        client.post(url, response);
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
        intent.putExtra("seq", item.getSeq());
        startActivity(intent);
    }

    class HttpResponse extends AsyncHttpResponseHandler {
        @Override
        public void onStart() {
            layoutProgress.setVisibility(View.VISIBLE);
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
                String rt = json.getString("rt");
                int total = json.getInt("total");
                JSONArray item = json.getJSONArray("item");

                for(int i=0; i<item.length(); i++) {
                    JSONObject temp = item.getJSONObject(i);
                    Community community = new Community();
                    community.setReg_date(temp.getString("reg_date"));
                    String filename = temp.getString("filename");
                    if (filename.equals("")) filename = null;
                    community.setFilename(filename);
                    community.setUser_name(temp.getString("user_name"));
                    community.setSubject(temp.getString("subject"));
                    community.setUser_pwd(temp.getString("user_pwd"));
                    community.setEdit_date(temp.getString("edit_date"));
                    community.setSeq(temp.getInt("seq"));
                    community.setEmail(temp.getString("email"));
                    community.setContent(temp.getString("content"));
                    // list에 저장
                    adapter.add(community);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        @Override
        public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
            Toast.makeText(MainActivity.this, "통신 실패", Toast.LENGTH_SHORT).show();
        }
    }
}


