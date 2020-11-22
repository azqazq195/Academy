package com.example.a7_radioexamkotlin

import android.os.Bundle
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), RadioGroup.OnCheckedChangeListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        radioGroup.setOnCheckedChangeListener(this)
        button1.setOnClickListener{
            Toast.makeText(
                    this,
                    (findViewById<RadioButton>(radioGroup.checkedRadioButtonId)).text.toString(),
                    Toast.LENGTH_SHORT
            ).show()
        }
    }

    override fun onCheckedChanged(group: RadioGroup?, checkedId: Int) {
        var msg:String = ""
        when(group?.id){
            R.id.radioGroup -> {
                val radioButton = findViewById<RadioButton>(checkedId)
                msg = radioButton.text.toString()
            }
        }
        msg += "를 선택하였습니다."
        textView2.text = msg
    }
}