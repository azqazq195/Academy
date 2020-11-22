package com.example.practice4kotlin

import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener{
            var msg:String = "";
            if(editTextTextPersonName1.text.toString() == ""
                || editTextTextPersonName2.text.toString() == ""){
                Toast.makeText(this, "이름이나 나이가 입력되지 않았습니다.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            msg += editTextTextPersonName1.text.toString() + "\n"
            msg += editTextTextPersonName2.text.toString() + "\n"
            val radioButton = findViewById<RadioButton>(radioGroup.checkedRadioButtonId)
            msg += radioButton.text.toString()
            if(checkBox1.isChecked || checkBox2.isChecked || checkBox3.isChecked){
                msg += "\n"
                if(checkBox1.isChecked){
                    msg += checkBox1.text.toString() + " "
                }
                if(checkBox2.isChecked){
                    msg += checkBox2.text.toString() + " "
                }
                if(checkBox3.isChecked){
                    msg += checkBox3.text.toString() + " "
                }
            }
            msg = msg.trim()
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
        }
    }
}