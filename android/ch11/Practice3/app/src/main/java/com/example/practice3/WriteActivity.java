package com.example.practice3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

public class WriteActivity extends AppCompatActivity implements View.OnClickListener {
    EditText editText1, editText2, editText3, editText4, editText5;
    Button button1, button2;
    // 통신용 객체
    AsyncHttpClient client;
    HttpResponse response;
    String url = "http://192.168.0.96:8080/practice3/score/score_insert.jsp";

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
            case R.id.button1:  // 저장
                String studNo = editText1.getText().toString().trim();
                String name = editText2.getText().toString().trim();
                String kor = editText3.getText().toString().trim();
                String eng = editText4.getText().toString().trim();
                String mat = editText5.getText().toString().trim();
                // 입력 검사
                String msg = null;
                if(studNo.equals("")) {
                    msg = "학번을 입력하세요.";
                } else if(name.equals("")) {
                    msg = "이름을 입력하세요.";
                } else if(kor.equals("")) {
                    msg = "국어점수를 입력하세요.";
                } else if(eng.equals("")) {
                    msg = "영어점수를 입력하세요.";
                } else if(mat.equals("")) {
                    msg = "수학점수를 입력하세요.";
                }

                if(msg != null) {
                    Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
                    return;
                }
                // 서버에 요청 및 데이터 전송
                RequestParams params = new RequestParams();
                params.put("studNo", studNo);
                params.put("name", name);
                params.put("kor", kor);
                params.put("eng", eng);
                params.put("mat", mat);

                client.post(url, params, response);
                break;
            case R.id.button2:  // 취소
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
                    Toast.makeText(WriteActivity.this, "저장 성공", Toast.LENGTH_SHORT).show();
                    editText1.setText("");
                    editText2.setText("");
                    editText3.setText("");
                    editText4.setText("");
                    editText5.setText("");
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








