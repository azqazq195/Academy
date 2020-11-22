package com.example.practice3.adpater;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.practice3.R;
import com.example.practice3.model.Keyword;

import java.util.List;


public class KeywordAdapter extends ArrayAdapter<Keyword> {
    Activity activity;
    int resource;

    public KeywordAdapter(@NonNull Context context, int resource, @NonNull List<Keyword> objects) {
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

        Keyword item = getItem(position);

        if(item != null) {
            TextView textView1 = convertView.findViewById(R.id.textView1);
            TextView textView2 = convertView.findViewById(R.id.textView2);

            textView1.setText(item.getPlace_name());
            textView2.setText(item.getCategory_name());
        }

        return convertView;
    }
}
