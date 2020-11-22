package com.example.fragmentbasic4;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class Test2Fragment extends Fragment implements View.OnClickListener {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_test2, container, false);
        Button button = rootView.findViewById(R.id.button);
        button.setOnClickListener(this);
        return rootView;
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(getActivity(), "모레시계 화면입니다.", Toast.LENGTH_SHORT).show();
    }
}