package com.example.fragmentbasic3;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class Test1Fragment extends Fragment implements View.OnClickListener {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_test1, container, false);
        Button button = rootView.findViewById(R.id.button);
        button.setOnClickListener(this);
        return rootView;
    }

    @Override
    public void onClick(View v) {
        // 화면 전환
        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, new Test2Fragment())
                .commit();
    }
}