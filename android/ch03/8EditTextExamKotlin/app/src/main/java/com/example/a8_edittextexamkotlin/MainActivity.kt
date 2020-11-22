package com.example.a8_edittextexamkotlin

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener{
            var id = "";
            var pw = "";

            id = editTextTextPersonName.text.toString()
            pw = editTextNumberPassword.text.toString()

            if (id == "" || pw == "") {
                Toast.makeText(this, "아이디나 비밀번호가 입력되지 않았습니다.", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "$id / $pw", Toast.LENGTH_SHORT).show()
            }
        }

    }
}