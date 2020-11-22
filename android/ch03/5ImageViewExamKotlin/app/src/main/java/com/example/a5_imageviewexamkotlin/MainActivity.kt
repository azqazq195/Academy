package com.example.a5_imageviewexamkotlin

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1.setOnClickListener(this)
        button2.setOnClickListener(this)
        button3.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.button1 -> {
                imageView.setImageResource(R.drawable.img1)
                imageView.scaleType = ImageView.ScaleType.CENTER_CROP
            }
            R.id.button2 -> {
                imageView.setImageResource(R.drawable.img2)
                imageView.scaleType = ImageView.ScaleType.CENTER_INSIDE
            }
        }
    }
}