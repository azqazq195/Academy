package com.example.lotto;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn ;
    TextView textField;
    EditText editTextNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textField = findViewById(R.id.textField);
        editTextNumber = findViewById(R.id.editTextNumber);
        btn = findViewById(R.id.button);

        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        int number = Integer.parseInt(editTextNumber.getText().toString());
        int temp;
        StringBuilder sb = new StringBuilder();
        List<Integer> list = new ArrayList<>();

        while(number-->0){
            while(true){
                if(list.size() == 6){
                    Collections.sort(list);
                    for(int i : list){
                        sb.append(String.format("%02d",i)+" ");
                    }
                    sb.append("\n");
                    list.clear();
                    break;
                }

                temp = (int) (Math.random() * 45 + 1);
                if(!list.contains(temp)){
                    list.add(temp);
                }
            }
        }

        /*
        String output="\n";

        for(int i=0;i<number;i++) {
            List<Integer> list = new ArrayList<Integer>();
            for (int j = 0; j < 6; j++) {
                while (true) {
                    temp = (int) (Math.random() * 45 + 1);
                    if (!list.contains(temp)) {
                        list.add(temp);
                        output += String.format("%02d",temp) + "    ";
                        break;
                    }
                }
            }
            list=null;
            output += "\n\n";
        }
        */

        textField.setText(sb);
    }

}