package com.example.practice1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView3, textView4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView3 = findViewById(R.id.textView3);
        textView4 = findViewById(R.id.textView4);

        textView3.setText("오늘도 열심히...");
        textView3.setTextColor(Color.rgb(255,0,0));
        textView3.setBackgroundColor(Color.rgb(0,0,100));
        textView3.setTextSize(30);

        textView4.setText(R.string.my_text2);
        textView4.setTextColor(getResources().getColor(R.color.my_blue));
        textView4.setBackgroundColor(getResources().getColor(R.color.my_pink));
        textView4.setTextSize(getResources().getDimension(R.dimen.my_size2));
    }
}