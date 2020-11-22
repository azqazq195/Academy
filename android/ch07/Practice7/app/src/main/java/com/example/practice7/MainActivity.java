package com.example.practice7;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.example.practice7.member.MemberDAO;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    LinearLayout layout_main, layout_fragment;
    Button mainBtnInput, mainBtnList, mainBtnModify, mainBtnDelete;
    InputFragment inputFragment;
    OutputFragment outputFragment;
    ModifyFragment modifyFragment;
    DeleteFragment deleteFragment;
    MemberDAO memberDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        memberDAO = new MemberDAO(this);

        inputFragment = new InputFragment();
        outputFragment = new OutputFragment();
        deleteFragment = new DeleteFragment();
        modifyFragment = new ModifyFragment();

        layout_main = findViewById(R.id.layout_main);
        layout_fragment = findViewById(R.id.layout_fragment);

        mainBtnInput = findViewById(R.id.mainBtnInput);
        mainBtnList = findViewById(R.id.mainBtnList);
        mainBtnModify = findViewById(R.id.mainBtnModify);
        mainBtnDelete = findViewById(R.id.mainBtnDelete);

        mainBtnInput.setOnClickListener(this);
        mainBtnList.setOnClickListener(this);
        mainBtnModify.setOnClickListener(this);
        mainBtnDelete.setOnClickListener(this);

        layout_main.setVisibility(View.VISIBLE);
        layout_fragment.setVisibility(View.GONE);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.mainBtnInput:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.layout_fragment, inputFragment)
                        .commit();
                setLayout(layout_fragment);
                break;
            case R.id.mainBtnList:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.layout_fragment, outputFragment)
                        .commit();
                setLayout(layout_fragment);
                break;
            case R.id.mainBtnModify:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.layout_fragment, modifyFragment)
                        .commit();
                setLayout(layout_fragment);
                break;
            case R.id.mainBtnDelete:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.layout_fragment, deleteFragment)
                        .commit();
                setLayout(layout_fragment);
                break;
        }
    }

    public void setLayout(LinearLayout layout) {
        layout_main.setVisibility(View.GONE);
        layout_fragment.setVisibility(View.GONE);
        layout.setVisibility(View.VISIBLE);
    }

    private void replaceFragment(String fragment){
    }
}