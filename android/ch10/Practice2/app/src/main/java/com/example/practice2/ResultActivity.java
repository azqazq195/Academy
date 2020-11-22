package com.example.practice2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.practice2.model.Image;

public class ResultActivity extends AppCompatActivity implements View.OnClickListener {
    Button button;
    ImageView imageView;
    Image item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        button = findViewById(R.id.button);
        imageView = findViewById(R.id.imageView);
        item = (Image) getIntent().getSerializableExtra("item");

        button.setOnClickListener(this);
        // 화면 설정
        Glide.with(this).load(item.getImage_url()).into(imageView);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(item.getDoc_url()));
        startActivity(intent);
    }
}