package com.example.practice1kotlin

import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.practice1kotlin.helper.ObjectInOut
import com.example.practice1kotlin.model.Member
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private var filename: String = filesDir.absolutePath + "/member.txt"
    private var list: MutableList<Member>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        list = mutableListOf<Member>()

        btnInput.setOnClickListener(this)
        btnList.setOnClickListener(this)
        btnSave.setOnClickListener(this)
        btnRead.setOnClickListener(this)
        btnOk.setOnClickListener(this)
        btnBack.setOnClickListener(this)
        btnBack2.setOnClickListener(this)

        visibleLayout(main_layout)
        }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btnInput -> visibleLayout(input_layout)
            R.id.btnList -> {
                visibleLayout(output_layout)
                listView()
            }
            R.id.btnSave -> save()
            R.id.btnRead -> read()
            R.id.btnOk -> input()
            R.id.btnBack, R.id.btnBack2 -> visibleLayout(main_layout)
        }
    }

    private fun visibleLayout(layout: LinearLayout){
        main_layout.visibility = View.GONE
        input_layout.visibility = View.GONE
        output_layout.visibility = View.GONE
        layout.visibility = View.VISIBLE
    }

    private fun listView() {
        val result = StringBuilder()
        list?.forEach { member ->
            result.append(member.getName())
                    .append(", ")
                    .append(member.getEmail())
                    .append(", ")
                    .append(member.getPhone())
                    .append(", ")
                    .append(member.getAddr())
                    .append("\n")
        }
        textViewResult.text = result.toString()
    }

    private fun input() {
        var name = editTextName.text.toString().trim()
        var email = editTextEmail.text.toString().trim()
        var phone = editTextPhone.text.toString().trim()
        var addr = editTextAddr.text.toString().trim()
        list?.add(Member(name, email, phone, addr))

        editTextName.text = null
        editTextEmail.text = null
        editTextPhone.text = null
        editTextAddr.text = null
    }

    private fun save() {
        val resultSave: Boolean = ObjectInOut.getInstance().write(filename, list)
        val msg = if (resultSave) "저장 성공" else "저장 실패"
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

    private fun read() {
        list!!.clear() // 모든 데이터 지우기
        list = ObjectInOut.getInstance().read(filename)
        Toast.makeText(this, "파일 불러오기", Toast.LENGTH_SHORT).show()
    }

}




