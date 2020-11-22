package com.example.a1_simplehttpclient;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button button;
    TextView textView;
    AsyncHttpClient client;     // 요청 객체
    HttpResponse response;      // 응답 객체
    String url = "http://192.168.0.123:8080/server_data/simple_text.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        textView = findViewById(R.id.textView);
        client = new AsyncHttpClient();
        response = new HttpResponse();

        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        client.get(url, response);
    }

    public class HttpResponse extends AsyncHttpResponseHandler {
        // 서버로 부터 200 코드가 오면 호출
        @Override
        public void onSuccess(int i, cz.msebera.android.httpclient.Header[] headers, byte[] bytes) {
            String result = new String(bytes);
            textView.setText(result);
        }
        // 서버로 부터 200 코드가 아닌게 오면 호출
        @Override
        public void onFailure(int i, cz.msebera.android.httpclient.Header[] headers, byte[] bytes, Throwable throwable) {
            String result = new String(bytes);
            Toast.makeText(MainActivity.this, "통신 실패 : " + result, Toast.LENGTH_SHORT).show();
        }
    }


}