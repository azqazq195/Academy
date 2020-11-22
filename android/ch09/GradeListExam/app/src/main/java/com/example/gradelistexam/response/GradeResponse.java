package com.example.gradelistexam.response;

import android.app.Activity;
import android.app.ProgressDialog;
import android.widget.Toast;

import com.example.gradelistexam.adapter.GradeAdapter;
import com.example.gradelistexam.model.Grade;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

public class GradeResponse extends AsyncHttpResponseHandler {
    Activity activity;
    GradeAdapter adapter;
    ProgressDialog dialog;

    public GradeResponse(Activity activity, GradeAdapter adapter) {
        this.activity = activity;
        this.adapter = adapter;
    }

    @Override
    public void onStart() {
       dialog = new ProgressDialog(activity);
       dialog.setMessage("잠시만 기다려주세요...");
       dialog.setCancelable(false);
       dialog.show();
    }

    @Override
    public void onFinish() {
      dialog.dismiss();
      dialog = null;
    }

    @Override
    public void onSuccess(int i, Header[] headers, byte[] bytes) {
        String str = new String(bytes);

        try {
            JSONObject json = new JSONObject(str);
            JSONObject grade = json.getJSONObject("grade");
            JSONArray member = grade.getJSONArray("member");

            for(int a=0; a<member.length(); a++) {
                JSONObject temp = member.getJSONObject(a);
                String name = temp.getString("name");
                int kor = temp.getInt("kor");
                int eng = temp.getInt("eng");
                int math = temp.getInt("math");
                // 리스트에 저장
                adapter.add(new Grade(name, kor, eng, math));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onFailure(int i, Header[] headers, byte[] bytes, Throwable throwable) {
        Toast.makeText(activity, "통신 실패", Toast.LENGTH_SHORT).show();
    }
}
