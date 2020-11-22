package com.example.imageboard;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.imageboard.model.Community;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

public class EditActivity extends AppCompatActivity implements View.OnClickListener {
    EditText editText1, editText2, editText3, editText4, editText5;
    Button button1, button2;
    AsyncHttpClient client;
    HttpResponse response;
    String url = "http://192.168.0.96:8080/imageboard/community/community_modify.do";
    //String url = "http://192.168.0.96:8080/imageboard/community/community_modify.jsp";

    Community community;  // 이전 화면에서 전달된 데이터

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);
        editText3 = findViewById(R.id.editText3);
        editText4 = findViewById(R.id.editText4);
        editText5 = findViewById(R.id.editText5);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        client = new AsyncHttpClient();
        response = new HttpResponse();
        // 이벤트 설정
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        // 화면 초기화
        community = (Community) getIntent().getSerializableExtra("community");
        editText1.setText(community.getUser_name());
        editText3.setText(community.getEmail());
        editText4.setText(community.getSubject());
        editText5.setText(community.getContent());
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
                // 입력값 검사
                String msg = null;
                if(msg==null && user_name.equals("")) {
                    msg = "이름을 입력하세요";
                } else if(msg==null && user_pwd.equals("")) {
                    msg = "비밀번호를 입력하세요";
                } else if(msg==null && email.equals("")) {
                    msg = "이메일을 입력하세요";
                } else if(msg==null && subject.equals("")) {
                    msg = "제목을 입력하세요";
                } else if(msg==null && content.equals("")) {
                    msg = "내용을 입력하세요";
                }
                if(msg != null) {
                    Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
                    return;
                }
                // 서버에 전송
                RequestParams params = new RequestParams();
                params.put("user_name", user_name);
                params.put("user_pwd", user_pwd);
                params.put("email", email);
                params.put("subject", subject);
                params.put("content", content);
                params.put("seq", community.getSeq());
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
                    Toast.makeText(EditActivity.this, "수정 성공", Toast.LENGTH_SHORT).show();
                    finish(); // 현재 액티비티 종료 -> 상세보기 화면으로 돌아가기
                } else {
                    Toast.makeText(EditActivity.this, "수정 실패", Toast.LENGTH_SHORT).show();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        @Override
        public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
            Toast.makeText(EditActivity.this, "통신 실패", Toast.LENGTH_SHORT).show();
        }
    }
}