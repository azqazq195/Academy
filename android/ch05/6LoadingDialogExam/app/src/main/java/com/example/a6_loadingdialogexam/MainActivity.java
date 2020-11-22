package com.example.a6_loadingdialogexam;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button button1, button2, button3;
    LinearLayout layout_progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        layout_progress = findViewById(R.id.layout_progress);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        layout_progress.setOnClickListener(this);
        // 화면 초기화
        layout_progress.setVisibility(View.GONE);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button1:
                showLoadingDialog();
                break;
            case R.id.button2:
                showTransLoadigDialog();
                break;
            case R.id.button3:
                showLoadingDialog2();
                break;
            case R.id.layout_progress:
                layout_progress.setVisibility(View.GONE);
                break;
        }

    }

    // 일반적인 로딩창
    private void showLoadingDialog() {
        ProgressDialog dialog = new ProgressDialog(this);
        dialog.setMessage("잠시만 기다려주세요...");
        // 창이 없어질 떄의 이벤트 처리 : 필요시 사용
        dialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialog) {
                Toast.makeText(getApplicationContext(), "로딩 취소됨", Toast.LENGTH_SHORT).show();
            }
        });
        dialog.show();
    }

    // 아이폰 스타일 로딩창
    private void showTransLoadigDialog() {
        // Dialog 클래스를 개조해서 사용
        Dialog dialog = new Dialog(this, R.style.transDialog);
        ProgressBar progressBar = new ProgressBar(this);
        dialog.addContentView(progressBar, new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        ));
        dialog.show();
    }

    private void showLoadingDialog2() {
        layout_progress.setVisibility(View.VISIBLE);
    }
}