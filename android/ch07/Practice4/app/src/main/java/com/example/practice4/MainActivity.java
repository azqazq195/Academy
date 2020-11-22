package com.example.practice4;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.practice4.helper.ObjectInOut;
import com.example.practice4.model.Member;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    List<Member> list;
    TextView textView;
    Button button1, button2, button3, button4;
    String fname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fname = getFilesDir().getAbsolutePath() + "/member.txt";
        list = new ArrayList<>();
        textView = findViewById(R.id.textView);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==100){
            if(resultCode==RESULT_OK) {
                list = (List<Member>) data.getSerializableExtra("list");
            }
        }
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch(v.getId()){
            case R.id.button1:
                intent = new Intent(this, InputActivity.class);
                intent.putExtra("list", (Serializable) list);
                startActivityForResult(intent, 100);
                break;
            case R.id.button2:
                intent = new Intent(this, OutputActivity.class);
                intent.putExtra("list", (Serializable) list);
                startActivityForResult(intent, 100);
                break;
            case R.id.button3:
                save();
                break;
            case R.id.button4:
                read();
                break;
        }

    }

    private void save() {
        boolean resultSave = ObjectInOut.getInstance().write(fname, list);
        String msg = resultSave ? "저장 성공" : "저장 실패";
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    private void read() {
        list.clear();   // 모든 데이터 지우기
        list = ObjectInOut.getInstance().read(fname);
        Toast.makeText(this, "파일 불러오기", Toast.LENGTH_SHORT).show();
    }
}