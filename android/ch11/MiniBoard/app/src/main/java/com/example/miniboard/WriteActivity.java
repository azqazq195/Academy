package com.example.miniboard;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.miniboard.model.Community;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

public class WriteActivity extends AppCompatActivity implements View.OnClickListener {
    EditText editText1, editText2, editText3, editText4, editText5;
    Button button1, button2;
    AsyncHttpClient client;
    HttpResponse response;
    String url = "http://192.168.0.96:8080/miniboard/community/community_insert.jsp";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write);

        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);
        editText3 = findViewById(R.id.editText3);
        editText4 = findViewById(R.id.editText4);
        editText5 = findViewById(R.id.editText5);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        client = new AsyncHttpClient();
        response = new HttpResponse();

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button1:
                String user_name = editText1.getText().toString().trim();
                String user_pwd = editText2.getText().toString().trim();
                String email = editText3.getText().toString().trim();
                String subject = editText4.getText().toString().trim();
                String content = editText5.getText().toString().trim();
                // 입력검사
                String msg = null;
                if(msg==null && user_name.equals("")) {
                    msg = "이름을 입력해 주세요";
                } else if(msg==null && user_pwd.equals("")) {
                    msg = "비밀번호을 입력해 주세요";
                } else if(msg==null && email.equals("")) {
                    msg = "이메일을 입력해 주세요";
                } else if(msg==null && subject.equals("")) {
                    msg = "제목을 입력해 주세요";
                } else if(msg==null && content.equals("")) {
                    msg = "내용을 입력해 주세요";
                }

                // 입력값 없는 항목이 있을 경우
                if(msg != null) {
                    Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
                    return;
                }
                // 요청 및 데이터 전송
                RequestParams params = new RequestParams();
                params.put("user_name", user_name);
                params.put("user_pwd", user_pwd);
                params.put("email", email);
                params.put("subject", subject);
                params.put("content", content);

                client.post(url, params, response);
                break;
            case R.id.button2:
                finish();
                break;
        }
    }

    class HttpResponse extends AsyncHttpResponseHandler {
        ProgressDialog dialog;

        @Override
        public void onStart() {
            dialog = new ProgressDialog(WriteActivity.this);
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
                if(rt.equals("OK")) {
                    finish();  // 이전 화면으로 돌아가기
                } else {
                    Toast.makeText(WriteActivity.this, "저장 실패", Toast.LENGTH_SHORT).show();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
            Toast.makeText(WriteActivity.this, "통신 실패", Toast.LENGTH_SHORT).show();
        }
    }
}