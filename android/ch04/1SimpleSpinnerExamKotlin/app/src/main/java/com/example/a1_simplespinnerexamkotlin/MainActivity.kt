package com.example.a1_simplespinnerexamkotlin

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener, AdapterView.OnItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 특정 항목을 선택하도록 설정
        spinner.setSelection(0)
        button.setOnClickListener(this)
        spinner.onItemSelectedListener = this

    }

    override fun onClick(v: View?) {
        // spinner의 선택된 위치 가져오기
        val selectedIndex = spinner.selectedItemPosition
        val data = resources.getStringArray(R.array.spinner_date)
        Toast.makeText(this, data[selectedIndex], Toast.LENGTH_SHORT).show()

    }
    /*
    spinner의 항목이 선택되었을 경우 호출된다.
    @param parent : spinner 객체
    @param view : 선택된 위치를 구성하는 view
    @param position : 선택된 위치에 대한 인덱스
    @param id : 선택된 아이디
     */
    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        val selected = parent?.selectedItem as String
        val result = position.toString() + "번째 항목 >> " + selected
        textView.text = result
    }
    
    override fun onNothingSelected(parent: AdapterView<*>?) {
        TODO("Not yet implemented")
    }
}
