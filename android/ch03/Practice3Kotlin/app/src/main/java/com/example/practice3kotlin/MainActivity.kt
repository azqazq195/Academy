package com.example.practice3kotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1.setOnClickListener { textView.text = button1.text }
        button2.setOnClickListener { textView.text = button2.text }
        button3.setOnClickListener { textView.text = button3.text }
        button4.setOnClickListener { textView.text = button4.text }
    }
}