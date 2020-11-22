package com.example.a4_listitemcheckexam.adapter;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.a4_listitemcheckexam.R;
import com.example.a4_listitemcheckexam.model.Flower;

import java.util.List;

public class FlowerAdapter extends ArrayAdapter<Flower> {
    Activity activity;
    int resource;

    public FlowerAdapter(@NonNull Context context, int resource, @NonNull List objects) {
        super(context, resource, objects);
        activity = (Activity) context;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // 1. 1줄 화면 객체 생성 : list_item.xml 파일에 설정된대로 객체 생성
        Log.i("[Test]","position " + position + ", convertView " + convertView);
        if(convertView == null){
            convertView = activity.getLayoutInflater().inflate(resource, null);
        }
        // 2. 전달받은 위치 값으로 List에서 데이터를 하나 꺼낸다.
        final Flower item = getItem(position);

        // 3. 데이터가 존재하면, convertView객체에 포함된 컴포넌트들에게 데이터를 출력한다.
        // => convertView = 컴포넌트 클래스 + 1줄 데이터
        if(item != null) {
            ImageView imageView = convertView.findViewById(R.id.imageView);
            TextView textView1 = convertView.findViewById(R.id.textView1);
            TextView textView2 = convertView.findViewById(R.id.textView2);
            CheckBox checkBox = convertView.findViewById(R.id.checkBox);
            // 컴포넌트들에게 데이터를 설정
            imageView.setImageResource(item.getImage());
            textView1.setText(item.getTitle());
            textView2.setText(item.getDescription());

            // 체크박스의 이벤트처리
            checkBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
                item.setCheck(isChecked);
            });

            checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    item.setCheck(isChecked);
                }
            });
            // 자바빈즈 객체가 갖고 있는 상태값으로, 체크박스의 상태를 강제로 재설정
            checkBox.setChecked(item.isCheck());
        }
        // 4. 1줄 화면 리턴
        return convertView;
    }
}
