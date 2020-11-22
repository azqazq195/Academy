package com.example.practice3;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TextActivity extends AppCompatActivity implements View.OnClickListener {
    Button button;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text);

        button = findViewById(R.id.button);
        textView = findViewById(R.id.textView);

        button.setOnClickListener(this);

        Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        intent.putExtra(Intent.EXTRA_LOCAL_ONLY, true);
        intent.setType("text/*");
        startActivityForResult(intent, 2);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Uri uri = data.getData();
        if(requestCode == 2) {
            if(resultCode == RESULT_OK) {
                showText(uri);
            }
        }
    }

    private void showText(Uri uri) {
        ParcelFileDescriptor pfd = null;
        FileInputStream fileInputStream = null;
        try {
            pfd = getContentResolver().openFileDescriptor(uri, "r");
            fileInputStream = new FileInputStream(pfd.getFileDescriptor());
            byte[] content_byte = new byte[fileInputStream.available()];
            fileInputStream.read(content_byte);
            textView.setText(new String(content_byte));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void onClick(View v) {
        finish();
    }
}