package com.example.a10_togglebuttonexamkotlin

import android.os.Bundle
import android.view.View
import android.widget.CompoundButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toggleButton2.isChecked = true;

        toggleButton1.setOnCheckedChangeListener(this)
        toggleButton2.setOnCheckedChangeListener(this)
        button.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        // 각 ToggleButton의 상태 얻기
        val checked1 = toggleButton1.isChecked
        val checked2 = toggleButton2.isChecked
        val msg1 = if(checked1) "설정됨" else "설정해제"
        val msg2 = if(checked2) "설정됨" else "설정해제"

        Toast.makeText(this, "기본버튼 : " + msg1 + " / 이미지버튼 : " + msg2
            , Toast.LENGTH_SHORT).show()
    }

    override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
        when (buttonView!!.id) {
            R.id.toggleButton1 -> if (isChecked) {
                textView1.text = toggleButton1.textOn
            } else {
                textView1.text = toggleButton1.textOff
            }
            R.id.toggleButton2 -> if (isChecked) {
                textView2.text = "좋아요 눌러짐"
            } else {
                textView2.text = "좋아요 취소됨"
            }
        }
    }
}