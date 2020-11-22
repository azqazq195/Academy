package com.example.practice1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.practice1.model.Job;

public class ResultActivity extends AppCompatActivity {
    TextView textView1, textView2;
    ImageView imageView;
    LinearLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        textView1 = findViewById(R.id.textView1);
        textView2 = findViewById(R.id.textView2);
        imageView = findViewById(R.id.imageView);
        layout = findViewById(R.id.layout);

        Job item = (Job) getIntent().getSerializableExtra("item");

        textView1.setText(item.getTitle());
        textView2.setText(item.getDescription());
        imageView.setImageResource(item.getImage());

        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}