package com.example.practice6;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TableLayout;

public class OutputFragment extends Fragment {
    TableLayout tableLayout;
    Button listBtnBack;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_output, container, false);
        tableLayout = rootView.findViewById(R.id.tableLayout);
        listBtnBack = rootView.findViewById(R.id.listBtnBack);

        listBtnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().findViewById(R.id.layout_fragment).setVisibility(View.GONE);
                getActivity().findViewById(R.id.layout_main).setVisibility(View.VISIBLE);
            }
        });
        return rootView;
    }

    @Override
    public void onResume() {
        ((MainActivity) getActivity()).listData();
        super.onResume();
    }
}