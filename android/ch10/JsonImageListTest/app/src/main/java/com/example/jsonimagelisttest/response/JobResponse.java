package com.example.jsonimagelisttest.response;

import android.app.Activity;
import android.app.ProgressDialog;
import android.widget.Toast;

import com.example.jsonimagelisttest.adapter.JobAdapter;
import com.example.jsonimagelisttest.model.Job;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

public class JobResponse extends AsyncHttpResponseHandler {
    Activity activity;
    JobAdapter adapter;
    ProgressDialog dialog;

    public JobResponse(Activity activity, JobAdapter adapter) {
        this.activity = activity;
        this.adapter = adapter;
    }

    @Override
    public void onStart() {
        dialog = new ProgressDialog(activity);
        dialog.setMessage("잠시만 기다려 주세요...");
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
            JSONObject job = json.getJSONObject("job");
            JSONArray item = job.getJSONArray("item");

            for(int a=0; a<item.length(); a++) {
                JSONObject temp = item.getJSONObject(a);
                int num = temp.getInt("num");
                String img_thumb = temp.getString("img_thumb");
                String img = temp.getString("img");
                String subject = temp.getString("subject");
                String content = temp.getString("content");
                // 리스트에 저장
                Job job1 = new Job();
                job1.setNum(num);
                job1.setImg_thumb(img_thumb);
                job1.setImg(img);
                job1.setSubject(subject);
                job1.setContent(content);

                adapter.add(job1);
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
