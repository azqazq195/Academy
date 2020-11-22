package com.example.practice4.adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.practice4.R;
import com.example.practice4.model.Job;

import java.util.List;

public class JobViewAdapter extends PagerAdapter {
    private Activity activity;
    private List<Job> list;

    public JobViewAdapter(Activity activity, List<Job> list) {
        this.activity = activity;
        this.list = list;
    }

    // List 객체에 저장된 데이터 개수 리턴
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    // 뷰페이저가 만들어졌을 때 호출됨
    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View itemView = activity.getLayoutInflater().inflate(R.layout.page_item, null);
        final Job job = list.get(position);

        ImageView imageView = itemView.findViewById(R.id.imageView);
        TextView textView1 = itemView.findViewById(R.id.textView1);
        TextView textView2 = itemView.findViewById(R.id.textView2);

        textView1.setText(job.getName());
        textView2.setText(job.getDescription());
        imageView.setImageResource(job.getImage());

        container.addView(itemView, 0);
        return itemView;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }
}