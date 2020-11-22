package com.example.practice6;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class InputFragment extends Fragment implements View.OnClickListener {
    Button inputBtnInput, inputBtnBack;
    EditText editText1, editText2, editText3, editText4;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_input, container, false);
        inputBtnInput = rootView.findViewById(R.id.inputBtnInput);
        inputBtnBack = rootView.findViewById(R.id.inputBtnBack);
        editText1 = rootView.findViewById(R.id.editText1);
        editText2 = rootView.findViewById(R.id.editText2);
        editText3 = rootView.findViewById(R.id.editText3);
        editText4 = rootView.findViewById(R.id.editText4);

        inputBtnInput.setOnClickListener(this);
        inputBtnBack.setOnClickListener(this);

        return rootView;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.inputBtnInput:
                String name = editText1.getText().toString().trim();
                String email = editText2.getText().toString().trim();
                String phone = editText3.getText().toString().trim();
                String addr = editText4.getText().toString().trim();
                ((MainActivity) getActivity()).insertData(name, email, phone, addr);
                break;
            case R.id.inputBtnBack:
                getActivity().findViewById(R.id.layout_fragment).setVisibility(View.GONE);
                getActivity().findViewById(R.id.layout_main).setVisibility(View.VISIBLE);
                break;
        }
    }
}