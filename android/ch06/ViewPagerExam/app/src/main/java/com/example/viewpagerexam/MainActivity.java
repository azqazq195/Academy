package com.example.viewpagerexam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.viewpagerexam.adapter.PersonAdapter;
import com.example.viewpagerexam.model.Person;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    // 객체 선언
    ViewPager viewPager;
    PersonAdapter adapter;
    List<Person> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 객체 초기화
        list = new ArrayList<>();
        addData();
        adapter = new PersonAdapter(this, list);
        viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(adapter);
        list.add(new Person("dd" , "dd", R.drawable.job07));
        adapter.notifyDataSetChanged();
    }

    private void addData() {
        list.add(new Person("아이유", "번호삼", R.drawable.job05));
        list.add(new Person("이지은", "번호사", R.drawable.job06));
        list.add(new Person("이지금", "번호오", R.drawable.job07));

    }
}