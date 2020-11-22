package com.example.a3_buttoneventexam;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Calculate calculate = new Calculate() {
            @Override
            public int operation(int x, int y) {
                return x+y;
            }
        };
        Toast.makeText(this, String.valueOf(calculate.operation(100, 200)),
                Toast.LENGTH_SHORT).show();

        Calculate calculate1 = (int x, int y) -> {return x+y;};
        Toast.makeText(this, String.valueOf(calculate1.operation(200, 300)),
                Toast.LENGTH_SHORT).show();

        Calculate calculate2 = (x, y) -> {return x+y;};
        Toast.makeText(this, String.valueOf(calculate2.operation(20, 30)),
                Toast.LENGTH_SHORT).show();

        Calculate calculate3 = (x, y) -> x+y;
        Toast.makeText(this, String.valueOf(calculate3.operation(40, 30)),
                Toast.LENGTH_SHORT).show();

        Toast.makeText(this, String.valueOf(((Calculate)(x, y) -> x+y).operation(5, 7)),
                Toast.LENGTH_SHORT).show();
    }
}

interface Calculate {
    int operation(int x, int y);
}