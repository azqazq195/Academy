package com.example.practice7;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    // 객체 선언
    LinearLayout layoutMain, container;
    Button buttonInput, buttonList, buttonModify, buttonDelete;
    InputFragment inputFragment;
    OutputFragment outputFragment;
    ModifyFragment modifyFragment;
    DeleteFragment deleteFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 객체 초기화
        layoutMain = findViewById(R.id.layoutMain);
        container = findViewById(R.id.container);
        buttonInput = findViewById(R.id.buttonInput);
        buttonList = findViewById(R.id.buttonList);
        buttonModify = findViewById(R.id.buttonModify);
        buttonDelete = findViewById(R.id.buttonDelete);
        inputFragment = new InputFragment();
        outputFragment = new OutputFragment();
        modifyFragment = new ModifyFragment();
        deleteFragment = new DeleteFragment();
        // 이벤트 설정
        buttonInput.setOnClickListener(this);
        buttonList.setOnClickListener(this);
        buttonModify.setOnClickListener(this);
        buttonDelete.setOnClickListener(this);
        // 화면 초기화
        layoutMain.setVisibility(View.VISIBLE);
        container.setVisibility(View.GONE);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonInput:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, inputFragment).commit();
                break;
            case R.id.buttonList:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, outputFragment).commit();
                break;
            case R.id.buttonModify:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, modifyFragment).commit();
                break;
            case R.id.buttonDelete:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, deleteFragment).commit();
                break;
        }
        // 화면 전환
        layoutMain.setVisibility(View.GONE);
        container.setVisibility(View.VISIBLE);
    }
}








