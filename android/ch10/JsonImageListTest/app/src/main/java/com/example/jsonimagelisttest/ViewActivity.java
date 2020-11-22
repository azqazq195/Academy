package com.example.jsonimagelisttest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jsonimagelisttest.adapter.JobAdapter;
import com.nostra13.universalimageloader.core.ImageLoader;

public class ViewActivity extends AppCompatActivity implements View.OnClickListener {
    String originalImage, subject, content;
    ImageView imageView;
    Button button;
    TextView textView1, textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        textView1 = findViewById(R.id.textView1);
        textView2 = findViewById(R.id.textView2);
        imageView = findViewById(R.id.imageView);
        button = findViewById(R.id.button);

        originalImage = getIntent().getStringExtra("originalImage");
        subject = getIntent().getStringExtra("subject");
        content = getIntent().getStringExtra("content");

        imageView.setImageURI(null);
        textView1.setText(subject);
        textView2.setText(content);
        ImageLoader.getInstance().displayImage(originalImage, imageView);

        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        finish();
    }
}