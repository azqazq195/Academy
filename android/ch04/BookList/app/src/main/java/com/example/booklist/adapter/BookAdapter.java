package com.example.booklist.adapter;

import android.app.Activity;
import android.content.Context;
import android.media.Image;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.booklist.R;
import com.example.booklist.model.Book;

import java.util.List;

public class BookAdapter extends ArrayAdapter<Book> {
    Activity activity;
    int resource;

    public BookAdapter(@NonNull Context context, int resource, @NonNull List<Book> objects) {
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

        Book item = getItem(position);

        if(item != null){
            ImageView imageView = convertView.findViewById(R.id.imageView);
            TextView textView1 = convertView.findViewById(R.id.textView1);
            TextView textView2 = convertView.findViewById(R.id.textView2);
            TextView textView3 = convertView.findViewById(R.id.textView3);

            imageView.setImageResource(item.getImage());
            textView1.setText(item.getSubject());
            textView2.setText(item.getPublisher());
            textView3.setText(item.getWriter());
        }

        return convertView;
    }
}
