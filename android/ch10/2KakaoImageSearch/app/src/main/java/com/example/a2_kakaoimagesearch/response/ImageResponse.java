package com.example.a2_kakaoimagesearch.response;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.example.a2_kakaoimagesearch.adapter.ImageAdapter;
import com.example.a2_kakaoimagesearch.model.Image;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

public class ImageResponse extends AsyncHttpResponseHandler {
    Activity activity;
    ImageAdapter adapter;
    ListView listView;      // 끝에 도착했는지 확인용
    View footerView;        // "기다려주세요" footer 뷰

    public ImageResponse(Activity activity, ImageAdapter adapter, ListView listView, View footerView) {
        this.activity = activity;
        this.adapter = adapter;
        this.listView = listView;
        this.footerView = footerView;
    }

    @Override
    public void onStart() {
        super.onStart();
        footerView.setVisibility(View.VISIBLE); // footerView 보이기
        // adapter.getCount() : 리스트에 저장된 총 갯수
        listView.setSelection(adapter.getCount() - 1);
        // URI 확인
        Log.d("[TEST]", getRequestURI().toString());
    }

    @Override
    public void onFinish() {
        super.onFinish();
    }

    @Override
    public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
        String str = new String(responseBody);
        try {
            JSONObject json = new JSONObject(str);
            JSONObject meta = json.getJSONObject("meta");
            // 공통변수 저장
            Image.setTotal_count(meta.getInt("total_count"));
            Image.setPageable_count(meta.getInt("pageable_count"));
            Image.setIs_end(meta.getBoolean("is_end"));
            // 검색 결과 저장
            JSONArray documents = json.getJSONArray("documents");
            for(int a=0; a<documents.length(); a++) {
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
                // 리스트에 저장
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
