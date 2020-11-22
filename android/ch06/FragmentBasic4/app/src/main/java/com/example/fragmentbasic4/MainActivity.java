package com.example.fragmentbasic4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button button1, button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(savedInstanceState == null){
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new Test1Fragment())
                    .commit();
        }

        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button1:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, new Test1Fragment())
                        .commit();
                break;
            case R.id.button2:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, new Test2Fragment())
                        .commit();
                break;
        }
    }
}