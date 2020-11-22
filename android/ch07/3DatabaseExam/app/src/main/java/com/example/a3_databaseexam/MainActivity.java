package com.example.a3_databaseexam;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    // 객체 선언
    LinearLayout layout_main, layout_input, layout_list;
    Button button1, button2, buttonInput1, buttonBack1, buttonBack2;
    EditText editTextName, editTextKor, editTextEng, editTextMat;
    TextView textView;

    // DB관련 변수
    String dbName = "student.db";
    String tableName = "score";
    SQLiteDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 객체 초기화
        layout_main = findViewById(R.id.layout_main);
        layout_input = findViewById(R.id.layout_input);
        layout_list = findViewById(R.id.layout_list);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        buttonInput1 = findViewById(R.id.buttonInput1);
        buttonBack1 = findViewById(R.id.buttonBack1);
        buttonBack2 = findViewById(R.id.buttonBack2);
        editTextName = findViewById(R.id.editTextName);
        editTextKor = findViewById(R.id.editTextKor);
        editTextEng = findViewById(R.id.editTextEng);
        editTextMat = findViewById(R.id.editTextMat);
        textView = findViewById(R.id.textView);

        // 이벤트 설정
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        buttonInput1.setOnClickListener(this);
        buttonBack1.setOnClickListener(this);
        buttonBack2.setOnClickListener(this);

        // 화면 초기화
        layout_main.setVisibility(View.VISIBLE);
        layout_input.setVisibility(View.GONE);
        layout_list.setVisibility(View.GONE);
        // DB 설정
        createDatabase();
        createTable();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button1:
                setLayout(layout_input);
                break;
            case R.id.button2:
                setLayout(layout_list);
                break;
            case R.id.buttonInput1:
                break;
            case R.id.buttonBack1:
            case R.id.buttonBack2:
                setLayout(layout_main);
                break;
        }
    }

    private void setLayout(LinearLayout layout){
        layout_main.setVisibility(View.GONE);
        layout_input.setVisibility(View.GONE);
        layout_list.setVisibility(View.GONE);
        layout.setVisibility(View.VISIBLE);
    }

    // 1. Database 만들기 : "student.db" 파일 만들기
    private void createDatabase() {
        try {
            // MODE_PRIVATE : 이 파일은 이 프로젝트 안에서만 쓰겠다.
            database = openOrCreateDatabase(dbName, MODE_PRIVATE, null);
            Toast.makeText(this, dbName + "Database를 열었습니다.", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 2. Table 만들기
    private void createTable() {
        try {
            if(database != null) {
                String sql = "CREATE TABLE if not exists " + tableName + " ("
                        + " _id integer PRIMARY KEY autoincrement, "
                        + " name text, "
                        + " kor integer, "
                        + " eng integer, "
                        + " mat integer, "
                        + " tot integer, "
                        + " avg float); ";
                database.execSQL(sql);
                Toast.makeText(this, tableName + "테이블을 만들었습니다.", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "데이터베이스를 먼저 열어야 합니다.", Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    // 3. 레코드 추가하기
    private void insertData() {
    }

    // 4. 데이터 조회하기
    private void listData() {
    }
}