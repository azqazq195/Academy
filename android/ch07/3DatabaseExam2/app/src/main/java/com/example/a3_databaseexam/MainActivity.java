package com.example.a3_databaseexam;

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

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    // 객체 선언
    LinearLayout layoutMain, layoutInput, layoutList;
    Button button1, button2, buttonInput1, buttonBack1, buttonBack2;
    EditText editTextName, editTextKor, editTextEng, editTextMat;
    TableLayout tableLayout;
    // DB 관련 변수
    String dbName = "student.db";
    String tableName = "score";
    SQLiteDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 객체 초기화
        layoutMain = findViewById(R.id.layoutMain);
        layoutInput = findViewById(R.id.layoutInput);
        layoutList  = findViewById(R.id.layoutList);
        button1  = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        buttonInput1 = findViewById(R.id.buttonInput1);
        buttonBack1 = findViewById(R.id.buttonBack1);
        buttonBack2 = findViewById(R.id.buttonBack2);
        editTextName = findViewById(R.id.editTextName);
        editTextKor = findViewById(R.id.editTextKor);
        editTextEng = findViewById(R.id.editTextEng);
        editTextMat = findViewById(R.id.editTextMat);
        tableLayout = findViewById(R.id.tableLayout);
        // 이벤트 설정
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        buttonInput1.setOnClickListener(this);
        buttonBack1.setOnClickListener(this);
        buttonBack2.setOnClickListener(this);
        // 화면 초기화
        layoutMain.setVisibility(View.VISIBLE);
        layoutInput.setVisibility(View.GONE);
        layoutList.setVisibility(View.GONE);
        // DB 설정
        createDatabase();
        createTable();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button1:  // 입력 화면 이동
                // 화면 전환
                layoutMain.setVisibility(View.GONE);
                layoutInput.setVisibility(View.VISIBLE);
                layoutList.setVisibility(View.GONE);
                break;
            case R.id.button2:  // 출력 화면 이동
                listData();
                // 화면 전환
                layoutMain.setVisibility(View.GONE);
                layoutInput.setVisibility(View.GONE);
                layoutList.setVisibility(View.VISIBLE);
                break;
            case R.id.buttonInput1: // 입력값을 DB에 저장
                insertData();
                editTextName.setText("");
                editTextKor.setText("");
                editTextEng.setText("");
                editTextMat.setText("");
                break;
            case R.id.buttonBack1:  // 메인 화면 이동
                layoutMain.setVisibility(View.VISIBLE);
                layoutInput.setVisibility(View.GONE);
                layoutList.setVisibility(View.GONE);
                break;
            case R.id.buttonBack2:  // 메인 화면 이동
                layoutMain.setVisibility(View.VISIBLE);
                layoutInput.setVisibility(View.GONE);
                layoutList.setVisibility(View.GONE);
                break;
        }
    }
    // 1. 데이터베이스 만들기 : "student.db" 파일 만들기
    private void createDatabase() {
        try {
            database = openOrCreateDatabase(dbName, MODE_PRIVATE, null);
            Toast.makeText(this, dbName + " 데이터베이스를 열었습니다.",
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
                        + " kor integer, "
                        + " eng integer, "
                        + " mat integer, "
                        + " tot integer, "
                        + " avg float);";
                database.execSQL(sql);
                Toast.makeText(this, tableName + " 테이블을 만들었습니다.",
                        Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "데이터베이스를 먼저 열어야 합니다.",
                        Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // 3. 레코드 추가하기
    // INSERT INTO tableName (name, kor, eng, mat, tot, avg)
    // values ('홍길동', kor, eng, mat, tot, avg);
    private void insertData() {
        try {
            String name = editTextName.getText().toString().trim();
            String  strKor = editTextKor.getText().toString().trim();
            String  strEng = editTextEng.getText().toString().trim();
            String  strMat = editTextMat.getText().toString().trim();
            // 입력 검사
            if(strKor.equals("") || strEng.equals("") || strMat.equals("")) {
                Toast.makeText(this, "점수를 입력해주세요",
                        Toast.LENGTH_SHORT).show();
                return;
            }
            int kor = Integer.parseInt(strKor);
            int eng = Integer.parseInt(strEng);
            int mat = Integer.parseInt(strMat);
            int tot = kor + eng + mat;
            float avg = (float) tot / 3;

            if(database != null) {
                String sql = "INSERT INTO " + tableName
                        + " (name, kor, eng, mat, tot, avg) "
                        + " values ('" + name + "', " + kor + ", "
                        + eng + ", " + mat + ", " + tot + ", " + avg + ");";
                database.execSQL(sql);
                Toast.makeText(this, "데이터를 추가했습니다.",
                        Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "데이터베이스를 먼저 열어야 합니다.",
                        Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // 4. 데이터 조회하기
    // SELECT name, kor, eng, mat, tot, avg FROM tableName;
    private void listData() {
        // TableLayout에 있는 기존 데이터 삭제
        tableLayout.removeAllViews();
        // 1줄에 필요한 객체 선언
        TableRow row;
        TextView textViewNo, textViewName, textViewKor;
        TextView textViewEng, textViewMat, textViewTot, textViewAvg;

        try {
            if(database != null) {
                String sql = "SELECT name, kor, eng, mat, tot, avg "
                        + " FROM " + tableName + ";";
                Cursor cursor = database.rawQuery(sql, null);

                String result = "no      name  kor eng mat  tot  avg\n";
                for(int i=0; i<cursor.getCount(); i++) {
                    cursor.moveToNext();
                    String name = cursor.getString(0);
                    int kor = cursor.getInt(1);
                    int eng = cursor.getInt(2);
                    int mat = cursor.getInt(3);
                    int tot = cursor.getInt(4);
                    float avg = cursor.getInt(5);
                    // TableRow 객체화
                    row = (TableRow) getLayoutInflater()
                            .inflate(R.layout.table_row, null);
                    textViewNo = row.findViewById(R.id.textViewNo);
                    textViewName = row.findViewById(R.id.textViewName);
                    textViewKor = row.findViewById(R.id.textViewKor);
                    textViewEng = row.findViewById(R.id.textViewEng);
                    textViewMat = row.findViewById(R.id.textViewMat);
                    textViewTot = row.findViewById(R.id.textViewTot);
                    textViewAvg = row.findViewById(R.id.textViewAvg);

                    textViewNo.setText(String.valueOf(i+1));
                    textViewName.setText(name);
                    textViewKor.setText(String.valueOf(kor));
                    textViewEng.setText(String.valueOf(eng));
                    textViewMat.setText(String.valueOf(mat));
                    textViewTot.setText(String.valueOf(tot));
                    textViewAvg.setText(String.format("%.1f",avg));
                    // TableLayout에 추가
                    tableLayout.addView(row);
                }
                cursor.close();
                Toast.makeText(this, "데이터를 조회했습니다.",
                        Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "데이터베이스를 먼저 열어야 합니다.",
                        Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}



