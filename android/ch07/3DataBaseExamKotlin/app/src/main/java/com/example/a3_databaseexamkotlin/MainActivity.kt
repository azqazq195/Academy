package com.example.a3_databaseexamkotlin

import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.input.*
import kotlinx.android.synthetic.main.list.*
import kotlinx.android.synthetic.main.main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    val dbName = "student.db"
    val tableName = "score"
    var database: SQLiteDatabase? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // 이벤트 설정
        button1.setOnClickListener(this)
        button2.setOnClickListener(this)
        buttonInput1.setOnClickListener(this)
        buttonBack1.setOnClickListener(this)
        buttonBack2.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        TODO("Not yet implemented")
    }
}