package com.example.a2_buttonexamkotlin

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1.setOnClickListener(this)
        button2.setOnClickListener(this)
        imgButton1.setOnClickListener(this)
        imgButton2.setOnClickListener(this)

        button1.setOnClickListener{
            Toast.makeText(this, "남자", Toast.LENGTH_LONG).show()
        }
        button2.setOnClickListener{
            Toast.makeText(this, "여자", Toast.LENGTH_LONG).show()
        }
        imgButton1.setOnClickListener{
            Toast.makeText(this, "남자", Toast.LENGTH_LONG).show()
        }
        imgButton2.setOnClickListener{
            Toast.makeText(this, "여자", Toast.LENGTH_LONG).show()
        }
    }

    override fun onClick(v: View?) {
        var id = v.id
    }
}