package com.example.a6_cleartopexam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Join3Activity extends AppCompatActivity {
    TextView textView1, textView2, textView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join3);

        textView1 = findViewById(R.id.textView1);
        textView2 = findViewById(R.id.textView2);
        textView3 = findViewById(R.id.textView3);

        textView1.setText(getIntent().getStringExtra("user_id"));
        textView2.setText(getIntent().getStringExtra("user_pw"));
        textView3.setText(getIntent().getStringExtra("hobby"));
    }
}