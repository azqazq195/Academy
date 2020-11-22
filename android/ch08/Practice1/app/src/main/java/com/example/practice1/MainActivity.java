package com.example.practice1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.speech.tts.TextToSpeech;
import android.speech.tts.Voice;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.practice1.helper.FileHelper;

import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;

public class MainActivity extends AppCompatActivity
    implements View.OnClickListener, TextToSpeech.OnInitListener {
    Button button, button2;
    TextView textView;
    TextToSpeech tts;
    boolean init;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);
        textView = findViewById(R.id.textView);
        tts = new TextToSpeech(this, this);
        init = false;

        button.setOnClickListener(this);
        button2.setOnClickListener(this);
        permissionCheck();
    }

    private void permissionCheck() {
        if(ActivityCompat.checkSelfPermission(this,
                Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            if(ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.READ_EXTERNAL_STORAGE)) {

            } else {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 100);
            }
        }
    }

    @Override
    public void onInit(int status) {
        init = (status == TextToSpeech.SUCCESS);
        String msg = "엔진이 초기화에 실패했습니다.";
        if(init) msg = "엔진이 초기화 되었습니다.";
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(tts != null) {
            tts.stop();
            tts.shutdown();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                // 파일 읽기
//              String filePath = Environment.getExternalStorageDirectory().getAbsolutePath()
//                + "/tts.txt";
                //String msg = FileHelper.getInstance().readString(filePath, "utf-8");

                InputStream inputStream = getResources().openRawResource(R.raw.tts);
                String msg = null;
                try {
                    byte[] temp =new byte[inputStream.available()];
                    inputStream.read(temp);
                    msg = new String(temp);
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                // 데이터 검사
                if (msg.equals("") || msg == null) {
                    Toast.makeText(this, "읽어줄 내용이 없습니다.", Toast.LENGTH_SHORT).show();
                    return;
                }
                textView.setText(msg);

                // tts 초기화 확인
                if(!init) {
                    Toast.makeText(this, "아직 초기화 되지 않았습니다.",
                            Toast.LENGTH_SHORT).show();
                    return;
                }

                Locale locale = Locale.KOREA;
                if(tts.isLanguageAvailable(locale) < 0) {
                    Toast.makeText(this, "지원하지 않는 언어입니다.",
                            Toast.LENGTH_SHORT).show();
                    return;
                }
                // tts 설정
                tts.setLanguage(locale);
                // 남자 목소리 설정
                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    for(Voice voice : tts.getVoices()) {
                        Log.d("[TEST]", "test1 " + voice + "\n");
                        if(voice.getName().equals("ko-KR-SMTm01")) {
                            tts.setVoice(voice);
                        }
                    }
                }

                tts.speak(msg, TextToSpeech.QUEUE_FLUSH, null);
                break;
            case R.id.button2:
                tts.stop();
                break;
        }

    }
}








