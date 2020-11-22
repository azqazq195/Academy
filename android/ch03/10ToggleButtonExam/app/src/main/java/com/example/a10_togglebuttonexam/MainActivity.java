package com.example.a10_togglebuttonexam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {

    TextView textView1, textView2;
    ToggleButton toggleButton1, toggleButton2;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toggleButton1 = findViewById(R.id.toggleButton1);
        toggleButton2 = findViewById(R.id.toggleButton2);
        button = findViewById(R.id.button);
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        switch (buttonView.getId()){
            case R.id.toggleButton1:
                if(isChecked) {
                    textView1.setText(toggleButton1.getTextOn());
                } else {
                    textView1.setText(toggleButton1.getTextOff());
                }
                break;
            case R.id.toggleButton2:
                if(isChecked){
                    textView2.setText("좋아요 눌러짐");
                } else {
                    textView2.setText("좋아요 취소됨");
                }
                break;
        }
    }
}