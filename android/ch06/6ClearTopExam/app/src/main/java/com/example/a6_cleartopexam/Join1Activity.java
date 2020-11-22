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

public class Join1Activity extends AppCompatActivity implements View.OnClickListener {
    EditText editText1, editText2;
    Button button;
    String user_id;
    String user_pw;
    String hobby;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join1);

        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);
        button = findViewById(R.id.button);

        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(!editText1.getText().toString().equals("") &&
            !editText2.getText().toString().equals("")){

            user_id = editText1.getText().toString().trim();
            user_pw = editText2.getText().toString().trim();
            Log.d("[TEST]", "join1 user_id : " + user_id);
            Log.d("[TEST]", "join1 user_pw : " + user_pw);
            Intent intent = new Intent(this, Join2Activity.class);
            startActivityForResult(intent, 100);
        }
        else {
            Toast.makeText(this, "아이디, 비밀번호를 입력해 주세요.", Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 100:
                if(resultCode == RESULT_OK){
                    Log.d("[TEST]" , "RUN" );
                    hobby = data.getStringExtra("hobby");
                    Intent intent = new Intent();
                    intent.putExtra("user_id", user_id);
                    intent.putExtra("user_pw", user_pw);
                    intent.putExtra("hobby", hobby);
                    setResult(RESULT_OK, intent);
                    finish();
                }
        }
    }
}