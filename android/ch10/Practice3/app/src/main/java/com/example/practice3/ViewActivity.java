package com.example.practice3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.practice3.model.Keyword;

import org.w3c.dom.Text;

public class ViewActivity extends AppCompatActivity implements View.OnClickListener {
    TextView textView1, textView2, textView3;
    Button button1, button2;
    Keyword item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        textView1 = findViewById(R.id.textView1);
        textView2 = findViewById(R.id.textView2);
        textView3 = findViewById(R.id.textView3);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);

        item = (Keyword) getIntent().getSerializableExtra("item");

        textView1.setText(item.getPlace_name());
        textView2.setText(item.getPhone());
        textView3.setText(item.getAddress_name());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button1:
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(item.getPlace_url()));
                startActivity(intent);
                break;
            case R.id.button2:
                finish();
                break;
        }
    }
}