package com.example.viewpager2exam.adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import androidx.viewpager.widget.PagerAdapter;


import com.example.viewpager2exam.R;
import com.example.viewpager2exam.model.Job;

import java.util.List;


public class JobAdapter extends RecyclerView.Adapter {
    private Activity activity;
    private List<Job> list;

    public JobAdapter(Activity activity, List<Job> list) {
        this.activity = activity;
        this.list = list;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    // 뷰페이저가 만들어졌을 때 호출됨
    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = activity.getLayoutInflater().inflate(R.layout.page_item, null);
        final Job job = list.get(viewType);

        ImageView imageView = itemView.findViewById(R.id.imageView);
        TextView textView1 = itemView.findViewById(R.id.textView1);
        TextView textView2 = itemView.findViewById(R.id.textView2);

        textView1.setText(job.getName());
        textView2.setText(job.getDescription());
        imageView.setImageResource(job.getImage());

        parent.addView(itemView, 0);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}