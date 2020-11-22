package com.example.imageboard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.imageboard.model.Community;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

public class ReadActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView imageView;
    TextView textView1, textView2, textView3, textView4;
    Button button1, button2, button3;
    AsyncHttpClient client;
    HttpResponse response;
    String url = "http://192.168.0.96:8080/imageboard/community/community_select.do";
    //String url = "http://192.168.0.96:8080/imageboard/community/community_select.jsp";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read);

        imageView = findViewById(R.id.imageView);
        textView1 = findViewById(R.id.textView1);
        textView2 = findViewById(R.id.textView2);
        textView3 = findViewById(R.id.textView3);
        textView4 = findViewById(R.id.textView4);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        client = new AsyncHttpClient();
        response = new HttpResponse();
        // 이벤트 설정
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        RequestParams params = new RequestParams();
        params.put("seq", getIntent().getIntExtra("seq", 0));
        client.post(url, params, response);
    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch (v.getId()) {
            case R.id.button1:
                intent = new Intent(this, DeleteActivity.class);
                intent.putExtra("seq", getIntent().getIntExtra("seq", 0));
                startActivity(intent);
                break;
            case R.id.button2:
                Community community = new Community();
                community.setSubject(textView1.getText().toString());
                community.setUser_name(textView2.getText().toString());
                community.setEmail(textView3.getText().toString());
                community.setContent(textView4.getText().toString());
                community.setSeq(getIntent().getIntExtra("seq", 0));

                intent = new Intent(this, EditActivity.class);
                intent.putExtra("community", community);
                startActivity(intent);
                break;
            case R.id.button3:
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
                int total = json.getInt("total");
                if(rt.equals("OK")) {
                    JSONArray item = json.getJSONArray("item");
                    JSONObject temp = item.getJSONObject(0);
                    String filename = temp.getString("filename");
                    if(filename.equals("")) {
                        imageView.setVisibility(View.GONE);
                    } else {
                        Glide.with(ReadActivity.this)
                                .load(filename)
                                .into(imageView);
                    }
                    textView1.setText(temp.getString("subject"));
                    textView2.setText(temp.getString("user_name"));
                    textView3.setText(temp.getString("email"));
                    textView4.setText(temp.getString("content"));
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