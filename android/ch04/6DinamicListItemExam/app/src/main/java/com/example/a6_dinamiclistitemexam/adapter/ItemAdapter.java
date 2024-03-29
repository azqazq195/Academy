package com.example.a6_dinamiclistitemexam.adapter;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.a6_dinamiclistitemexam.R;
import com.example.a6_dinamiclistitemexam.model.Item;

import java.util.List;

public class ItemAdapter extends ArrayAdapter<Item> {
    Activity activity;
    int resource;
    public ItemAdapter(@NonNull Context context, int resource, @NonNull List<Item> objects) {
        super(context, resource, objects);
        activity = (Activity) context;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Log.d("[TEST]", "position=" + position + ", " + convertView);

        if(convertView == null) {
            convertView = activity.getLayoutInflater().inflate(resource, null);
        }
        final Item item = getItem(position);

        if(item != null) {
            Button button = convertView.findViewById(R.id.button);
            TextView textView = convertView.findViewById(R.id.textView);

            textView.setText(item.getNum() + " >> " + item.getName());
            // button 이벤트 설정
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // 버튼을 클릭하면, 데이터 삭제
                    remove(item);
                }
            });
        }
        return convertView;
    }
}










