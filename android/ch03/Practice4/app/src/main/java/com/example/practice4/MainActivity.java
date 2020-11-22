package com.example.practice4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editText1, editText2;
    RadioGroup radioGroup;
    CheckBox checkBox1, checkBox2, checkBox3;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        editText1 = findViewById(R.id.editTextTextPersonName1);
        editText2 = findViewById(R.id.editTextTextPersonName2);
        radioGroup = findViewById(R.id.radioGroup);
        checkBox1 = findViewById(R.id.checkBox1);
        checkBox2 = findViewById(R.id.checkBox2);
        checkBox3 = findViewById(R.id.checkBox3);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // editText 값 읽기
                String name = editText1.getText().toString().trim();
                int age = 0;
                String age_str = editText2.getText().toString().trim();
                if(!age_str.equals("")){
                    age = Integer.parseInt(age_str);
                }
                // 라디오버튼 값 일기
                int checkedId = radioGroup.getCheckedRadioButtonId();
                RadioButton radioButton = findViewById(checkedId);
                String gender = radioButton.getText().toString();

                // checkBox 값 일기
                String hobby = "";
                if(checkBox1.isChecked()){
                    hobby += checkBox1.getText().toString() + " ";
                }
                if(checkBox2.isChecked()){
                    hobby += checkBox2.getText().toString() + " ";
                }
                if(checkBox3.isChecked()){
                    hobby += checkBox3.getText().toString() + " ";
                }
                hobby = hobby.trim();

                // 결과 값 출력
                String result = "이름 : " + name + "\n"
                        + "나이 : " + age + "\n"
                        + "성별 : " + gender + "\n"
                        + "취미 : " + hobby;
                Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
            }
        });
    }
}