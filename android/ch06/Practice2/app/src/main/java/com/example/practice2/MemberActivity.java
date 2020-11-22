package com.example.practice2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MemberActivity extends AppCompatActivity implements View.OnClickListener {
    TextView textView11, textView12, textView21;
    EditText editText11, editText12;
    Button button11, button21, button12, button22;
    CheckBox checkBox21, checkBox22, checkBox23;
    LinearLayout layout1, layout2;

    String id = "";
    String pw = "";
    String hobby = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member);

        textView11 = findViewById(R.id.textView11);
        textView12 = findViewById(R.id.textView12);
        textView21 = findViewById(R.id.textView21);
        editText11 = findViewById(R.id.editText11);
        editText12 = findViewById(R.id.editText12);
        button11 = findViewById(R.id.button11);
        button12 = findViewById(R.id.button12);
        button21 = findViewById(R.id.button21);
        button22 = findViewById(R.id.button22);
        checkBox21 = findViewById(R.id.checkBox21);
        checkBox22 = findViewById(R.id.checkBox22);
        checkBox23 = findViewById(R.id.checkBox23);
        layout1 = findViewById(R.id.layout1);
        layout2 = findViewById(R.id.layout2);

        button11.setOnClickListener(this);
        button12.setOnClickListener(this);
        button21.setOnClickListener(this);
        button22.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button11:
                layout1.setVisibility(View.GONE);
                layout2.setVisibility(View.VISIBLE);
                break;
            case R.id.button12:
                finish();
                break;
            case R.id.button21:
                Intent intent = new Intent();
                if(saveInfo()){
                    intent.putExtra("id", id);
                    intent.putExtra("pw", pw);
                    intent.putExtra("hobby", hobby);
                    setResult(RESULT_OK, intent);
                    finish();
                }
                break;
            case R.id.button22:
                layout1.setVisibility(View.VISIBLE);
                layout2.setVisibility(View.GONE);
                break;
        }
    }

    private boolean saveInfo() {
        id = editText11.getText().toString().trim();
        pw = editText12.getText().toString().trim();
        if(checkBox21.isChecked()){
            hobby += checkBox21.getText().toString() + "\n";
        }
        if(checkBox22.isChecked()){
            hobby += checkBox22.getText().toString() + "\n";
        }
        if(checkBox23.isChecked()){
            hobby += checkBox23.getText().toString() + "\n";
        }

        if(id.equals("") && pw.equals("")){
            Toast.makeText(this, "아이디와 비밀번호를 입력해 주세요.", Toast.LENGTH_SHORT).show();
            return false;
        }

        if(hobby.equals("")){
            Toast.makeText(this, "취미를 입력해 주세요.", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }

}