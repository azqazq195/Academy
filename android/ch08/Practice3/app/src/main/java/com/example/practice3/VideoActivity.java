package com.example.practice3;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

import com.example.practice3.helper.FileUtils;

public class VideoActivity extends AppCompatActivity implements View.OnClickListener {
    Button button;
    VideoView videoView;
    MediaController mc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        button = findViewById(R.id.button);
        videoView = findViewById(R.id.videoView);

        button.setOnClickListener(this);

        mc = new MediaController(this);
        videoView.setMediaController(mc);

        Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        intent.putExtra(Intent.EXTRA_LOCAL_ONLY, true);
        intent.setType("video/*");
        startActivityForResult(intent, 3);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Uri uri = data.getData();
        if(requestCode == 3) {
            if(resultCode == RESULT_OK) {
                showVideo(uri);
            }
        }
    }

    private void showVideo(Uri uri){
        videoView.setVideoURI(uri);
        videoView.start();
    }

    @Override
    public void onClick(View v) {
        videoView.stopPlayback();
        finish();
    }


}