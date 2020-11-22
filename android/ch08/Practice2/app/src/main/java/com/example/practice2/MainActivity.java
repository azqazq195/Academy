package com.example.practice2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import com.example.practice2.helper.FileUtils;
import com.example.practice2.helper.PhotoHelper;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    LinearLayout main, image, video, text;
    Button mainButton1, mainButton2, mainButton3,
        imageButton1, videoButton1, textButton1;
    ImageView imageView;
    TextView textView;
    VideoView videoView;
    Bitmap bmp = null;
    MediaController mc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        main = findViewById(R.id.main);
        image = findViewById(R.id.image);
        text = findViewById(R.id.text);
        video = findViewById(R.id.video);

        mainButton1 = findViewById(R.id.mainButton1);
        mainButton2 = findViewById(R.id.mainButton2);
        mainButton3 = findViewById(R.id.mainButton3);
        imageButton1 = findViewById(R.id.imageButton1);
        videoButton1 = findViewById(R.id.videoButton1);
        textButton1 = findViewById(R.id.textButton1);
        imageView = findViewById(R.id.imageView);
        textView = findViewById(R.id.textView);
        videoView = findViewById(R.id.videoView);

        mc = new MediaController(this);
        videoView.setMediaController(mc);

        mainButton1.setOnClickListener(this);
        mainButton2.setOnClickListener(this);
        mainButton3.setOnClickListener(this);
        imageButton1.setOnClickListener(this);
        videoButton1.setOnClickListener(this);
        textButton1.setOnClickListener(this);
        
        setLayout(main);

        permissionCheck();
    }

    private void setLayout(LinearLayout layout) {
        main.setVisibility(View.GONE);
        image.setVisibility(View.GONE);
        video.setVisibility(View.GONE);
        text.setVisibility(View.GONE);

        layout.setVisibility(View.VISIBLE);
    }

    private void permissionCheck() {
        if (ActivityCompat.checkSelfPermission(this,
                Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.READ_EXTERNAL_STORAGE)) {

            } else {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 100);
            }

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Uri uri = data.getData();
        String filePath = FileUtils.getPath(this, uri);
        if(requestCode == 1) {
            if(resultCode == RESULT_OK) {
                showImage(uri);
            }
        }
        else if(requestCode == 2) {
            if(resultCode == RESULT_OK) {
                showVideo(uri);
            }
        }
        else if(requestCode == 3) {
            if(resultCode == RESULT_OK) {
                showText(uri);
            }
        }
    }

    @Override
    public void onClick(View v) {
        // SAF(Storage Access Framwork, = 파일 탐색기)로 파일 읽기
        // => uri : content://...
        Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        intent.putExtra(Intent.EXTRA_LOCAL_ONLY, true);

        switch (v.getId()){
            case R.id.mainButton1:
                intent.setType("image/*");
                startActivityForResult(intent, 1);
                setLayout(image);
                break;
            case R.id.mainButton2:
                intent.setType("video/*");
                startActivityForResult(intent, 2);
                setLayout(video);
                break;
            case R.id.mainButton3:
                intent.setType("text/*");
                startActivityForResult(intent, 3);
                setLayout(text);
                break;
            case R.id.imageButton1:
                setLayout(main);
            case R.id.videoButton1:
                videoView.stopPlayback();
                setLayout(main);
            case R.id.textButton1:
                setLayout(main);
                break;
            }
    }

    private void showImage(Uri uri) {
        imageView.setImageURI(uri);
//        imageView.setImageBitmap(null);
//        if(bmp != null) {
//            bmp.recycle();
//            bmp = null;
//        }
//        bmp = PhotoHelper.getInstance().getThumb(this, filePath);
//        imageView.setImageBitmap(bmp);
    }

    private void showVideo(Uri uri){
        videoView.setVideoURI(uri);
        videoView.start();
//        videoView.setMediaController(mc);
//        videoView.setVideoPath(filePath);
//        videoView.start();
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
}