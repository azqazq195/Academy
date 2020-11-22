package com.example.practice4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.practice4.adpter.JobPageAdapter;
import com.example.practice4.model.Job;

import java.util.List;

public class ResultActivity extends AppCompatActivity {
    // 객체 선언
    List<Job> list;
    JobPageAdapter adapter;
    ViewPager viewPager;
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        // 객체 초기화
        list = (List) getIntent().getSerializableExtra("list");
        adapter = new JobPageAdapter(this, list);
        viewPager = findViewById(R.id.viewPager);
        position = getIntent().getIntExtra("position", 0);
        // viewPager에 어댑터 설정
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(position);
    }
}





