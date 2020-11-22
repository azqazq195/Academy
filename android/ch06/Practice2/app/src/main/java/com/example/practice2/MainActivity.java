package com.example.practice2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText editText1, editText2;
    Button button1, button2;
    String id, pw, hobby;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button1:
                if(id != null && pw != null){
                    if(editText1.getText().toString().trim().equals(id) &&
                        editText2.getText().toString().trim().equals(pw)){
                        Toast.makeText(this, "로그인 완료", Toast.LENGTH_SHORT).show();
                        Toast.makeText(this, id + "\n" + pw + "\n" + hobby, Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText(this, "로그인 실패", Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    Toast.makeText(this, "회원정보 없음", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.button2:
                Intent intent = new Intent(this, MemberActivity.class);
                startActivityForResult(intent, 100);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 100:
                if(resultCode == RESULT_OK){
                    id = data.getStringExtra("id");
                    pw = data.getStringExtra("pw");
                    hobby = data.getStringExtra("hobby");
                }
        }
    }
}