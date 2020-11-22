package com.example.fragmentexam6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements LeftFragment.OnListItemSelectedListener{
    RightFragment rightFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rightFragment = (RightFragment) getSupportFragmentManager().findFragmentById(R.id.rightFragment);
        // 화면 초기화 : 이벤트 함수 강제 호출
        onListItemSelected(0);
    }

    @Override
    public void onListItemSelected(int position) {
        rightFragment.update(position);
    }
}