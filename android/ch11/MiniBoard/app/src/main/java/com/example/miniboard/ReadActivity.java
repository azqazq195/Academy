package com.example.miniboard;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.miniboard.model.Community;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

public class ReadActivity extends AppCompatActivity implements View.OnClickListener {
    TextView textView1, textView2, textView3, textView4;
    Button button1, button2;
    AsyncHttpClient client;
    HttpResponse response;
    String url = "http://192.168.0.96:8080/miniboard/community/community_select.jsp";
    Community item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read);

        textView1 = findViewById(R.id.textView1);
        textView2 = findViewById(R.id.textView2);
        textView3 = findViewById(R.id.textView3);
        textView4 = findViewById(R.id.textView4);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        client = new AsyncHttpClient();
        response = new HttpResponse();
        item = (Community) getIntent().getSerializableExtra("item");
        // 이벤트 설정
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        RequestParams params = new RequestParams();
        params.put("seq", item.getSeq());
        client.post(url, params, response);
    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch (v.getId()) {
            case R.id.button1 : // 삭제하기
                intent = new Intent(this, DeleteActivity.class);
                intent.putExtra("seq", item.getSeq());
                startActivity(intent);
                break;
            case R.id.button2: // 수정하기
                intent = new Intent(this, EditActivity.class);
                intent.putExtra("item", item);
                startActivity(intent);
                break;
        }
    }

    class HttpResponse extends AsyncHttpResponseHandler {
        ProgressDialog dialog;

        @Override
        public void onStart() {
            dialog = new ProgressDialog(ReadActivity.this);
            dialog.setMessage("잠시만 기다려 주세요");
            dialog.setCancelable(false);
            dialog.show();
        }

        @Override
        public void onFinish() {
            dialog.dismiss();
            dialog = null;
        }

        @Override
        public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
            String str = new String(responseBody);
            try {
                JSONObject json = new JSONObject(str);
                String rt = json.getString("rt");
                int total = json.getInt("total");

                if(rt.equals("OK")) {
                    if(total > 0) {
                        JSONArray item1 = json.getJSONArray("item");
                        JSONObject temp = item1.getJSONObject(0);
                        item.setSeq(temp.getInt("seq"));
                        item.setUser_name(temp.getString("user_name"));
                        item.setSubject(temp.getString("subject"));
                        item.setEmail(temp.getString("email"));
                        item.setContent(temp.getString("content"));
                        // 화면 초기화
                        textView1.setText(item.getSubject());
                        textView2.setText(item.getUser_name());
                        textView3.setText(item.getEmail());
                        textView4.setText(item.getContent());
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
            Toast.makeText(ReadActivity.this, "통신 실패", Toast.LENGTH_SHORT).show();
        }
    }
}