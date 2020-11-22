package com.example.a7_customdialogexam;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button button;
    TextView textView1, textView2;
    EditText editText1, editText2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);

        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button:
                showLoginDialog();
                break;
        }
    }

    private void showLoginDialog() {
        // dialog.xml에 설정된 클래스를 객체화 하기
        final View loginView = getLayoutInflater().inflate(R.layout.dialog, null);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("로그인");
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setCancelable(false);
        // message 영역에 xml 레이아웃을 설정
        builder.setView(loginView);

        // 긍정버튼 추가
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                EditText editText1 = loginView.findViewById(R.id.editText1);
                EditText editText2 = loginView.findViewById(R.id.editText2);
                String user_id = editText1.getText().toString().trim();
                String user_pw = editText2.getText().toString().trim();
                String result = "아이디 : " + user_id + "\n" + "비밀번호 : " + user_pw;

                Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
            }
        });

        // 부정버튼 추가
        builder.setNegativeButton("CANCEL", null);

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}