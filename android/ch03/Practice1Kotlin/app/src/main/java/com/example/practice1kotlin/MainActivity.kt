package com.example.practice1kotlin

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView3.text = "오늘도 열심히.."
        textView4.text = "거울의 입구에서.."

        textView3.textSize = 30F
        textView4.textSize = resources.getDimension(R.dimen.my_size/2)

        textView3.setTextColor(Color.rgb(255, 55, 0))
        textView4.setTextColor(Color.rgb(100, 100, 0))

        val r2 = resources.getColor(R.color.my_yellow)
        textView3.setBackgroundColor(Color.rgb(0, 0, 100))
        textView4.setBackgroundColor(r2)
    }
}