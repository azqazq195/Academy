package com.example.practice6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    LinearLayout layout_main, layout_fragment;
    Button mainBtnInput, mainBtnList;
    InputFragment inputFragment;
    OutputFragment outputFragment;

    String dbName = "member.db";
    String tableName = "member";
    SQLiteDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputFragment = new InputFragment();
        outputFragment = new OutputFragment();

        layout_main = findViewById(R.id.layout_main);
        layout_fragment = findViewById(R.id.layout_fragment);

        mainBtnInput = findViewById(R.id.mainBtnInput);
        mainBtnList = findViewById(R.id.mainBtnList);

        mainBtnInput.setOnClickListener(this);
        mainBtnList.setOnClickListener(this);

        layout_main.setVisibility(View.VISIBLE);
        layout_fragment.setVisibility(View.GONE);

        createDatabase();
        createTable();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.mainBtnInput:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.layout_fragment, inputFragment)
                        .commit();
                layout_main.setVisibility(View.GONE);
                layout_fragment.setVisibility(View.VISIBLE);
                break;
            case R.id.mainBtnList:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.layout_fragment, outputFragment)
                        .commit();
                layout_main.setVisibility(View.GONE);
                layout_fragment.setVisibility(View.VISIBLE);
                break;
        }
    }

    // 1. 데이터베이스 만들기 : "student.db" 파일 만들기
    private void createDatabase() {
        try{
            database = openOrCreateDatabase(dbName, MODE_PRIVATE, null);
            Toast.makeText(this, dbName + "데이터베이스를 열었습니다.", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    // 2. 테이블만들기
    private void createTable() {
        try {
            if(database != null) {
                // 오라클은 seq 객체만들어서 썼지만 여기엔 오토인크리먼트라고 자동으로 늘어나는 기능있음
                String sql = "CREATE TABLE if not exists " +  tableName + " ("
                        + "_id integer PRIMARY KEY autoincrement, "
                        + " name text, "
                        + " email text, "
                        + " phone text, "
                        + " addr text); ";
                database.execSQL(sql);
                Toast.makeText(this, tableName + "테이블을 만들었습니다.", Toast.LENGTH_SHORT).show();
                ;
            } else {
                Toast.makeText(this, "데이터베이스를 먼저 열어야합니다.", Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 3. 레코드 추가하기
    // INSERT into tableName (name, email, phone, addr)
    public void insertData(String name, String email, String phone, String addr) {
        try {
            // 입력검사
            if(name.equals("") || email.equals("") || phone.equals("") || addr.equals("")) {
                Toast.makeText(this, "빈칸을 입력해주세요.", Toast.LENGTH_SHORT).show();
                return;
            }
            if(database != null) {
                String sql = "INSERT into " + tableName + " (name, email, phone, addr)"
                        + " values ('" + name + "', '" + email + "', '" + phone + "', '" + addr + "');";
                database.execSQL(sql);
                Toast.makeText(this, "데이터를 추가했습니다.", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "데이터베이스를 먼저 열어야 합니다.", Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e){
            e.printStackTrace();
        }

    }
    // 4. 데이터 조회하기
    // SELECT name, email, phone, addr FROM tableName;
    public void listData() {
        // TableLayout에 있는 기존 데이터 삭제 (갱신되어야함)
        TableLayout tableLayout = outputFragment.tableLayout;
        tableLayout.removeAllViews();
        // 한줄에 필요한 객체 선언
        TableRow row;
        TextView textViewNameIn, textViewEmainIn, textViewPhoneIn, textViewAddrIn;

        try {
            if(database != null) {
                String sql = "SELECT name, email, phone, addr "
                        + "FROM "+tableName+";";
                Cursor cursor = database.rawQuery(sql, null);
                String result = "Name Email Phone Addr\n";
                for(int i=0; i<cursor.getCount(); i++) {
                    cursor.moveToNext();
                    String name = cursor.getString(0);
                    String email = cursor.getString(1);
                    String phone = cursor.getString(2);
                    String addr = cursor.getString(3);
//                    result += String.format("%3d%10s%4d%4d%4d%5d%5.1f\n", i+1, name, kor, eng, mat, tot, avg);
                    // TableRow 객체화
                    row = (TableRow) getLayoutInflater().inflate(R.layout.table_row, null);
                    textViewNameIn = row.findViewById(R.id.textViewNameIn);
                    textViewEmainIn = row.findViewById(R.id.textViewEmailIn);
                    textViewPhoneIn = row.findViewById(R.id.textViewPhoneIn);
                    textViewAddrIn = row.findViewById(R.id.textViewAddrIn);

                    textViewNameIn.setText(name);
                    textViewEmainIn.setText(email);
                    textViewPhoneIn.setText(phone);
                    textViewAddrIn.setText(addr);

                    // TableLayout에 추가
                    tableLayout.addView(row);
                }
//                textViewList.setText(result);
                cursor.close();
                Toast.makeText(this, "데이터를 조회했습니다.", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "데이터베이스를 먼저 열어야합니다.", Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}