package com.example.practice4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.practice4.model.Member;

import java.io.Serializable;
import java.util.List;

public class OutputActivity extends AppCompatActivity {
    TableLayout tableLayout;
    Button button;
    List<Member> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_output);

        list = (List<Member>) getIntent().getSerializableExtra("list");

        tableLayout = findViewById(R.id.tableLayout);
        button = findViewById(R.id.button);

        tableLayout.removeAllViews();
        TableRow row;
        TextView textViewNameIn, textViewEmailIn, textViewPhoneIn, textViewAddrIn;

        for(Member member : list){
            row = (TableRow) getLayoutInflater().inflate(R.layout.table_row, null);
            textViewNameIn = row.findViewById(R.id.textViewNameIn);
            textViewEmailIn = row.findViewById(R.id.textViewEmailIn);
            textViewPhoneIn = row.findViewById(R.id.textViewPhoneIn);
            textViewAddrIn = row.findViewById(R.id.textViewAddrIn);

            textViewNameIn.setText(member.getName());
            textViewEmailIn.setText(member.getEmail());
            textViewPhoneIn.setText(member.getPhone());
            textViewAddrIn.setText(member.getAddr());

            // TableLayout에 추가
            tableLayout.addView(row);
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("list", (Serializable) list);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}