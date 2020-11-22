package com.example.a4_listitemcheckexamkotlin.adapter

import android.app.Activity
import android.content.Context
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import com.example.a4_listitemcheckexamkotlin.R
import com.example.a4_listitemcheckexamkotlin.model.Flower

class FlowerAdapter(
    context: Context,
    resource: Int,
    objects: List<*>
) :
    ArrayAdapter<Flower?>(context, resource, objects) {
    var activity: Activity
    var resource: Int
    override fun getView(
        position: Int,
        convertView: View?,
        parent: ViewGroup
    ): View {
        // 1. 1줄 화면 객체 생성 : list_item.xml 파일에 설정된대로 객체 생성
        var convertView = convertView
        Log.i("[Test]", "position $position, convertView $convertView")
        if (convertView == null) {
            convertView = activity.layoutInflater.inflate(resource, null)
        }
        // 2. 전달받은 위치 값으로 List에서 데이터를 하나 꺼낸다.
        val item: Flower? = getItem(position)

        // 3. 데이터가 존재하면, convertView객체에 포함된 컴포넌트들에게 데이터를 출력한다.
        // => convertView = 컴포넌트 클래스 + 1줄 데이터
        if (item != null) {
            val imageView =
                convertView!!.findViewById<ImageView>(R.id.imageView)
            val textView1 = convertView.findViewById<TextView>(R.id.textView1)
            val textView2 = convertView.findViewById<TextView>(R.id.textView2)
            val checkBox = convertView.findViewById<CheckBox>(R.id.checkBox)
            // 컴포넌트들에게 데이터를 설정
            imageView.setImageResource(item.get)
            textView1.setText(item.getTitle())
            textView2.setText(item.getDescription())
            checkBox.isChecked = item.isCheck()
        }

        // 4. 1줄 화면 리턴
        return convertView!!
    }

    init {
        activity = context as Activity
        this.resource = resource
    }
}
