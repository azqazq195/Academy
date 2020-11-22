package com.example.a6_cleartopexam;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText editText1, editText2;
    Button button1, button2;
    String user_id = "";
    String user_pw = "";
    String hobby = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()){
            case R.id.button1:
                String id = editText1.getText().toString().trim();
                String pw = editText2.getText().toString().trim();
                String result = "아이디 : " + id + "\n" + "비밀번호 : " + pw;
                Toast.makeText(this, result, Toast.LENGTH_SHORT).show();

                if(user_id.equals(editText1.getText().toString()) &&
                        user_pw.equals(editText2.getText().toString())){
                    intent = new Intent(this, Join3Activity.class);
                    intent.putExtra("user_id", user_id);
                    intent.putExtra("user_pw", user_pw);
                    intent.putExtra("hobby", hobby);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(this, "아이디와 비밀번호를 확인하세요", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.button2:
                intent = new Intent(this, Join1Activity.class);
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
                    Log.d("[TEST]" , "RUN" );
                    user_id = data.getStringExtra("user_id");
                    user_pw = data.getStringExtra("user_pw");
                    hobby = data.getStringExtra("hobby");
                }
        }
    }

}