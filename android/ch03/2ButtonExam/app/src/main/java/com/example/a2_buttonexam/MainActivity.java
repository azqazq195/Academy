package com.example.a2_buttonexam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button button1, button2;
    ImageButton imgButton1, imgButton2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);

        imgButton1 = findViewById(R.id.imgButton1);
        imgButton2 = findViewById(R.id.imgButton2);

        // 버튼에 이벤트 설정
        // onclick이 이 클래스에 있기 때문에 this 를 줬다.
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        imgButton1.setOnClickListener(this);
        imgButton2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) { // 부모는 어떤 자식클래스든 포함할 수 있다.
        int id = v.getId();
        String message = null;

        switch (id){
            case R.id.button1:
                message = "당신은 남자입니다.";
                break;
            case R.id.button2:
                message = "당신은 여자입니다.";
                break;
            case R.id.imgButton1:
                message = "남자를 선택하셨습니다.";
                break;
            case R.id.imgButton2:
                message = "여자를 선택하셨습니다.";
                break;
        }
        Toast toast = Toast.makeText(this, message, Toast.LENGTH_SHORT);
        toast.show();
    }
}