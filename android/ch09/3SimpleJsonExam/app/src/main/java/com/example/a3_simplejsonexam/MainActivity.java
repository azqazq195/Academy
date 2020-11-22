package com.example.a3_simplejsonexam;

import androidx.appcompat.app.AppCompatActivity;
import cz.msebera.android.httpclient.Header;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONException;
import org.json.JSONObject;

import java.nio.channels.AsynchronousByteChannel;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button button;
    TextView textView;
    AsyncHttpClient client;
    HttpResponse response;
    String url = "http://192.168.0.123:8080//server_data/simple.json";

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

    class HttpResponse extends AsyncHttpResponseHandler {

        @Override
        public void onSuccess(int i, Header[] headers, byte[] bytes) {
            String result = new String(bytes);

            try {
                // Json파일에서 각자가 맡은 부분이 있다.
                JSONObject json = new JSONObject(result); // 첫번째 {}를 나타냄
                JSONObject device = json.getJSONObject("device"); // 두번째 중괄호를 가져옴
                String name = device.getString("name");
                String type = device.getString("type");
                textView.setText(name + " / " + type);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onFailure(int i, Header[] headers, byte[] bytes, Throwable throwable) {
            Toast.makeText(MainActivity.this, "통신 실패", Toast.LENGTH_SHORT).show();
        }
    }
}