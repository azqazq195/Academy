package com.example.practice3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import cz.msebera.android.httpclient.Header;

public class ListActivity extends AppCompatActivity implements View.OnClickListener {
    TextView textView;
    Button button;
    AsyncHttpClient client;
    HttpResponse response;
    String url = "http://192.168.0.96:8080/practice3/score/score_list.jsp";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        textView = findViewById(R.id.textView);
        button = findViewById(R.id.button);
        client = new AsyncHttpClient();
        response = new HttpResponse();

        button.setOnClickListener(this);
        // 서버에 요청
        client.post(url, response);
    }

    @Override
    public void onClick(View v) {
        finish();
    }

    class HttpResponse extends AsyncHttpResponseHandler {

        @Override
        public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
            String str = new String(responseBody);
            try {
                JSONObject json = new JSONObject(str);
                String rt = json.getString("rt");

                if(rt.equals("OK")) {
                    JSONArray item = json.getJSONArray("item");
                    String result = "";
                    for(int i=0; i<item.length(); i++) {
                        JSONObject temp = item.getJSONObject(i);
                        String studNo = temp.getString("studNo");
                        String name = temp.getString("name");
                        int kor = temp.getInt("kor");
                        int eng = temp.getInt("eng");
                        int mat = temp.getInt("mat");
                        int tot = temp.getInt("tot");
                        int avg = temp.getInt("avg");

                        result += studNo + ", " + name + ", " + kor + ", "
                                + eng + ", " + mat + ", " + tot + ", "
                                + avg + "\n";
                    }
                    textView.setText(result);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
            Toast.makeText(ListActivity.this, "통신 실패", Toast.LENGTH_SHORT).show();
        }
    }
}