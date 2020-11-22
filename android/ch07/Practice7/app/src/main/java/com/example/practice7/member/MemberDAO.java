package com.example.practice7.member;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.practice7.MainActivity;
import com.example.practice7.R;

import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {

    String dbName = "member.db";
    String tableName = "member";
    SQLiteDatabase database;
    Activity activity;
    Member member;

    public MemberDAO(Context context){
        activity = (Activity) context;
        createDatabase();
        createTable();
    }

    // 1. 데이터베이스 만들기 : "student.db" 파일 만들기
    private void createDatabase() {
        try{
            database = activity.openOrCreateDatabase(dbName, Context.MODE_PRIVATE, null);
            // Toast.makeText(activity, dbName + "데이터베이스를 열었습니다.", Toast.LENGTH_SHORT).show();
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
                // Toast.makeText(activity, tableName + "테이블을 만들었습니다.", Toast.LENGTH_SHORT).show();
            } else {
                // Toast.makeText(activity, "데이터베이스를 먼저 열어야합니다.", Toast.LENGTH_SHORT).show();
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
                Toast.makeText(activity, "빈칸을 입력해주세요.", Toast.LENGTH_SHORT).show();
                return;
            }
            if(database != null) {
                String sql = "INSERT into " + tableName + " (name, email, phone, addr)"
                        + " values ('" + name + "', '" + email + "', '" + phone + "', '" + addr + "');";
                database.execSQL(sql);
                Log.d("[TEST]", "데이터 추가 완료");
                Toast.makeText(activity, "데이터를 추가했습니다.", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(activity, "데이터베이스를 먼저 열어야 합니다.", Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e){
            e.printStackTrace();
        }

    }
    // 4. 데이터 조회하기
    // SELECT name, email, phone, addr FROM tableName;
    public List<MemberDTO> listData() {
        TableRow row;
        TextView textViewNameIn, textViewEmainIn, textViewPhoneIn, textViewAddrIn;
        List<MemberDTO> list = new ArrayList<>();
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

                    MemberDTO member = new MemberDTO(name, email, phone, addr);
                    list.add(member);

                }
//                textViewList.setText(result);
                cursor.close();
                // Toast.makeText(activity, "데이터를 조회했습니다.", Toast.LENGTH_SHORT).show();
            } else {
                // Toast.makeText(activity, "데이터베이스를 먼저 열어야합니다.", Toast.LENGTH_SHORT).show();
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    // 5. 이름 있나 확인
    public MemberDTO getData(String searchName) {
        try {
            if(database != null){
                String sql = "SELECT name, email, phone, addr "
                        + "FROM "+tableName
                        + " WHERE name = '"
                        + searchName
                        + "';";
                Cursor cursor = database.rawQuery(sql, null);
                if(cursor.getCount() > 0) {
                    cursor.moveToNext();
                    String name = cursor.getString(0);
                    String email = cursor.getString(1);
                    String phone = cursor.getString(2);
                    String addr = cursor.getString(3);

                    MemberDTO member = new MemberDTO(name, email, phone, addr);
                    // Toast.makeText(activity, "데이터를 조회했습니다.", Toast.LENGTH_SHORT).show();
                    cursor.close();
                    return member;
                } else {
                    Toast.makeText(activity, searchName + "님이 없습니다.", Toast.LENGTH_SHORT).show();
                    cursor.close();
                    return null;
                }

            } else {
                // Toast.makeText(activity, "데이터베이스를 먼저 열어야 합니다.", Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // 데이터 수정
    public void modifyData(MemberDTO member) {
        String name = member.getName();
        String email = member.getEmail();
        String phone = member.getPhone();
        String addr = member.getAddr();
        try {
            // 입력검사
            if(name.equals("") || email.equals("") || phone.equals("") || addr.equals("")) {
                Toast.makeText(activity, "빈칸을 입력해주세요.", Toast.LENGTH_SHORT).show();
                return;
            }
            if(database != null) {
                // UPDATA tableName SET name = name, email = email, phone = phone, addr = addr WHERE name = name;
                String sql = "UPDATE " + tableName +
                        " SET name = " + name
                        + ", email = " + email
                        + ", phone = " + phone
                        + ", addr = " + addr
                        + " WHERE name = " + name + ";";
                database.execSQL(sql);
                Toast.makeText(activity, "데이터를 수정했습니다.", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(activity, "데이터베이스를 먼저 열어야 합니다.", Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    // 데이터 삭제
    public void deleteData(String searchName) {
        String sql = "DELETE FROM " + tableName + " WHERE name='" + searchName + "';";

        if(database != null) {
            try {
                database.execSQL(sql);
                // Toast.makeText(activity , "삭제 완료" , Toast.LENGTH_SHORT).show();
            } catch (Exception e) {
                Toast.makeText(activity , "삭제 실패" , Toast.LENGTH_SHORT).show();
            }
        }
    }
}
