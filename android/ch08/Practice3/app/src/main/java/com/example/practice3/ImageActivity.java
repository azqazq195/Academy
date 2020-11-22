package com.example.practice3;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.practice3.helper.FileUtils;

public class ImageActivity extends AppCompatActivity implements View.OnClickListener {
    Button button;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        button = findViewById(R.id.button);
        imageView = findViewById(R.id.imageView);

        button.setOnClickListener(this);

        Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        intent.putExtra(Intent.EXTRA_LOCAL_ONLY, true);
        intent.setType("image/*");
        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Uri uri = data.getData();
        if(requestCode == 1) {
            if(resultCode == RESULT_OK) {
                showImage(uri);
            }
        }
    }

    private void showImage(Uri uri) {
        imageView.setImageURI(uri);
    }

    @Override
    public void onClick(View v) {
        finish();
    }
}