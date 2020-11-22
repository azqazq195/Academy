package com.example.a1_jsonimagelistexam.response;

import android.app.Activity;
import android.app.ProgressDialog;
import android.widget.Toast;

import com.example.a1_jsonimagelistexam.adapter.ColumnAdapter;
import com.example.a1_jsonimagelistexam.model.Column;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

public class ColumnResponse extends AsyncHttpResponseHandler {
    Activity activity;
    ColumnAdapter adapter;
    ProgressDialog dialog;

    public ColumnResponse(Activity activity, ColumnAdapter adapter) {
        this.activity = activity;
        this.adapter = adapter;
    }

    @Override
    public void onStart() {
        dialog = new ProgressDialog(activity);
        dialog.setMessage("기달");
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
            JSONObject column = json.getJSONObject("column");
            JSONArray item = column.getJSONArray("item");
            for(int a=0; a<item.length(); a++) {
                JSONObject temp = item.getJSONObject(a);
                int num = temp.getInt("num");
                String img = temp.getString("img");
                String subject = temp.getString("subject");
                String content = temp.getString("content");
                // 리스트에 저장
                adapter.add(new Column(num, img, subject, content));
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