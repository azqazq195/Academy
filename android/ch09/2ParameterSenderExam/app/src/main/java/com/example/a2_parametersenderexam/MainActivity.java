package com.example.a2_parametersenderexam;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.client.HttpClient;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText editText1,editText2;
    Button button1, button2;
    TextView textView;
    AsyncHttpClient client;
    HttpResponse response;
    String uri_get = "http://192.168.0.42:8085/server_data/send_get.jsp";
    String uri_post = "http://192.168.0.42:8085/server_data/send_post.jsp";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        textView = findViewById(R.id.textView);
        client = new AsyncHttpClient();
        response = new HttpResponse();

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String user_id = editText1.getText().toString().trim();
        String user_pw = editText2.getText().toString().trim();

        // parameter 관리 객체
        RequestParams params = new RequestParams();
        params.put("user_id", user_id);
        params.put("user_pw", user_pw);

        switch (v.getId()) {
            case R.id.button1:  // get 방식 요청
                client.get(uri_get, params, response);
                break;
            case R.id.button2:  // post 방식 요청
                client.post(uri_post, params, response);
                break;
        }
    }

    class HttpResponse extends AsyncHttpResponseHandler{
        ProgressDialog dialog;

        // 통신 시작시 함수 호출
        @Override
        public void onStart() {
            dialog = new ProgressDialog(MainActivity.this);
            dialog.setMessage("잠시만 기다려주세요.");
            dialog.setCancelable(false);
            dialog.show();

            Log.d("[TEST]", "요청 : " + getRequestURI());
        }
        // 통신 종료시 호출
        @Override
        public void onFinish() {
            dialog.dismiss();
            dialog = null;
        }
        // 200코드가 오면 실행
        @Override
        public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
            String result = new String(responseBody);
            textView.setText(result);
        }
        // 200 코드가 아닐 때 실행행
        @Override
        public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
            Toast.makeText(MainActivity.this, "실패",Toast.LENGTH_SHORT).show();
        }
    }
}