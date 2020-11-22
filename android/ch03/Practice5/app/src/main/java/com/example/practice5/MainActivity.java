package com.example.practice5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button button1, button2, button3,
            button4, button5, button6,
            button7, button8, button9,
            buttonDiv, buttonMul, buttonMin,
            button0, buttonPM, buttonDot,
            buttonPlu, buttonEqu, buttonCan;
    TextView textView;
    String calculate;
    Double num1, num2;
    String op;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        button0 = findViewById(R.id.button0);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);
        buttonDiv = findViewById(R.id.buttonDiv);
        buttonMul = findViewById(R.id.buttonMul);
        buttonMin = findViewById(R.id.buttonMin);
        buttonPM = findViewById(R.id.buttonPM);
        buttonDot = findViewById(R.id.buttonDot);
        buttonPlu = findViewById(R.id.buttonPlu);
        buttonEqu = findViewById(R.id.buttonEqu);
        buttonCan = findViewById(R.id.buttonCan);

        button0.setOnClickListener(this);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);
        buttonDiv.setOnClickListener(this);
        buttonMul.setOnClickListener(this);
        buttonMin.setOnClickListener(this);
        buttonPM.setOnClickListener(this);
        buttonDot.setOnClickListener(this);
        buttonPlu.setOnClickListener(this);
        buttonEqu.setOnClickListener(this);
        buttonCan.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String input = "";
        if(textView.getText().toString().equals("0")){
            textView.setText("");
        }
        switch(v.getId()){
            case R.id.button0:
                if(textView.getText().toString().equals("")){
                    textView.setText("0");
                } else {
                    input = textView.getText().toString() + button0.getText().toString();
                    textView.setText(input);
                    input = "";
                }
                break;
            case R.id.button1:
                input = textView.getText().toString() + button1.getText().toString();
                textView.setText(input);
                input = "";
                break;
            case R.id.button2:
                input = textView.getText().toString() + button2.getText().toString();
                textView.setText(input);
                input = "";
                break;
            case R.id.button3:
                input = textView.getText().toString() + button3.getText().toString();
                textView.setText(input);
                input = "";
                break;
            case R.id.button4:
                input = textView.getText().toString() + button4.getText().toString();
                textView.setText(input);
                input = "";
                break;
            case R.id.button5:
                input = textView.getText().toString() + button5.getText().toString();
                textView.setText(input);
                input = "";
                break;
            case R.id.button6:
                input = textView.getText().toString() + button6.getText().toString();
                textView.setText(input);
                input = "";
                break;
            case R.id.button7:
                input = textView.getText().toString() + button7.getText().toString();
                textView.setText(input);
                input = "";
                break;
            case R.id.button8:
                input = textView.getText().toString() + button8.getText().toString();
                textView.setText(input);
                input = "";
                break;
            case R.id.button9:
                input = textView.getText().toString() + button9.getText().toString();
                textView.setText(input);
                input = "";
                break;
            case R.id.buttonDiv:
                input = textView.getText().toString();
                if(input.equals("")){
                    textView.setText("0");
                    break;
                }
                num1 = Double.parseDouble(textView.getText().toString());
                op = buttonDiv.getText().toString();
                textView.setText("0");
                break;
            case R.id.buttonMul:
                input = textView.getText().toString();
                if(input.equals("")){
                    textView.setText("0");
                    break;
                }
                num1 = Double.parseDouble(textView.getText().toString());
                op = buttonMul.getText().toString();
                textView.setText("0");
                break;
            case R.id.buttonMin:
                input = textView.getText().toString();
                if(input.equals("")){
                    textView.setText("0");
                    break;
                }
                num1 = Double.parseDouble(textView.getText().toString());
                op = buttonMin.getText().toString();
                textView.setText("0");
                break;
            case R.id.buttonPM:
                input = textView.getText().toString();
                if(input.equals("")){
                    textView.setText("0");
                    break;
                }
                if(input.charAt(0) != '-'){
                    input = "-" + input;
                } else {
                    input = input.substring(1, input.length());
                }
                textView.setText(input);
                break;
            case R.id.buttonDot:
                input = textView.getText().toString();
                if(input.equals("")){
                    textView.setText("0.");
                    break;
                }
                if(input.charAt(input.length()-1) != '.' && !input.contains(".")){
                    input = textView.getText().toString() + buttonDot.getText().toString();
                }
                textView.setText(input);
                break;
            case R.id.buttonPlu:
                input = textView.getText().toString();
                if(input.equals("")){
                    textView.setText("0");
                    break;
                }
                num1 = Double.parseDouble(textView.getText().toString());
                op = buttonPlu.getText().toString();
                textView.setText("0");
                break;
            case R.id.buttonEqu:
                input = textView.getText().toString();
                if(input.equals("")){
                    textView.setText("0");
                    break;
                }
                num2 = Double.parseDouble(textView.getText().toString());
                textView.setText(eval(num1, num2, op));
                break;
            case R.id.buttonCan:
                textView.setText("0");
                break;

        }
    }

    public String eval(double num1, double num2, String op){
        String result = "";
        double resultNum = 0;

        switch (op) {
            case "+":
                resultNum = num1 + num2;
                break;
            case "-":
                resultNum = num1 - num2;
                break;
            case "*":
                resultNum = num1 * num2;
                break;
            case "/":
                resultNum = num1 / num2;
                break;
        }
        if(resultNum - (int) resultNum == 0){
            result = Integer.toString((int) resultNum);
        } else {
            result = Double.toString(Math.round(resultNum*10000d) / 10000d);
        }
        return result;
    }
}