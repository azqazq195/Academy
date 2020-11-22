package com.example.a3_databaseexam1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
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
    LinearLayout[] layouts;
    LinearLayout layoutMain, layoutInput, layoutList, layoutModify;
    Button button1, button2, button3, buttonInput1, buttonModify1, buttonBack1, buttonBack2, buttonBack3;
    EditText editTextName, editTextKor, editTextEng, editTextMat,
            editTextName1, editTextKor1, editTextEng1, editTextMat1;
    TableLayout tableLayout;

    // DB 관련 변수
    String dbName = "student.db";
    String tableName = "score";
    SQLiteDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layoutMain = findViewById(R.id.layoutMain);
        layoutInput = findViewById(R.id.layoutInput);
        layoutList = findViewById(R.id.layoutList);
        layoutModify = findViewById(R.id.layoutModify);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        buttonInput1 = findViewById(R.id.buttonInput1);
        buttonModify1 = findViewById(R.id.buttonModify1);
        buttonBack1 = findViewById(R.id.buttonBack1);
        buttonBack2 = findViewById(R.id.buttonBack2);
        buttonBack3 = findViewById(R.id.buttonBack3);
        editTextName = findViewById(R.id.editTextName);
        editTextName1 = findViewById(R.id.editTextName1);
        editTextKor = findViewById(R.id.editTextKor);
        editTextKor1 = findViewById(R.id.editTextKor1);
        editTextEng = findViewById(R.id.editTextEng);
        editTextEng1 = findViewById(R.id.editTextEng1);
        editTextMat = findViewById(R.id.editTextMat);
        editTextMat1 = findViewById(R.id.editTextMat1);
        tableLayout = findViewById(R.id.tableLayout);

        //이벤트 설정
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        buttonInput1.setOnClickListener(this);
        buttonModify1.setOnClickListener(this);
        buttonBack1.setOnClickListener(this);
        buttonBack2.setOnClickListener(this);
        buttonBack3.setOnClickListener(this);

        //화면 초기화
        layouts = new LinearLayout[]{
                layoutMain, layoutInput, layoutModify, layoutList
        };
        setLayout(layoutMain);

        createDatabase();
        createTable();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button1:                  //입력화면이동
                setLayout(layoutInput);
                break;
            case R.id.button2:                  // 출력화면이동
                listData();
                setLayout(layoutList);
                break;
            case R.id.button3:                  // 출력화면이동
                setModify();
                break;
            case R.id.buttonInput1:             // 입력값을 DB에 저장
                insertData();
                editTextName.setText("");
                editTextKor.setText("");
                editTextEng.setText("");
                editTextMat.setText("");
                break;
            case R.id.buttonModify1:            // 데이터 수정
                modifyData();
                break;
            case R.id.buttonBack1:              // 메인화면이동
            case R.id.buttonBack2:
            case R.id.buttonBack3:
                setLayout(layoutMain);
                break;
        }
    }

    private void modifyData() {
        try {
            String name = editTextName1.getText().toString().trim();
            String strKor = editTextKor1.getText().toString().trim();
            String strEng = editTextEng1.getText().toString().trim();
            String strMat = editTextMat1.getText().toString().trim();

            // 입력검사
            if(strKor.equals("") || strEng.equals("") || strMat.equals("")) {
                Toast.makeText(this, "점수를 입력해주세요.", Toast.LENGTH_SHORT).show();
                return;
            }
            int kor = Integer.parseInt(strKor);
            int eng = Integer.parseInt(strEng);
            int mat = Integer.parseInt(strMat);
            int tot = kor + eng + mat;
            float avg = (float) tot/3;
            if(database != null) {
                String sql = "UPDATE " + tableName
                        +" SET kor =" + kor + ", eng=" + eng + ", mat=" + mat + ", tot="
                        + tot + ", avg=" + avg + " WHERE name ='" + name + "';";
                database.execSQL(sql);
                Toast.makeText(this, "데이터를 수정했습니다.", Toast.LENGTH_SHORT).show();

            } else {
                Toast.makeText(this, "데이터베이스를 먼저 열어야합니다.", Toast.LENGTH_SHORT).show();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setModify() {
        final View modifyView = getLayoutInflater().inflate(R.layout.layout_dialog, null);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("수정");
        builder.setIcon(android.R.drawable.btn_star);
        builder.setView(modifyView);
        builder.setCancelable(false);

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                EditText editText = modifyView.findViewById(R.id.editText);
                String name = editText.getText().toString().trim();
                // 입력 검사
                if(name.equals("")) {
                    Toast.makeText(getApplicationContext(), "이름을 입력하세요.", Toast.LENGTH_SHORT).show();
                    return; // 강제 종료
                }
                // 이름으로 데이터 확인
                getData(name);
            }
        });
        // 부정버튼 추가
        builder.setNegativeButton("CANCEL", null);
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    // 개별데이터 조회하기
    // SELECT kor, eng, mat FROM tableName
    // WHERE name = 'name';
    private void getData(String name) {
        try {
            if(database != null){
                String sql =
                        "SELECT kor, eng, mat FROM "
                        + tableName
                        + " WHERE name = '"
                        + name
                        + "';";
                Cursor cursor = database.rawQuery(sql, null);
                if(cursor.getCount() > 0) {
                    cursor.moveToNext();
                    int kor = cursor.getInt(0);
                    int eng = cursor.getInt(1);
                    int mat = cursor.getInt(2);

                    editTextName1.setText(name);
                    editTextKor1.setText(String.valueOf(kor));
                    editTextEng1.setText(String.valueOf(eng));
                    editTextMat1.setText(String.valueOf(mat));

                    // 화면 전환
                    setLayout(layoutModify);
                    Toast.makeText(this, "데이터를 조회했습니다.", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, name + "님이 없습니다.", Toast.LENGTH_SHORT).show();
                }
                cursor.close();
            } else {
                Toast.makeText(this, "데이터베이스를 먼저 열어야 합니다.", Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void setLayout(LinearLayout layout){
        for(LinearLayout layouts: layouts) layouts.setVisibility(View.GONE);
        layout.setVisibility(View.VISIBLE);
    }



    // 3. 레코드 추가하기
    // INSERT into tableName (name, kor, eng, mat, tot, avg)
    // values ('홍길동', kor, eng, mat, tot, avg);
    public void insertData() {
        try {
            String name = editTextName.getText().toString().trim();
            String strKor = editTextKor.getText().toString().trim();
            String strEng = editTextEng.getText().toString().trim();
            String strMat = editTextMat.getText().toString().trim();
            // 입력검사
            if(strKor.equals("") || strEng.equals("") || strMat.equals("")) {
                Toast.makeText(this, "점수를 입력해주세요.", Toast.LENGTH_SHORT).show();
                return;
            }
            int kor = Integer.parseInt(strKor);
            int eng = Integer.parseInt(strEng);
            int mat = Integer.parseInt(strMat);
            int tot = kor + eng + mat;
            float avg = (float) tot/3;
            if(database != null) {
                String sql = "INSERT into "+tableName+" (name, kor, eng, mat, tot, avg)"
                        + " values ('" + name + "', " + kor + ", " + eng + ", " + mat + " , " + tot + ", " + avg + ");";       // 세미콜론을 하고 또해야함.
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
    // SELECT name, kor, eng, mat, tot, avg FROM tableName;
    public void listData() {
        // TableLayout에 있는 기존 데이터 삭제 (갱신되어야함)
        tableLayout.removeAllViews();
        // 한줄에 필요한 객체 선언
        TableRow row;
        TextView textViewNo, textViewName, textViewKor, textViewEng, textViewMat, textViewTot, textViewAvg;

        try {
            if(database != null) {
                String sql = "SELECT name, kor, eng, mat, tot, avg "
                        + "FROM "+tableName+";";
                Cursor cursor = database.rawQuery(sql, null);
                String result = "Number Name Kor Eng Mat Tot Avg\n";
                for(int i=0; i<cursor.getCount(); i++) {
                    cursor.moveToNext();
                    String name = cursor.getString(0);
                    int kor = cursor.getInt(1);
                    int eng = cursor.getInt(2);
                    int mat = cursor.getInt(3);
                    int tot = cursor.getInt(4);
                    float avg = cursor.getInt(5);
//                    result += String.format("%3d%10s%4d%4d%4d%5d%5.1f\n", i+1, name, kor, eng, mat, tot, avg);
                    // TableRow 객체화
                    row = (TableRow) getLayoutInflater().inflate(R.layout.table_row, null);
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
                    textViewAvg.setText(String.valueOf(avg));

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
                        + " kor integer, "
                        + " eng integer, "
                        + " mat integer, "
                        + " tot integer, "
                        + " avg float); ";
                database.execSQL(sql);
                Toast.makeText(this, tableName + "테이블을 만들었습니다.", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "데이터베이스를 먼저 열어야합니다.", Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}