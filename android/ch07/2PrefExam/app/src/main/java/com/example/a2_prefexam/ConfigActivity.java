package com.example.a2_prefexam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;

public class ConfigActivity extends AppCompatActivity {
    EditText editText1, editText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config);

        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);
    }

    // activity 화면이 사라지기 직전에 자동 호출
    // 설정 파일에 데이터 저장하기
    @Override
    protected void onPause() {
        super.onPause();
        String name = editText1.getText().toString().trim();
        String id = editText2.getText().toString().trim();

        // 데이터 저장
        // 1) 공통 정보 관리 객체 생성
        SharedPreferences pref = getSharedPreferences("CONFIG", Context.MODE_PRIVATE);
        // 2) 저장, 수정 객체
        SharedPreferences.Editor editor = pref.edit();
        // 3) 내용쓰기
        editor.putString("name", name);
        editor.putString("id", id);
        // 4) 저장
        editor.commit();
    }
}