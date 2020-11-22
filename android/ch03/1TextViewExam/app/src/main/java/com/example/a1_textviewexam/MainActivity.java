package com.example.a1_textviewexam;

import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    // (1) 사용할 컴포넌트에 대한 객체를 선언
    // => 이때 객체명은 xml파일의 id와 통일시킨다.
    TextView textView3, textView4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // (2) 메모리에 생성된 객체 찾아오기기
        textView3 = findViewById(R.id.textView3);
        textView4 = findViewById(R.id.textView4);

        // (3) 내용 설정
        textView3.setText("안녕하세요. 안드로이드");
        textView4.setText(R.string.my_text);

        // (4) 글자 생상 지정하기
        int color = Color.rgb(255, 0, 0);
        textView3.setTextColor(color);

        // Resources : res 폴더를 관리하는 객체
        Resources r = getResources();
        int color2 = r.getColor(R.color.my_blue);
        textView4.setTextColor(color2);

        // (5) 배경 색상 지정하기
        textView3.setBackgroundColor(Color.rgb(255,255,0));
        textView4.setBackgroundColor(getResources().getColor(R.color.my_orange));

        // (6) 글자 크기 속성
        textView3.setTextSize(30);
        float size = getResources().getDimension(R.dimen.my_size);
        textView4.setTextSize(size/2.5f);

        // (7) Single Line 속성
        textView4.setSingleLine(true);
        textView4.setEllipsize(TextUtils.TruncateAt.END);
    }
}