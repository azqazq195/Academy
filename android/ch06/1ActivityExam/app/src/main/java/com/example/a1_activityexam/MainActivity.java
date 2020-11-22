package com.example.a1_activityexam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button button1, button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button1:
                // 화면 이동을 위한 명시적 인텐트
                Intent intent = new Intent(this, SecondActivity.class);
                // 화면 이동 요청
                startActivity(intent);
                break;
            case R.id.button2:
                // 현재 Activity 화면 종료 --> 첫 화면에서는 앱 종료
                finish();
                break;
        }
    }
}