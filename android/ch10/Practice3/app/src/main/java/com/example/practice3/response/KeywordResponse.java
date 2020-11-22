package com.example.practice3.response;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.example.practice3.adpater.KeywordAdapter;
import com.example.practice3.model.Keyword;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

public class KeywordResponse extends AsyncHttpResponseHandler {
    Activity activity;
    KeywordAdapter adapter;
    ListView listView;
    View footerView;

    public KeywordResponse(Activity activity, KeywordAdapter adapter, ListView listView, View footerView) {
        this.activity = activity;
        this.adapter = adapter;
        this.listView = listView;
        this.footerView = footerView;
    }

    @Override
    public void onStart() {
        super.onStart();
        footerView.setVisibility(View.VISIBLE);
        listView.setSelection(adapter.getCount());
    }

    @Override
    public void onFinish() {
        super.onFinish();
    }

    @Override
    public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
        Log.d("[TEST]", "success");
        String str = new String(responseBody);
        try {
            JSONObject json = new JSONObject(str);
            JSONObject meta = json.getJSONObject("meta");

            Keyword.setTotal_count(meta.getInt("total_count"));
            Keyword.setPageable_count(meta.getInt("pageable_count"));
            Keyword.setIs_end(meta.getBoolean("is_end"));
            Log.d("[TEST]", ""+Keyword.getTotal_count());
            Log.d("[TEST]", ""+Keyword.getPageable_count());
            Log.d("[TEST]", ""+Keyword.isIs_end());
            JSONArray documents = json.getJSONArray("documents");
            Log.d("[TEST]", documents.toString());
            for(int a=0; a<documents.length(); a++){
                JSONObject temp = documents.getJSONObject(a);
                Keyword keyword = new Keyword();
                keyword.setPlace_name(temp.getString("place_name"));
                keyword.setDistance(temp.getString("distance"));
                keyword.setPlace_url(temp.getString("place_url"));
                keyword.setCategory_name(temp.getString("category_name"));
                keyword.setAddress_name(temp.getString("address_name"));
                keyword.setRoad_address_name(temp.getString("road_address_name"));
                keyword.setId(temp.getString("id"));
                keyword.setPhone(temp.getString("phone"));
                keyword.setCategory_group_code(temp.getString("category_group_code"));
                keyword.setCategory_group_name(temp.getString("category_group_name"));
                keyword.setX(temp.getDouble("x"));
                keyword.setY(temp.getDouble("y"));

                adapter.add(keyword);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
        Toast.makeText(activity, "통신 실패", Toast.LENGTH_SHORT).show();
        Log.d("[TEST]", statusCode + ", " + headers.length + ", " + responseBody.length);
    }
}
