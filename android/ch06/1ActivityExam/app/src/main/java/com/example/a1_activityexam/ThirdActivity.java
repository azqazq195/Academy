package com.example.a1_activityexam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ThirdActivity extends AppCompatActivity implements View.OnClickListener {
    EditText editText;
    Button button1, button2;
    String name; // 이전 화면에서 넘어온 데이터 저장

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        editText = findViewById(R.id.editText);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        // 이전 화면에서 전달된 데이터 추출
        Intent fromIntent = getIntent();
        name = fromIntent.getStringExtra("name");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button1:
                int age = Integer.parseInt(editText.getText().toString().trim());
                // 인텐트 설정
                Intent intent = new Intent(this, ResultActivity.class);
                intent.putExtra("name", name);
                intent.putExtra("age", age);
                // 화면 이동
                startActivity(intent);
                break;
            case R.id.button2:
                finish();
                break;
        }
    }
}