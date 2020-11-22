package com.example.a3_cameraexam;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.FileProvider;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.a3_cameraexam.helper.PhotoHelper;

import java.io.File;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //객체선언
    ImageView imageView;
    Button button;
    String photopath = null;
    Bitmap bmp = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //객체초기화
        imageView = findViewById(R.id.imageView);
        button = findViewById(R.id.button);

        //이벤트설정
        button.setOnClickListener(this);
        //퍼미션체크
        permissionCheck();
    }

    private void permissionCheck() {
        if(ActivityCompat.checkSelfPermission(this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            if(ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE)) {

            } else {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 100);
            }
        }
    }
//    private void permissionCheck() {
//        if (ActivityCompat.checkSelfPermission(this,
//              Manifest.permission.WRITE_EXTERNAL_STORAGE)
//                != PackageManager.PERMISSION_GRANTED){
//
//        } else {
//            ActivityCompat.requestPermissions(this,
//                    new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},100);
//        }
//    }

//    @Override
//    public void onClick(View v) {
//        //저장할 사진 경로
//        photopath = PhotoHelper.getInstance().getNewPhotoPath();
//        Log.d("[TEST]", "photopath = "+photopath);
//        File file = new File(photopath);
//        Uri uri = null;
//
//        //카메라 앱 호출을 위한 암묵적인 인텐트
//        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
//          uri = FileProvider.getUriForFile(this, getApplicationContext().getPackageName() + ".fileprovider", file);
//          intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
//          intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
//        } else {
//            uri = Uri.fromFile(file);
//        }
//        //저장될 경로를 파라미터로 설정
//        Log.d("[TEST]", "uri = " + uri);
//        intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
//        intent.putExtra(AUDIO_SERVICE, false);
//        //카메라 앱 호출
//        startActivityForResult(intent, 200);
//    }

    @Override
    public void onClick(View v) {
        // 저장할 사진 경로
        photopath = PhotoHelper.getInstance().getNewPhotoPath();
        // photoPath = /storage/emulated/0/DCIM/p2020-10-26 15-38-18.jpg
        Log.d("[TEST]", "photoPath = " + photopath);
        File file = new File(photopath);
        Uri uri = null;

        // 카메라 앱 호출을 위한 암묵적 인텐트 => action과 uri가 필요
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            uri = FileProvider.getUriForFile(this,
                    getApplicationContext().getPackageName() + ".fileprovider", file);
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
            intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        } else {
            uri = Uri.fromFile(file);
        }
        // 저장될 경로를 파라미터로 설정
        intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
        intent.putExtra(AUDIO_SERVICE, false);
        // 카메라 앱 호출
        startActivityForResult(intent, 100);
    }
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if(requestCode == 200) {
//            //if (resultCode == RESULT_OK) {
//                //촬영 결과물을 미디어스토리지에 등록한다.
//                // 미디어스토리에 등록하지 않으면, 우리 앱에서 만든 파일을 다른 앱에서는 사용할수 없다
//                Intent photoIntent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, Uri.parse("file://" + photopath));
//                sendBroadcast(photoIntent);
//
//                //이미지뷰에 이미지표시
//                //기본이미지 제거
//                imageView.setImageBitmap(null);
//                //비트맵 객체는 메모리에 계속 상존하므로
//                //메모리 해제를 시켜주어야 한다.
//                if(bmp != null) {
//                    bmp.recycle();
//                    bmp = null;
//                }
//                //썸네일 이미지 얻기
//                bmp = PhotoHelper.getInstance().getThumb(this, photopath);
//                //이미지뷰에 출력
//                imageView.setImageBitmap(bmp);
//            //}
//        }
//    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 100) {
            // if(resultCode == RESULT_OK) {
            // 촬영 결과물을 MediaStore에 등록한다.
            // MediaStore에 등록하지 않으면, 우리 앱에서 만든 파일을 다른 앱에서는 사용할 수 없음
            Intent photoIntent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE,
                    Uri.parse("file://" + photopath));
            sendBroadcast(photoIntent);

            // imageView에 이미지 표시
            // 기존 이미지 제거
            imageView.setImageBitmap(null);
            // bitmap 객체는 메모리에 계속 상존하므로,
            // 메모리 해제를 시켜주어야 한다.
            if(bmp != null) {
                bmp.recycle();
                bmp = null;
            }
            // 썸네일 이미지 얻기
            bmp = PhotoHelper.getInstance().getThumb(this, photopath);
            // imageView에 출력
            imageView.setImageBitmap(bmp);
            // }
        }
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        //비트맵 객체는 메모리에 계속 상존하므로
        //메모리 해제를 시켜주어야 한다.
        if (bmp != null) {
            bmp.recycle();
            bmp = null;
        }
    }
}