package com.example.practice3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.example.practice3.adpater.KeywordAdapter;
import com.example.practice3.model.Keyword;
import com.example.practice3.response.KeywordResponse;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.RequestParams;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements View.OnClickListener, AbsListView.OnScrollListener,
        AdapterView.OnItemClickListener {

    List<Keyword> list;
    KeywordAdapter adapter;
    EditText editText;
    Button button1, button2;
    ListView listView;
    AsyncHttpClient client;
    KeywordResponse response;
    LinearLayout layoutFooter;

    public static final int PAGE_SIZE = 15;
    public static int PAGE = 1;
    boolean lastItemVisibleFlag = false;
    String keyword = null;

    // GPS 관리 객체
    LocationManager lm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = new ArrayList<>();
        adapter = new KeywordAdapter(this, R.layout.list_view, list);
        editText = findViewById(R.id.editText);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        listView = findViewById(R.id.listView);

        View footerView = getLayoutInflater().inflate(R.layout.list_footer, null);
        layoutFooter = footerView.findViewById(R.id.layoutFooter);

        client = new AsyncHttpClient();
        response = new KeywordResponse(this, adapter, listView, layoutFooter);

        listView.addFooterView(footerView);
        listView.setAdapter(adapter);
        footerView.setVisibility(View.GONE);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        listView.setOnScrollListener(this);
        listView.setOnItemClickListener(this);

        permissionCheck();

        getLocation();

    }

    private void getLocation() {
    }

    private void permissionCheck() {
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button2:
                keyword = editText.getText().toString().trim();
                if(keyword.equals("")){
                    Toast.makeText(this, "검색어를 입력해 주세요", Toast.LENGTH_SHORT).show();
                    return;
                }
                PAGE = 1;
                adapter.clear();
                keywordSearch(keyword);
                break;
        }
    }

    private void keywordSearch(String keyword) {
        Log.d("[TEST]", keyword);

        client.addHeader("Authorization", "KakaoAK 4151816199d1ae17a9d725a5e6840e41");
        RequestParams params = new RequestParams();
        params.put("query", keyword);
        params.put("page", PAGE);
        params.put("size", PAGE_SIZE);
        params.put("category_group_code", "FD6");
        params.put("y", 37.514322572335935);
        params.put("x", 127.06283102249932);
        params.put("radius", 20000);
        String url = "https://dapi.kakao.com/v2/local/search/keyword.json";
        client.get(url, params, response);
    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
        if(scrollState == SCROLL_STATE_IDLE && lastItemVisibleFlag){
            PAGE++;
            keywordSearch(keyword);
        }
    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        lastItemVisibleFlag = (totalItemCount > 0) &&
                (firstVisibleItem + visibleItemCount >= totalItemCount);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Keyword item = adapter.getItem(position);
        Intent intent = new Intent(this, ViewActivity.class);
        intent.putExtra("item", item);
        startActivity(intent);
    }
}