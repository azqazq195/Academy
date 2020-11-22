package com.example.practice4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.practice4.model.Member;

import java.io.Serializable;
import java.util.List;

public class InputActivity extends AppCompatActivity implements View.OnClickListener {
    EditText editText1, editText2, editText3, editText4;
    Button button1, button2;
    List<Member> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        list = (List<Member>) getIntent().getSerializableExtra("list");

        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);
        editText3 = findViewById(R.id.editText3);
        editText4 = findViewById(R.id.editText4);

        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button1:
                String name = editText1.getText().toString().trim();
                String email = editText2.getText().toString().trim();
                String phone = editText3.getText().toString().trim();
                String addr = editText4.getText().toString().trim();

                list.add(new Member(name, email, phone, addr));

                editText1.setText("");
                editText2.setText("");
                editText3.setText("");
                editText4.setText("");

                Toast.makeText(this, "입력 완료", Toast.LENGTH_SHORT).show();
                Log.d("[INFO]", list.toString());
                break;
            case R.id.button2:
                Intent intent = new Intent();
                intent.putExtra("list", (Serializable) list);
                setResult(RESULT_OK, intent);
                finish();
                break;
        }
    }
}