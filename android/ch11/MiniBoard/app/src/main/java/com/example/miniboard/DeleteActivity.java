package com.example.miniboard;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

public class DeleteActivity extends AppCompatActivity implements View.OnClickListener {
    TextView textView;
    EditText editText;
    Button button1, button2;
    AsyncHttpClient client;
    HttpResponse response;
    String url = "http://192.168.0.96:8080/miniboard/community/community_delete.jsp";
    int seq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);

        textView = findViewById(R.id.textView);
        editText = findViewById(R.id.editText);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        client = new AsyncHttpClient();
        response = new HttpResponse();
        seq = getIntent().getIntExtra("seq", 0);
        // 이벤트 설정
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);

        // 화면 설정
        String text = String.format(textView.getText().toString(), seq);
        //String text = seq + "번째 .....";
        textView.setText(text);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button1:      // 삭제하기
                String user_pwd = editText.getText().toString().trim();
                if(user_pwd.equals("")) {
                    Toast.makeText(this, "비밀번호를 입력하세요.", Toast.LENGTH_SHORT).show();
                    return;
                }
                // 서버에 요청
                RequestParams params = new RequestParams();
                params.put("seq", seq);
                params.put("user_pwd", user_pwd);
                client.post(url, params, response);
                break;
            case R.id.button2:      // 취소하기
                finish();
                break;
        }
    }

    class HttpResponse extends AsyncHttpResponseHandler {
        ProgressDialog dialog;

        @Override
        public void onStart() {
            dialog = new ProgressDialog(DeleteActivity.this);
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
                if (rt.equals("OK")) {
                    Toast.makeText(DeleteActivity.this, "삭제 성공", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(DeleteActivity.this, MainActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                    startActivity(intent);
                } else {
                    Toast.makeText(DeleteActivity.this, "삭제 실패", Toast.LENGTH_SHORT).show();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
            Toast.makeText(DeleteActivity.this, "통신 실패", Toast.LENGTH_SHORT).show();
        }
    }
}