package com.example.a7_radioexam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, RadioGroup.OnCheckedChangeListener {
    RadioGroup radioGroup;
    RadioButton radioButton1, radioButton2;
    TextView textView1, textView2;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioButton1 = findViewById(R.id.radioButton1);
        radioButton2 = findViewById(R.id.radioButton2);
        textView1 = findViewById(R.id.textView1);

        radioGroup.setOnCheckedChangeListener(this);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button:
                // 선택된 라디오버튼의 id값 얻기
                int checkedId = radioGroup.getCheckedRadioButtonId();
                RadioButton radioButton = findViewById(checkedId);
                Toast.makeText(this, radioButton.getText(), Toast.LENGTH_SHORT).show();
                break;
        }
    }

    /*
    라디오 버튼으 클릭헀을 때
    @param group : 클릭된 라디오 버튼을 감싸고 있는 라디오 그룹 객체
    @param checkedId : 선택된 라디오 버튼의 id
     */

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (group.getId()){
            case R.id.radioGroup:
                RadioButton radioButton = findViewById(checkedId);
                textView2.setText(radioButton.getText());
                break;
        }
    }
}