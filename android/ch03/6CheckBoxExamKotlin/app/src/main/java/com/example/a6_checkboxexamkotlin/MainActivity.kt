package com.example.a6_checkboxexamkotlin

import android.os.Bundle
import android.view.View
import android.widget.CompoundButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), CompoundButton.OnCheckedChangeListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        checkBox1.setOnCheckedChangeListener(this)
        checkBox2.setOnCheckedChangeListener(this)
        checkBox3.setOnCheckedChangeListener(this)

        // button.setOnClickListener(this)
    }
/*
    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.button -> {
                var msg = ""
                if (checkBox1.isChecked) {
                    msg += checkBox1.text.toString() + " "
                }
                if (checkBox2.isChecked) {
                    msg += checkBox2.text.toString() + " "
                }
                if (checkBox3.isChecked) {
                    msg += checkBox3.text.toString() + " "
                }
                if (msg == "") {
                    msg = "체크된 것이 없습니다."
                }
                Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
            }
        }
    }
*/
    override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
        var msg = buttonView?.text.toString()

        if(isChecked){
            msg += "가 체크되었습니다."
        } else {
            msg += "가 체크 해제되었습니다."
        }
        textView2.text = msg

    }

    fun onButtonClick(view: View) {
        when (view.id) {
            R.id.button -> {
                var msg = ""
                if (checkBox1.isChecked) {
                    msg += checkBox1.text.toString() + " "
                }
                if (checkBox2.isChecked) {
                    msg += checkBox2.text.toString() + " "
                }
                if (checkBox3.isChecked) {
                    msg += checkBox3.text.toString() + " "
                }
                if (msg == "") {
                    msg = "체크된 것이 없습니다."
                }
                Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
            }
        }
    }
}