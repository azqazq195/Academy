package com.example.practice2.response;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.example.practice2.adapter.ImageAdapter;
import com.example.practice2.model.Image;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

public class ImageResponse extends AsyncHttpResponseHandler {
    Activity activity;
    ImageAdapter adapter;
    ListView listView;
    View footerView;

    public ImageResponse(Activity activity, ImageAdapter adapter, ListView listView, View footerView) {
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
        Log.d("[TEST]", statusCode + ", " + headers.length + ", " + responseBody.length);
        String str = new String(responseBody);
        try {
            JSONObject json = new JSONObject(str);
            JSONObject meta = json.getJSONObject("meta");
            Image.setTotal_count(meta.getInt("total_count"));
            Image.setPageable_count(meta.getInt("pageable_count"));
            Image.setIs_end(meta.getBoolean("is_end"));
            JSONArray documents = json.getJSONArray("documents");
            for(int a=0; a<documents.length(); a++){
                JSONObject temp = documents.getJSONObject(a);
                Image image = new Image();
                image.setCollection(temp.getString("collection"));
                image.setThumbnail_url(temp.getString("thumbnail_url"));
                image.setImage_url(temp.getString("image_url"));
                image.setWidth(temp.getInt("width"));
                image.setHeight(temp.getInt("height"));
                image.setDisplay_sitename(temp.getString("display_sitename"));
                image.setDoc_url(temp.getString("doc_url"));
                image.setDatetime(temp.getString("datetime"));
                adapter.add(image);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
        Toast.makeText(activity, "통신 실패", Toast.LENGTH_SHORT).show();
    }
}
