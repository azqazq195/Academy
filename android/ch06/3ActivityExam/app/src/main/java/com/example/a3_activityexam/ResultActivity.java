package com.example.a3_activityexam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.a3_activityexam.model.Answer;

import org.w3c.dom.Text;

public class ResultActivity extends AppCompatActivity {
    TextView textView1, textView2, textView3;
    Answer answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        textView1 = findViewById(R.id.textView1);
        textView2 = findViewById(R.id.textView2);
        textView3 = findViewById(R.id.textView3);

        // 인텐트에서 데이터 꺼내기
        answer = (Answer) getIntent().getSerializableExtra("answer");

        textView1.setText("아이디 : " + answer.getId());
        textView2.setText("비밀번호 : " + answer.getPassword());
        textView3.setText("이메일 : " + answer.getEmail());


    }
}