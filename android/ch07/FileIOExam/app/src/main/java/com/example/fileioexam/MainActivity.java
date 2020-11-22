package com.example.fileioexam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fileioexam.helper.ObjectInOut;
import com.example.fileioexam.model.Student;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText editText1, editText2, editText3;
    Button button1, button2, button3, button4;
    TextView textView4;
    List<Student> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);
        editText3 = findViewById(R.id.editText3);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        textView4 = findViewById(R.id.textView4);

        list = new ArrayList<>();

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        // 저장 경로 설정 : 내 앱 폴더에 저장
        String fname = getFilesDir().getAbsolutePath() + "/student.txt";

        switch (v.getId()) {
            case R.id.button1:  // 리스트에 저장
                String name = editText1.getText().toString().trim();
                int age = Integer.parseInt(editText2.getText().toString().trim());
                String addr = editText3.getText().toString().trim();
                list.add(new Student(name, age, addr));
                // 입력 초기화
                editText1.setText("");
                editText2.setText("");
                editText3.setText("");
                Toast.makeText(this, "리스트에 저장", Toast.LENGTH_SHORT).show();
                break;
            case R.id.button2:  // 출력
                StringBuilder result = new StringBuilder();
                for(Student student : list){
                    result.append(student.getName())
                            .append(", ")
                            .append(student.getAge())
                            .append(", ")
                            .append(student.getAddr())
                            .append("\n");
                }
                textView4.setText(result.toString());
                break;
            case R.id.button3:  // 파일에 저장
                boolean result3 = ObjectInOut.getInstance().write(fname, list);
                String msg = result3 ? "저장 성공" : "저장 실패";
                Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
                break;
            case R.id.button4:  // 파일 읽기
                list.clear();   // 모든 데이터 지우기
                list = ObjectInOut.getInstance().read(fname);
                Toast.makeText(this, "파일 읽기", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}