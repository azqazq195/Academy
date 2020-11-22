package com.example.a11_videoviewexam;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    VideoView videoView;    // 비디오뷰 객체
    MediaController mc;     // 재생버튼, 뒤로, 다음, 슬라이더바 등을 갖는 컨트롤러

    // 퍼미션 체크 확인용
    final int MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE = 100;
    boolean permissionCK = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 타이틀바 제거
        ActionBar actionBar = getSupportActionBar(); // ActionBar가 바로 타이틀바이다.
        actionBar.hide(); // 타이틀을 화면에서 사라지게하는 역할

        videoView = findViewById(R.id.videoView);
        mc = new MediaController(this);
        // VideoView에 Controller 연결
        videoView.setMediaController(mc);
        // Permission Check를 먼저 해야한다.
        permissionCheck();
        // Permission이 제대로 등록되었는지 확인
        if(permissionCK) startVideo();
    }

    private void startVideo() {
        // SD카드의 경로 얻기 (내부 저장소)
        File sdcard = Environment.getExternalStorageDirectory();
        String video_path = sdcard.getAbsolutePath() + "/칸초직캠.mp4";
        Log.d("[TEST]", video_path);
        // 비디오 뷰에 재생할 파일의 경로 지정
        videoView.setVideoPath(video_path);
        // 재생 시작
        videoView.start();
    }

    private void permissionCheck() {
        if(ActivityCompat.checkSelfPermission(this,
                Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            // 거부를 눌렀을 때, 두번째 실행헀을 때 퍼미션 창을 띄울 때
            if(ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.READ_EXTERNAL_STORAGE)){
            } else {  // 첫번째 실행했을 때 퍼미션 창을 띄울 때
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.READ_EXTERNAL_STORAGE,
                                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                                Manifest.permission.ACCESS_FINE_LOCATION},
                        MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE);
            }
        } else {
            permissionCK = true;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case  MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE:
                if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    startVideo();
                } else {
                    Toast.makeText(this, "동영상을 실행할 수가 없습니다.", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}