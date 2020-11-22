package com.example.a1_textviewexamkotlin

import android.content.res.Resources
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import androidx.core.content.ContextCompat.getColor

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // (2) 메모리에 생성된 객체 찾아오기기 (생략)
        // (3) 내용 설정
        textView3.text = "안녕하세요. 안드로이드"
        textView4.setText(R.string.my_text)

        // (4) 글자 생상 지정하기
        val color = Color.rgb(255, 0, 0)
        textView3.setTextColor(color)

        // Resources : res 폴더를 관리하는 객체
        val color2 = resources.getColor(R.color.my_blue)
        textView4.setTextColor(color2)

        // (5) 배경 색상 지정하기
        textView3.setBackgroundColor(Color.rgb(255,255,0))
        textView4.setBackgroundColor(resources.getColor(R.color.my_orange))

        // (6) 글자 크기 속성
        textView3.textSize = 30F
        val size = resources.getDimension(R.dimen.my_size)
        textView4.textSize = (size/2.5).toFloat()

        // (7) Single Line 속성
        textView4.isSingleLine = true
        textView4.ellipsize = TextUtils.TruncateAt.END
    }
}