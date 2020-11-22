package com.example.jsonimagelisttest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jsonimagelisttest.model.Job;
import com.nostra13.universalimageloader.core.ImageLoader;

public class ResultActivity extends AppCompatActivity {
    TextView textView1, textView2;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        textView1 = findViewById(R.id.textView1);
        textView2 = findViewById(R.id.textView2);
        imageView = findViewById(R.id.imageView);

        Job item = (Job) getIntent().getSerializableExtra("item");
        textView1.setText(item.getSubject());
        textView2.setText(item.getContent());
        ImageLoader.getInstance().displayImage(item.getImg(), imageView);
    }
}





