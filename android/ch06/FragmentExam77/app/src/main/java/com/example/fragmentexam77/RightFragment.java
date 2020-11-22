package com.example.fragmentexam77;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.fragmentexam77.model.Job;

public class RightFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_right, container, false);
    }

    public void update(Job job) {
        TextView textView1 = getView().findViewById(R.id.textView1);
        TextView textView2 = getView().findViewById(R.id.textView2);
        ImageView imageView = getView().findViewById(R.id.imageView);

        textView1.setText(job.getTitle());
        textView2.setText(job.getDescription());
        imageView.setImageResource(job.getImage());
    }
}