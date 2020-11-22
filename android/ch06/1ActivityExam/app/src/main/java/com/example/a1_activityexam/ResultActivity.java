package com.example.a1_activityexam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ResultActivity extends AppCompatActivity {
    TextView textView;
    // 이전 화면에서 넘어온 데이터 저장
    String name;
    int age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        textView = findViewById(R.id.textView);
        // 인텐트에서 데이터 꺼내기
        name = getIntent().getStringExtra("name");
        age = getIntent().getIntExtra("age", 0);

        String result = "<font color='blue'>" + name + "님</font>의 나이는 <font color='red'>" + age + "세</font> 입니다.";
        textView.setText(Html.fromHtml(result));
    }
}