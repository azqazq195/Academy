package com.example.apptest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.example.apptest.adapter.MemberAdapter;
import com.example.apptest.model.Member;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HttpResponse;

public class ListActivity extends AppCompatActivity {

    List<Member> list;
    ListView listView;
    MemberAdapter adapter;
    String url = "http://192.168.55.172:8081/apptest/member/member_list.do";
    AsyncHttpClient client;
    HttpResponse response;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        list = new ArrayList<>();
        adapter = new MemberAdapter(this, R.layout.list_item, list);
        listView = findViewById(R.id.listView);
        client = new AsyncHttpClient();
        response = new HttpResponse();
        listView.setAdapter(adapter);
        Toast.makeText(this, "LIST", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        adapter.clear();
        client.post(url, response);
    }

    class HttpResponse extends AsyncHttpResponseHandler {
        @Override
        public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
            String str = new String(responseBody);
            try {
                Toast.makeText(ListActivity.this, "진입", Toast.LENGTH_SHORT).show();
                JSONObject json = new JSONObject(str);
                String rt = json.getString("rt");
                int total = json.getInt("total");
                JSONArray item = json.getJSONArray("item");

                for(int i=0; i<item.length(); i++) {
                    JSONObject temp = item.getJSONObject(i);
                    Member member = new Member();
                    member.setReg_date(temp.getString("logtime"));
                    String filename = temp.getString("filename");
                    if(filename.equals("")) filename = null;
                    member.setFilename(filename);
                    member.setName(temp.getString("name"));
                    member.setPhone(temp.getString("phone"));
                    member.setEmail(temp.getString("email"));
                    member.setAddr(temp.getString("addr"));
                    Log.d("[TEST]", "onSuccess: " + member.getName());
                    adapter.add(member);
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