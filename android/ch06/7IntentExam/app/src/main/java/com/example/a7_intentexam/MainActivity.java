package com.example.a7_intentexam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.FileProvider;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.Settings;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Switch;

import java.io.File;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listView);
        listView.setOnItemClickListener(this);

        // 퍼미션 체크
        permissionCheck();
        permissionCheck2();
    }

    private void permissionCheck2() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            if(ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.READ_EXTERNAL_STORAGE)) {

            }
            else {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 101);
            }
        }
    }

    private void permissionCheck() {
        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE)
            != PackageManager.PERMISSION_GRANTED) {
            if(ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CALL_PHONE)){

            } else {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, 100);
            }
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = null;
        // 암묵적 인텐트 : Intent(액션, Uri)
        switch (position){
            case 0: // 전화 다이얼러 표시
                intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:01088977064"));
                startActivity(intent);
                break;
            case 1: // 전화 걸기
                intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:01088977064"));
                startActivity(intent);
                break;
            case 2: // 문자 발송 화면 호출
                intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:01088977064"));
                intent.putExtra("sms_body", "Hello Android");
                startActivity(intent);
                break;
            case 3: // 메일발송 화면 호출
                intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:hong@naver.com"));
                intent.putExtra(Intent.EXTRA_SUBJECT, "메일 테스트");
                intent.putExtra(Intent.EXTRA_TEXT, "안드로이드에서 메일발송 테스트입니다.");
                startActivity(intent);
                break;
            case 4:
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://m.naver.com"));
                startActivity(intent);
                break;
            case 5: // 주소록
                intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("content://contacts/people"));
                startActivity(intent);
                break;
            case 6: // 특정 App에 대한 구글 플레이 화면 호출
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=mok.android"));
                startActivity(intent);
                break;
            case 7: // 동영상 재생
                intent = new Intent(Intent.ACTION_VIEW);
                String video_path = Environment.getExternalStorageDirectory().getPath()
                        + "/칸초직캠.mp4";
                File video_file = new File(video_path);
                Uri video_uri = null;
                // 안드로이드 버전에 따라 명령어가 달라진다.
                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.N){
                    video_uri = FileProvider.getUriForFile(this, getApplicationContext().getPackageName()
                            + ".fileprovider", video_file);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                    intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                } else {
                    video_uri = Uri.fromFile(video_file);
                }
                intent.setDataAndType(video_uri, "video/*");
                startActivity(intent);
                break;
            case 8: // mp3 재생
                intent = new Intent(Intent.ACTION_VIEW);
                String audio_path = Environment.getExternalStorageDirectory().getPath()
                        + "/iu.mp3";
                File audio_file = new File(audio_path);
                Uri audio_uri = null;
                // 안드로이드 버전에 따라 명령어가 달라진다.
                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.N){
                    audio_uri = FileProvider.getUriForFile(this, getApplicationContext().getPackageName()
                            + ".fileprovider", audio_file);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                    intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                } else {
                    audio_uri = Uri.fromFile(audio_file);
                }
                intent.setDataAndType(audio_uri, "audio/*");
                startActivity(intent);
                break;
            case 9: // 환경설정 화면 호출
                intent = new Intent(Settings.ACTION_SETTINGS);
                startActivity(intent);
                break;
            case 10: // GPS 설정 화면 호출
                intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                startActivity(intent);
                break;
            case 11: // WIFI 설정화면 호출
                intent = new Intent(Settings.ACTION_WIFI_SETTINGS);
                startActivity(intent);
                break;
            case 12:
                intent = 
                break;
        }
    }
}