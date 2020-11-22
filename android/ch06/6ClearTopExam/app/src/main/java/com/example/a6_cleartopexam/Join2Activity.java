package com.example.a6_cleartopexam;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class Join2Activity extends AppCompatActivity implements View.OnClickListener {
    CheckBox checkBox1, checkBox2, checkBox3;
    Button button;
    String hobby = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join2);

        checkBox1 = findViewById(R.id.checkBox1);
        checkBox2 = findViewById(R.id.checkBox2);
        checkBox3 = findViewById(R.id.checkBox3);
        button = findViewById(R.id.button);

        button.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(!checkBox1.isChecked() &&
                !checkBox2.isChecked() &&
                !checkBox3.isChecked()){
            Toast.makeText(this, "취미를 선택하세요", Toast.LENGTH_SHORT).show();
            return;
        }
        if(checkBox1.isChecked()){
            hobby += checkBox1.getText().toString() + "\n";
        }
        if(checkBox2.isChecked()){
            hobby += checkBox2.getText().toString() + "\n";
        }
        if(checkBox3.isChecked()){
            hobby += checkBox3.getText().toString() + "\n";
        }

        Intent intent = new Intent();
        intent.putExtra("hobby", hobby);
        // 성공되었다는 결과와 함께, 시스템에 인텐트를 전달함
        setResult(RESULT_OK, intent);
        // 현재화면 종료
        finish();

        // History stack 내용을 지우라는 설정
        // intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        // 새로 만들지 말고, 기존 화면을 불러오는 설정
        // intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
    }
}