package com.example.a6_dinamiclistitemexam;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.a6_dinamiclistitemexam.adapter.ItemAdapter;
import com.example.a6_dinamiclistitemexam.model.Item;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {

    // 객체 선언
    List<Item> list;
    ItemAdapter adapter;
    EditText editText;
    Button button;
    ListView listView;

    // 일렬번호를 관리할 변수
    static int NUM = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 객체 초기화
        list = new ArrayList<>();
        adapter = new ItemAdapter(this, R.layout.list_item, list);
        editText = findViewById(R.id.editText);
        button = findViewById(R.id.button);
        listView = findViewById(R.id.listView);

        // adapter 설정
        listView.setAdapter(adapter);
        // 이벤트 설정
        button.setOnClickListener(this);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String input = editText.getText().toString().trim();
        Item item = new Item(++NUM, input);
        // adapter.add(item);             // List의 마지막 부분에 추가
        adapter.insert(item, 0);    // list의 특정 위치에 추가
        // editText 초기화
        editText.setText("");
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Item item = adapter.getItem(position);
        String result = item.getName() + " / " + item.getName();
        Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
    }
}