package com.example.practice1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.practice1.helper.ObjectInOut;
import com.example.practice1.model.Member;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    LinearLayout[] layouts;
    TextView textViewResult;
    Button btnInput, btnList, btnSave, btnRead, btnOk, btnBack, btnBack2;
    EditText editTextName, editTextEmail, editTextPhone, editTextAddr;
    List<Member> list;
    String fname = getFilesDir().getAbsolutePath() + "/member.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layouts = new LinearLayout[]{
                findViewById(R.id.main_layout),
                findViewById(R.id.input_layout),
                findViewById(R.id.output_layout)
        };

        textViewResult = findViewById(R.id.textViewResult);
        btnInput = findViewById(R.id.btnInput);
        btnList = findViewById(R.id.btnList);
        btnSave = findViewById(R.id.btnSave);
        btnRead = findViewById(R.id.btnRead);
        btnOk = findViewById(R.id.btnOk);
        btnBack = findViewById(R.id.btnBack);
        btnBack2 = findViewById(R.id.btnBack2);
        editTextName = findViewById(R.id.editTextName);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPhone = findViewById(R.id.editTextPhone);
        editTextAddr = findViewById(R.id.editTextAddr);

        list = new ArrayList<>();

        btnInput.setOnClickListener(this);
        btnList.setOnClickListener(this);
        btnSave.setOnClickListener(this);
        btnRead.setOnClickListener(this);
        btnOk.setOnClickListener(this);
        btnBack.setOnClickListener(this);
        btnBack2.setOnClickListener(this);

        // 메인 레이아웃 VISIBLE설정
        visibleLayout(R.id.main_layout);
    }

    // 버튼 이벤트
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnInput:
                visibleLayout(R.id.input_layout);
                break;
            case R.id.btnList:
                visibleLayout(R.id.output_layout);
                listView();
                break;
            case R.id.btnSave:
                save();
                break;
            case R.id.btnRead:
                read();
                break;
            case R.id.btnOk:
                input();
                break;
            case R.id.btnBack:
            case R.id.btnBack2:
                visibleLayout(R.id.main_layout);
                break;
        }
    }

    // 화면 전환 (VISIBLE할 레이아웃)
    public void visibleLayout(int layout) {
        for (LinearLayout layouts : layouts){
            layouts.setVisibility(View.GONE);
        }
        findViewById(layout).setVisibility(View.VISIBLE);
    }

    // 리스트 보여주기
    public void listView() {
        StringBuilder result = new StringBuilder();
        for(Member member : list){
            result.append(member.getName())
                    .append(", ")
                    .append(member.getEmail())
                    .append(", ")
                    .append(member.getPhone())
                    .append(", ")
                    .append(member.getAddr())
                    .append("\n");
        }
        textViewResult.setText(result.toString());
    }

    // 입력
    public void input() {
        String name = editTextName.getText().toString().trim();
        String email = editTextEmail.getText().toString().trim();
        String phone = editTextPhone.getText().toString().trim();
        String addr = editTextAddr.getText().toString().trim();
        list.add(new Member(name, email, phone, addr));
        // 입력 초기화
        editTextName.setText("");
        editTextEmail.setText("");
        editTextPhone.setText("");
        editTextAddr.setText("");
        Toast.makeText(this, "입력 완료", Toast.LENGTH_SHORT).show();
    }

    // 파일 저장
    public void save() {
        boolean resultSave = ObjectInOut.getInstance().write(fname, list);
        String msg = resultSave ? "저장 성공" : "저장 실패";
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    // 파일 불러오기
    public void read() {
        list.clear();   // 모든 데이터 지우기
        list = ObjectInOut.getInstance().read(fname);
        Toast.makeText(this, "파일 불러오기", Toast.LENGTH_SHORT).show();
    }
}