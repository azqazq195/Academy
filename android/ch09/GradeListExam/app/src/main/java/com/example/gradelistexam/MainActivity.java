package com.example.gradelistexam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.gradelistexam.adapter.MemberAdapter;
import com.example.gradelistexam.medel.Member;
import com.example.gradelistexam.response.MemberResponse;
import com.loopj.android.http.AsyncHttpClient;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    List<Member> list;
    MemberAdapter adapter;
    ListView listView;
    AsyncHttpClient client;
    MemberResponse response;
    String url = "http://192.168.0.123:8080/server_data/grade.json";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = new ArrayList<>();
        adapter = new MemberAdapter(this, R.layout.list_item, list);
        listView = findViewById(R.id.listView);
        client = new AsyncHttpClient();
        response = new MemberResponse(this, adapter);

        // listView 설정
        listView.setAdapter(adapter);

        // 이벤트 설정
        listView.setOnItemClickListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        client.get(url, response);  // 요청
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Member member = adapter.getItem(position);
        String result = member.getName();
        Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
    }
}