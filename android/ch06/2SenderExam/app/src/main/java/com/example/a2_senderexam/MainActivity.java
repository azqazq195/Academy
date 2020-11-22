package com.example.a2_senderexam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    // 객체 선언
    EditText editText1, editText2;
    Button button;
    String phoneNo, message;
    // 문자메시지 관리 클래스
    SmsManager sms;
    // 눌림상태 확인 : 여러번 전성되느 ㄴ것 방지
    boolean pressCheck = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 객체 초기화
        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);
        button = findViewById(R.id.button);
        sms = SmsManager.getDefault();
        // 이벤트 설정
        button.setOnClickListener(this);
        // 퍼미션 체크
        permissionCheck();
    }

    private void permissionCheck() {
        // 퍼미션이 허락되어있지 않으면
        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS)
            != PackageManager.PERMISSION_GRANTED) {
            if(ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.SEND_SMS)) {

            } else {
                ActivityCompat.requestPermissions(this,
                        new String[] {Manifest.permission.SEND_SMS}, 100);
            }
        }
    }

    @Override
    public void onClick(View v) {
        // 사용자가 입력한 내용으로 설정
        phoneNo = editText1.getText().toString().trim();
        message = editText2.getText().toString().trim();
        if(!phoneNo.equals("") && !message.equals("")) {
            Toast.makeText(this, "전화번호와 메시지 설정 완료",
                    Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "전화번호와 메시지를 입력해주세요.",
                    Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_VOLUME_DOWN:
                if(!pressCheck){
                    // 딱 한번만 문자발송을 하기 위해서, 눌림 상태임을 저장함
                    pressCheck = true;
                    // 입력값 검사
                    if(phoneNo == null || message == null || phoneNo.equals("") || message.equals("")) {
                        Toast.makeText(this, "전화번호나 메시지가 설정되지 않았습니다.",
                                Toast.LENGTH_SHORT).show();
                        return false; // 강제 종료
                    }
                    // 문자 발송하기
                    sms.sendTextMessage(phoneNo, null, message, null , null);
                }
                return true;
            case KeyEvent.KEYCODE_BACK:
                finish();
                return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        pressCheck = false; // 키에서 떨어진 상태
        return super.onKeyUp(keyCode, event);
    }
}