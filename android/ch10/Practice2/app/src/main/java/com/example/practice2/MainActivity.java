package com.example.practice2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.example.practice2.adapter.ImageAdapter;
import com.example.practice2.model.Image;
import com.example.practice2.response.ImageResponse;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.RequestParams;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
implements View.OnClickListener, AbsListView.OnScrollListener, AdapterView.OnItemClickListener {

    List<Image> list;
    ImageAdapter adapter;
    EditText editText;
    Button button;
    ListView listView;
    AsyncHttpClient client;
    ImageResponse response;
    LinearLayout layoutFooter;

    public static final int PAGE_SIZE = 20;
    public static int PAGE = 1;
    boolean lastItemVisibleFlag = false;
    String keyword = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = new ArrayList<>();
        adapter = new ImageAdapter(this, R.layout.list_item, list);
        editText = findViewById(R.id.editText);
        button = findViewById(R.id.button);
        listView = findViewById(R.id.listView);

        View footerView = getLayoutInflater().inflate(R.layout.list_footer, null);
        layoutFooter = footerView.findViewById(R.id.layoutFooter);

        client = new AsyncHttpClient();
        response = new ImageResponse(this, adapter, listView, layoutFooter);

        listView.addFooterView(footerView);
        listView.setAdapter(adapter);
        footerView.setVisibility(View.GONE);

        button.setOnClickListener(this);
        listView.setOnScrollListener(this);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onClick(View v) {
        keyword = editText.getText().toString().trim();
        if(keyword.equals("")){
            Toast.makeText(this, "검색어를 입력해 주세요", Toast.LENGTH_SHORT).show();
            return;
        }
        PAGE = 1;
        adapter.clear();
        getKakaoData(keyword);

    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
        if(scrollState == SCROLL_STATE_IDLE && lastItemVisibleFlag){
            PAGE++;
            getKakaoData(keyword);
        }
    }

    private void getKakaoData(String keyword) {
        RequestParams params = new RequestParams();
        params.put("query", keyword);
        params.put("page", String.valueOf(PAGE));
        params.put("size", String.valueOf(PAGE_SIZE));
        client.addHeader("Authorization", "KakaoAK 02456d03e8d507835b3dd88c71790615");
        String url = "https://dapi.kakao.com/v2/search/image";
        client.get(url, params, response);
    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        lastItemVisibleFlag = (totalItemCount > 0) &&
                (firstVisibleItem + visibleItemCount >= totalItemCount);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(this, ViewActivity.class);
        Image item = adapter.getItem(position);

        intent.putExtra("item", item);

        intent.putExtra("thumbnail_url", item.getThumbnail_url());
        intent.putExtra("image_url", item.getImage_url());
        intent.putExtra("doc_url", item.getDoc_url());
        startActivity(intent);
    }
}