package com.example.a2_prefexam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // 객체 선언
    Button button;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 객체 초기화
        button = findViewById(R.id.button);
        textView = findViewById(R.id.textView);

        // 이벤트 설정
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, ConfigActivity.class);
        startActivity(intent);
    }

    // 액티비티 화면이 뜨기 직전에 자동 호출
    // 설정 파일에서 설정값 읽어오기
    @Override
    protected void onResume() {
        super.onResume();   // 반드시 부모클래스의 원래 기능을 호출해야 한다.
        // CONFIG.xml 파일에서 데이터를 읽기
        // 1) 공통 정보 관리 객체 생성 => (파일이름, 접근 권학)
        SharedPreferences pref = getSharedPreferences("CONFIG", Context.MODE_PRIVATE);
        // 2) 데이터 읽기
        String name = pref.getString("name", "설정 안됨");
        String id = pref.getString("id", "알 수 없음");
        // 3) 결과 출력
        String result = String.format("이름 : %s\n아이디 : %s", name, id);
        textView.setText(result);
    }
}