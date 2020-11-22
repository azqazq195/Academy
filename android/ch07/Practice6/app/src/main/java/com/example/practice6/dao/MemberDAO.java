package com.example.practice6.dao;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.example.practice6.model.MemberDTO;

import java.util.ArrayList;
import java.util.List;

public class MemberDAO {
    Activity activity;

    // DB 관련 변수
    String dbName = "member.db";
    String tableName = "member";
    SQLiteDatabase database;

    public MemberDAO(Context context) {
        activity = (Activity) context;
        createDatabase();
        createTable();
    }

    // 1. 데이터베이스 만들기
    private void createDatabase() {
        try {
            database = activity.openOrCreateDatabase(dbName, Activity.MODE_PRIVATE, null);
            Toast.makeText(activity, "데이터베이스를 열었습니다.",
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
                Toast.makeText(activity, tableName + " 테이블을 만들었습니다.",
                        Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(activity, "데이터베이스를 먼저 열었야 합니다.",
                        Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // 3. 데이터 추가하기
    public void insertData(MemberDTO member) {
        try {
            // INSERT INTO tableName (name, email, phone, addr)
            // VALUES ('홍길동', 'hong@naver.com', '010-1234-5678', '경기도 수원시');
            if(database != null) {
                String sql = "INSERT INTO " + tableName + " (name, email, phone, addr) "
                        + " VALUES ('" + member.getName() + "', '" + member.getEmail() + "', '"
                        + member.getPhone() + "', '" + member.getAddr() + "');";
                database.execSQL(sql);
                Toast.makeText(activity, "데이터를 추가했습니다.",
                        Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(activity, "데이터베이스를 먼저 열었야 합니다.",
                        Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 4. 데이터 조회하기
    public List<MemberDTO> listData() {
        List<MemberDTO> list = new ArrayList<>();

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
                    list.add(new MemberDTO(name, email, phone, addr));
                }
                cursor.close();
            } else {
                Toast.makeText(activity, "데이터베이스를 먼저 열었야 합니다.",
                        Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}





