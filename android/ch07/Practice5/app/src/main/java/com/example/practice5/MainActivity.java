package com.example.practice5;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    // 객체 선언
    Button buttonInput, buttonList;
    Button buttonInput2, buttonBack2;
    EditText editTextName, editTextEmail, editTextPhone, editTextAddr;
    Button buttonBack3;
    TableLayout tableLayout;
    LinearLayout layoutMain, layoutInput, layoutList;
    // DB 관련 변수
    String dbName = "member.db";
    String tableName = "member";
    SQLiteDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 객체 초기화
        layoutMain = findViewById(R.id.layoutMain);
        layoutInput = findViewById(R.id.layoutInput);
        layoutList = findViewById(R.id.layoutList);
        // main
        buttonInput = findViewById(R.id.buttonInput);
        buttonList = findViewById(R.id.buttonList);
        // input
        buttonInput2 = findViewById(R.id.buttonInput2);
        buttonBack2 = findViewById(R.id.buttonBack2);
        editTextName = findViewById(R.id.editTextName);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPhone = findViewById(R.id.editTextPhone);
        editTextAddr = findViewById(R.id.editTextAddr);
        // list
        buttonBack3 = findViewById(R.id.buttonBack3);
        tableLayout = findViewById(R.id.tableLayout);

        // 이벤트 설정
        buttonInput.setOnClickListener(this);
        buttonList.setOnClickListener(this);
        buttonInput2.setOnClickListener(this);
        buttonBack2.setOnClickListener(this);
        buttonBack3.setOnClickListener(this);

        // 화면 초기화
        layoutMain.setVisibility(View.VISIBLE);
        layoutInput.setVisibility(View.GONE);
        layoutList.setVisibility(View.GONE);
        // DB 설정
        createDatabase();
        createTable();
    }
    // 1. 데이터베이스 만들기
    private void createDatabase() {
        try {
            database = openOrCreateDatabase(dbName, MODE_PRIVATE, null);
            Toast.makeText(this, "데이터베이스를 열었습니다.",
                    Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // 2. 테이블 만들기
    private void createTable() {
        try {
            if(database != null) {
                String sql = "CREATE TABLE if not exists " + tableName + " ("
                        + " _id integer PRIMARY KEY autoincrement, "
                        + " name text, "
                        + " email text, "
                        + " phone text, "
                        + " addr text);";
                database.execSQL(sql);
                Toast.makeText(this, tableName + " 테이블을 만들었습니다.",
                        Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "데이터베이스를 먼저 열었야 합니다.",
                        Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // 3. 데이터 추가하기
    private void insertData() {
        try {
            String name = editTextName.getText().toString().trim();
            String email = editTextEmail.getText().toString().trim();
            String phone = editTextPhone.getText().toString().trim();
            String addr = editTextAddr.getText().toString().trim();
            if(name.equals("") || email.equals("") || phone.equals("") || addr.equals("")) {
                Toast.makeText(this, "모두 입력하세요", Toast.LENGTH_SHORT).show();
                return;
            }
            // INSERT INTO tableName (name, email, phone, addr)
            // VALUES ('홍길동', 'hong@naver.com', '010-1234-5678', '경기도 수원시');
            if(database != null) {
                String sql = "INSERT INTO " + tableName + " (name, email, phone, addr) "
                        + " VALUES ('" + name + "', '" + email + "', '"
                        + phone + "', '" + addr + "');";
                database.execSQL(sql);
                Toast.makeText(this, "데이터를 추가했습니다.",
                        Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "데이터베이스를 먼저 열었야 합니다.",
                        Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 4. 데이터 조회하기
    private void listData() {
        // TableLayout에 있는 기존 데이터 삭제
        tableLayout.removeAllViews();

        try {
            // SELECT name, email, phone, addr From tableName;
            if(database != null) {
                String sql = "SELECT name, email, phone, addr From " + tableName + ";";
                Cursor cursor = database.rawQuery(sql, null);

                while(cursor.moveToNext()) {
                    String name = cursor.getString(0);
                    String email = cursor.getString(1);
                    String phone = cursor.getString(2);
                    String addr = cursor.getString(3);

                    TableRow row = (TableRow) getLayoutInflater().inflate(R.layout.table_row, null);
                    TextView textViewName = row.findViewById(R.id.textViewName);
                    TextView textViewEmail = row.findViewById(R.id.textViewEmail);
                    TextView textViewPhone = row.findViewById(R.id.textViewPhone);
                    TextView textViewAddr = row.findViewById(R.id.textViewAddr);

                    textViewName.setText(name);
                    textViewEmail.setText(email);
                    textViewPhone.setText(phone);
                    textViewAddr.setText(addr);
                    // TableLayout에 추가
                    tableLayout.addView(row);
                }
                cursor.close();
            } else {
                Toast.makeText(this, "데이터베이스를 먼저 열었야 합니다.",
                        Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonInput:
                // 화면 전환
                layoutMain.setVisibility(View.GONE);
                layoutInput.setVisibility(View.VISIBLE);
                layoutList.setVisibility(View.GONE);
                break;
            case R.id.buttonList:
                listData();
                // 화면 전환
                layoutMain.setVisibility(View.GONE);
                layoutInput.setVisibility(View.GONE);
                layoutList.setVisibility(View.VISIBLE);
                break;
            case R.id.buttonInput2:
                insertData();
                editTextName.setText("");
                editTextEmail.setText("");
                editTextPhone.setText("");
                editTextAddr.setText("");
                break;
            case R.id.buttonBack2:
                // 화면 전환
                layoutMain.setVisibility(View.VISIBLE);
                layoutInput.setVisibility(View.GONE);
                layoutList.setVisibility(View.GONE);
                break;
            case R.id.buttonBack3:
                // 화면 전환
                layoutMain.setVisibility(View.VISIBLE);
                layoutInput.setVisibility(View.GONE);
                layoutList.setVisibility(View.GONE);
                break;
        }
    }
}







