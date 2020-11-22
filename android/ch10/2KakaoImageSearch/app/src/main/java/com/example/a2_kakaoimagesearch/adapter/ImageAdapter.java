package com.example.a2_kakaoimagesearch.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.example.a2_kakaoimagesearch.R;
import com.example.a2_kakaoimagesearch.model.Image;

import java.util.List;

public class ImageAdapter extends ArrayAdapter<Image> {
    Activity activity;
    int resource;

    public ImageAdapter(@NonNull Context context, int resource, @NonNull List<Image> objects) {
        super(context, resource, objects);
        activity = (Activity) context;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView == null) {
            convertView = activity.getLayoutInflater().inflate(resource, null);
        }
        Image item = getItem(position);

        if(item != null) {
            ImageView imageView = convertView.findViewById(R.id.imageView);
            TextView textView1 = convertView.findViewById(R.id.textView1);
            TextView textView2 = convertView.findViewById(R.id.textView2);

            // 이미지 다운로드 처리 : 1) 이미지 요청 2) 이미지 응답 처리 3) 이미지를 imageView에 추가
            Glide.with(activity)
                    .load(item.getThumbnail_url())
                    .placeholder(R.drawable.ic_stub)        // 불러올 동안 표시할 이미지 설정
                    .error(R.drawable.ic_error)             //  에러 발생시 표시할 이미지 설정
                    .fallback(R.drawable.ic_empty)          // uri이 null일 때 표시할 이미지 설정
                    .into(imageView);
            textView1.setText(item.getDisplay_sitename());
            textView2.setText(item.getWidth() + "x" + item.getHeight());
        }

        return convertView;
    }
}
