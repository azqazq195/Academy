package com.example.practice4.adpter;

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

public class JobPageAdapter extends PagerAdapter {
    Activity activity;
    List<Job> list;

    public JobPageAdapter(Activity activity, List<Job> list) {
        this.activity = activity;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }
    // 1페이지 화면 만들기
    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        // 1페이지 화면
        View itemView = activity.getLayoutInflater().inflate(R.layout.page_item, null);
        // 1페이지 데이터
        Job item = list.get(position);
        // 1페이지 화면 + 1페이지 데이터
        TextView textView1 = itemView.findViewById(R.id.textView1);
        TextView textView2 = itemView.findViewById(R.id.textView2);
        ImageView imageView = itemView.findViewById(R.id.imageView);

        textView1.setText(item.getTitle());
        textView2.setText(item.getDescription());
        imageView.setImageResource(item.getImage());
        // viewPager 컨테이너에 추가
        container.addView(itemView, 0);
        return itemView;
    }
    // 화면 없애기
    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }
}
