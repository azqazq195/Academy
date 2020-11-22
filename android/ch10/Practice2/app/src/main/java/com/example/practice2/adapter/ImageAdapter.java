package com.example.practice2.adapter;

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
import com.example.practice2.R;
import com.example.practice2.model.Image;

import java.text.MessageFormat;
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
        if(convertView == null){
            convertView = activity.getLayoutInflater().inflate(resource, null);
        }
        Image item = getItem(position);

        if(item != null) {
            ImageView imageView = convertView.findViewById(R.id.imageView);
            TextView textView1 = convertView.findViewById(R.id.textView1);
            TextView textView2 = convertView.findViewById(R.id.textView2);

            Glide.with(activity)
                    .load(item.getThumbnail_url())
                    .placeholder(R.drawable.ic_stub)
                    .error(R.drawable.ic_error)
                    .fallback(R.drawable.ic_empty)
                    .into(imageView);
            textView1.setText(item.getDisplay_sitename());
            textView2.setText(MessageFormat.format("{0}x{1}", item.getWidth(), item.getHeight()));
        }



        return convertView;
    }
}
