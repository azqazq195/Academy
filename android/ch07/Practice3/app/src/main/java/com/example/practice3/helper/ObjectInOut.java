package com.example.practice3.helper;


import android.util.Log;

import com.example.practice3.model.Member;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class ObjectInOut {
    // 싱글톤 패턴 시작
    private static ObjectInOut instance = null;

    public static ObjectInOut getInstance() {
        if(instance == null) instance = new ObjectInOut();
        return instance;
    }

    private ObjectInOut() {}
    // 싱글톤 패턴 끝

    // 파일 저장
    public boolean write(String fname, List<Member> list){
        boolean result = false;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream(fname);
            oos = new ObjectOutputStream(fos);
            // 데이터 갯수 저장
            oos.writeInt(list.size());
            // 객체 저장
            for(Member member : list){
                oos.writeObject(member);
                oos.flush();
            }
            // 저장 성공
            result = true;
            Log.d("[INFO]", "파일 저장 성공 >> " + fname);
        } catch (FileNotFoundException e) {
            Log.d("[ERROR]", "저장 경로를 찾을 수 없음 >> " + fname);
            e.printStackTrace();
        } catch (IOException e) {
            Log.d("[ERROR]", "파일 저장 실패 >> " + fname);
            e.printStackTrace();
        } catch (Exception e){
            Log.d("[ERROR]", "알 수 없는 에러 >> " + fname);
        } finally {
            try {
                if(oos != null) oos.close();
                if(fos != null) fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    // 파일 읽기
    public List<Member> read(String fname){
        List<Member> list = new ArrayList<>();
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            fis = new FileInputStream(fname);
            ois = new ObjectInputStream(fis);
            // 데이터 갯수 읽기
            int size = ois.readInt();
            // 객체 읽기
            for(int i=0; i<size; i++){
                Member member = (Member) ois.readObject();
                list.add(member);
            }
            Log.d("[INFO]", "파일 읽기 성공 >> " + fname);
        } catch (FileNotFoundException e) {
            Log.d("[ERROR]", "저장 경로를 찾을 수 없음 >> " + fname);
            e.printStackTrace();
        } catch (IOException e) {
            Log.d("[ERROR]", "파일 저장 실패 >> " + fname);
            e.printStackTrace();
        } catch (Exception e){
            Log.d("[ERROR]", "알 수 없는 에러 >> " + fname);
        } finally {
            try {
                if(ois != null) ois.close();
                if(fis != null) fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return list;
    }
    //
}
