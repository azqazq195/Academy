package com.example.gradelistexam.adapter;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.gradelistexam.R;
import com.example.gradelistexam.medel.Member;

import java.util.List;

public class MemberAdapter extends ArrayAdapter<Member> {
    Activity activity;
    int resource;

    public MemberAdapter(@NonNull Context context, int resource, @NonNull List<Member> objects) {
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

        Member member = getItem(position);

        if(member != null) {
            TextView textView1 = convertView.findViewById(R.id.textView1);
            TextView textView2 = convertView.findViewById(R.id.textView2);
            TextView textView3 = convertView.findViewById(R.id.textView3);
            TextView textView4 = convertView.findViewById(R.id.textView4);

            textView1.setText("이름 : " + member.getName());
            textView2.setText("국어 : " + member.getKor());
            textView3.setText("영어 : " + member.getEng());
            textView4.setText("수학 : " + member.getMat());
        }

        return convertView;
    }
}
