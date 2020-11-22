package com.example.jsonimagelisttest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.jsonimagelisttest.adapter.JobAdapter;
import com.example.jsonimagelisttest.model.Job;
import com.example.jsonimagelisttest.reponse.JobResponse;
import com.loopj.android.http.AsyncHttpClient;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, View.OnClickListener {
    List<Job> list;
    JobAdapter adapter;
    AsyncHttpClient client;
    JobResponse response;
    String url = "http://192.168.0.123:8080/server_data/job.json";

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);

        list = new ArrayList<>();
        adapter = new JobAdapter(this, R.layout.list_item, list);
        client = new AsyncHttpClient();
        response = new JobResponse(this, adapter);

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);

    }

    @Override
    protected void onResume() {
        super.onResume();
        client.get(url, response);
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(this, ViewActivity.class);
        intent.putExtra("img", adapter.getItem(position).getImg());
        intent.putExtra("originalImage", adapter.getItem(position).getOriginalImage());
        intent.putExtra("subject", adapter.getItem(position).getSubject());
        intent.putExtra("content", adapter.getItem(position).getContent());
        startActivity(intent);
    }
}