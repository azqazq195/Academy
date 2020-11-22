package com.example.imageboard;

import androidx.appcompat.app.AppCompatActivity;

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
    String url = "http://192.168.0.96:8080/imageboard/community/community_delete.do";
    //String url = "http://192.168.0.96:8080/imageboard/community/community_delete.jsp";

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
        // 이벤트 설정
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        // 화면 설정
        String str = getIntent().getIntExtra("seq", 0)
                   + "번 글을 삭제하시려면 비밀번호를 입력하세요.";
        textView.setText(str);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button1:
                String user_pwd = editText.getText().toString().trim();
                if (user_pwd.equals("")) {
                    Toast.makeText(this, "비밀번호를 입력하세요", Toast.LENGTH_SHORT).show();
                    return;
                }
                RequestParams params = new RequestParams();
                params.put("user_pwd", user_pwd);
                params.put("seq", getIntent().getIntExtra("seq", 0));
                client.post(url, params, response);
                break;
            case R.id.button2:
                finish();
                break;
        }
    }
    class HttpResponse extends AsyncHttpResponseHandler {
        @Override
        public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
            String str = new String(responseBody);
            try {
                JSONObject json = new JSONObject(str);
                String rt = json.getString("rt");
                if(rt.equals("OK")) {
                    Toast.makeText(DeleteActivity.this, "삭제 성공", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(DeleteActivity.this, MainActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                    startActivity(intent);
                    finish(); // 현재 액티비티 종료
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