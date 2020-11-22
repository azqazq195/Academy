package com.example.miniboard.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.miniboard.R;
import com.example.miniboard.model.Community;

import java.util.List;

public class CommunityAdapter extends ArrayAdapter<Community> {
    Activity activity;
    int resource;

    public CommunityAdapter(@NonNull Context context, int resource, @NonNull List<Community> objects) {
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

        Community item = getItem(position);

        if(item != null) {
            TextView textView1 = convertView.findViewById(R.id.textView1);
            TextView textView2 = convertView.findViewById(R.id.textView2);

            textView1.setText(item.getSubject());
            textView2.setText(item.getUser_name() + " / " + item.getReg_date());
        }
        return convertView;
    }
}












