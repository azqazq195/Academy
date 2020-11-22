package com.example.a9_patterncheckerexam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.a9_patterncheckerexam.helper.RegexHelper;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    Button button;
    EditText editText1, editText2, editText3, editText4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);

        editText1 = findViewById(R.id.editTextTextPersonName1);
        editText2 = findViewById(R.id.editTextTextEmailAddress);
        editText3 = findViewById(R.id.editTextTextPostalAddress);
        editText4 = findViewById(R.id.editTextPhone);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 사용자가 입력한 값
                String name = editText1.getText().toString().trim();
                String email = editText2.getText().toString().trim();
                String address = editText3.getText().toString().trim();
                String tel = editText4.getText().toString().trim();

                // 문자열이 형식에 맞지 않을 경우, 에러메세지를 담기위한 변수
                // 입력 검사
                String err_msg = null;
                if(err_msg == null && !RegexHelper.getInstance().isValue(name)){
                    err_msg = "이름을 입력해 주세요.";
                }
                if(err_msg == null && !RegexHelper.getInstance().isKor(name)){
                    err_msg = "이름은 한글로만 작성해주세요.";
                }
                if(err_msg == null && !RegexHelper.getInstance().isValue(email)){
                    err_msg = "이메일 주소를 입력해 주세요.";
                }
                if(err_msg == null && !RegexHelper.getInstance().isEmail(email)){
                    err_msg = "이메일 형식에 맞게 작성해주세요.";
                }
                if(err_msg == null && !RegexHelper.getInstance().isValue(address)){
                    err_msg = "주소를 입력해 주세요.";
                }
                if(err_msg == null && !RegexHelper.getInstance().isKorNum(address)){
                    err_msg = "주소형식에 맞게 작성해주세요.";
                }
                if(err_msg == null && !RegexHelper.getInstance().isValue(tel)){
                    err_msg = "전화번호를 입력해 주세요.";
                }
                if(err_msg == null && !RegexHelper.getInstance().isPhone(tel)){
                    err_msg = "전화번호는 숫자로만 작성해주세요.";
                }

                if(err_msg != null){
                    Toast.makeText(getApplicationContext(), err_msg, Toast.LENGTH_SHORT).show();
                    return;
                }

                // 결과를 문자열에 저장한 후, 출력
                String result = String.format(
                                "이름\t: %s\n" +
                                "이메일\t: %s\n" +
                                "주소\t: %s\n" +
                                "핸드폰\t: %s"
                , name, email, address, tel);
                Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
            }
        });

    }
}