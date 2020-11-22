package com.example.a1_jsonimagelistexam;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.a1_jsonimagelistexam.adapter.ColumnAdapter;
import com.example.a1_jsonimagelistexam.model.Column;
import com.example.a1_jsonimagelistexam.response.ColumnResponse;
import com.loopj.android.http.AsyncHttpClient;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements AdapterView.OnItemClickListener, View.OnClickListener {
    List<Column> list;
    ColumnAdapter adapter;

    ImageLoader imageLoader;
    DisplayImageOptions options;

    AsyncHttpClient client;
    ColumnResponse response;
    String url = "http://192.168.0.123:8080/server_data/column.json";
    ListView listView;
    LinearLayout list_layout, view_layout;
    TextView textView1, textView2;
    ImageView imageView;
    Button button;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = new ArrayList<>();
        adapter = new ColumnAdapter(this, R.layout.list_item, list);
        listView = findViewById(R.id.listView);
        list_layout = findViewById(R.id.list_layout);
        view_layout = findViewById(R.id.view_layout);
        imageView = findViewById(R.id.imageView);
        textView1 = findViewById(R.id.textView1);
        textView2 = findViewById(R.id.textView2);
        button = findViewById(R.id.button);

        client = new AsyncHttpClient();
        response = new ColumnResponse(this, adapter);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(this);
        button.setOnClickListener(this);

        imageLoaderInit();
        setLayout(list_layout);
    }

    @Override
    protected void onResume() {
        super.onResume();
        client.get(url, response);
    }

    private void setLayout(LinearLayout layout) {
        list_layout.setVisibility(View.GONE);
        view_layout.setVisibility(View.GONE);
        layout.setVisibility(View.VISIBLE);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        // Layout 화면 전환 방법으로 꽃이름, 꽃말, 꽃이미지를 출력하기

        imageView.setImageURI(null);
        String subject = adapter.getItem(position).getSubject();
        String content = adapter.getItem(position).getContent();
        String img = adapter.getItem(position).getImg();

        textView1.setText(subject);
        textView2.setText(content);
        ImageLoader.getInstance().displayImage(img, imageView);

        setLayout(view_layout);
    }

    @Override
    public void onClick(View v) {
        setLayout(list_layout);
    }

    private void imageLoaderInit() {
        // 이미지로더 초기화
        imageLoader = ImageLoader.getInstance();
        if(!imageLoader.isInited()) {
            ImageLoaderConfiguration configuration =
                    ImageLoaderConfiguration.createDefault(this);
            imageLoader.init(configuration);
        }
        // 다운로드 옵션 설정
        DisplayImageOptions.Builder builder = new DisplayImageOptions.Builder();
        // 다운로드 동안 표시할 임시 이미지 설정
        builder.showImageOnLoading(R.drawable.ic_stub);
        // 이미지가 지정되지 않은 경우 사용될 이미지 설정
        builder.showImageForEmptyUri(R.drawable.ic_empty);
        // 다운로드 실패시에 사용할 이미지 설정
        builder.showImageOnFail(R.drawable.ic_error);
        options = builder.build();
    }
}