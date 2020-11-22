package com.example.a4_jsonlistexam.response;

import android.app.Activity;
import android.app.ProgressDialog;
import android.widget.Toast;

import com.example.a4_jsonlistexam.adapter.DeviceAdapter;
import com.example.a4_jsonlistexam.model.Device;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

public class DeviceResponse extends AsyncHttpResponseHandler {
    Activity activity;
    DeviceAdapter adapter;
    ProgressDialog dialog;

    public DeviceResponse(Activity activity, DeviceAdapter adapter) {
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
            JSONArray device = json.getJSONArray("device");

            for(int a = 0 ; a < device.length() ; a++) {
                JSONObject temp = device.getJSONObject(a);
                String name = temp.getString("name");
                String type = temp.getString("type");
                // 어댑터를 통해서, 리스트에 데이터 저장
                adapter.add(new Device(name, type));
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
