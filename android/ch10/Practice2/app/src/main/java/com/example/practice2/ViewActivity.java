package com.example.practice2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.practice2.model.Image;

import java.text.MessageFormat;

public class ViewActivity extends AppCompatActivity
implements View.OnClickListener {
    ImageView imageView;
    Button button1, button2;

    String thumbnail_url;
    String image_uri;
    String doc_url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        imageView = findViewById(R.id.imageView);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);


        image_uri = getIntent().getStringExtra("image_url");
        doc_url = getIntent().getStringExtra("doc_url");

        Glide.with(this)
                .load(image_uri)
                .error(R.drawable.ic_error)
                .fallback(R.drawable.ic_empty)
                .into(imageView);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button1:
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(doc_url));
                startActivity(intent);
                break;
            case R.id.button2:
                finish();
                break;
        }
    }
}