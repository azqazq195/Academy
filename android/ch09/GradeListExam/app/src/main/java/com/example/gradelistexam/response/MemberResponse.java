package com.example.gradelistexam.response;

import android.app.Activity;
import android.app.ProgressDialog;
import android.util.Log;
import android.widget.Toast;

import com.example.gradelistexam.adapter.MemberAdapter;
import com.example.gradelistexam.medel.Member;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

public class MemberResponse extends AsyncHttpResponseHandler {
    Activity activity;
    MemberAdapter adapter;
    ProgressDialog dialog;

    public MemberResponse(Activity activity, MemberAdapter adapter) {
        this.activity = activity;
        this.adapter = adapter;
    }

    // 통신 시작시 호출
    @Override
    public void onStart() {
        dialog = new ProgressDialog(activity);
        dialog.setMessage("잠시만 기다려 주세요...");
        dialog.setCancelable(false);
        dialog.show();
    }

    // 통신 종료시 호출
    @Override
    public void onFinish() {
        dialog.dismiss();
        dialog = null;
    }

    // 200 코드 응답
    @Override
    public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
        String str = new String(responseBody);
        try {
            JSONObject json = new JSONObject(str);
            JSONObject grade = json.getJSONObject("grade");
            JSONArray member = grade.getJSONArray("member");
            for(int a = 0 ; a < member.length() ; a++) {
                JSONObject temp = member.getJSONObject(a);
                String name = temp.getString("name");
                int kor = temp.getInt("kor");
                int eng = temp.getInt("eng");
                int mat = temp.getInt("mat");
                // 어댑터를 통해서, 리스트에 데이터 저장
                adapter.add(new Member(name, kor, eng, mat));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    // 200 코드 아닌 것 응답
    @Override
    public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
        Toast.makeText(activity, "통신 실패", Toast.LENGTH_SHORT).show();
    }
}
