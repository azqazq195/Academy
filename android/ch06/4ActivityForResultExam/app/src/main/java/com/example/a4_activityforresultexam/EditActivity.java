package com.example.a4_activityforresultexam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditActivity extends AppCompatActivity implements View.OnClickListener {
    EditText editText;
    Button button1, button2;
    String memo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        // 객체 초기화
        editText = findViewById(R.id.editText);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        memo = getIntent().getStringExtra("memo");

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);

        editText.setText(memo);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button1:
                String edit = editText.getText().toString().trim();
                // 빈 인텐트 생성 : 수정 내용을 전달하기 위함, 이동 방향 설정 안함
                Intent intent = new Intent();
                intent.putExtra("edit", edit);
                // 성공되었다는 결과와 함께, 시스템에 인텐트를 전달함
                setResult(RESULT_OK, intent);
                // 현재화면 종료
                finish();
                break;
            case R.id.button2:
                // 취소되었다는 결과를 시스템에 전달함
                setResult(RESULT_CANCELED);
                finish();
                break;
        }
    }
}