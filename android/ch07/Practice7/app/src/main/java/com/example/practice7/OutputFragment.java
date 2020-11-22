package com.example.practice7;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.practice7.member.MemberDAO;
import com.example.practice7.member.MemberDTO;

import java.util.List;

public class OutputFragment extends Fragment {
    TableRow row;
    TextView textViewNameIn, textViewEmainIn, textViewPhoneIn, textViewAddrIn;
    TableLayout tableLayout;
    Button listBtnBack;
    MemberDAO memberDAO;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        memberDAO = new MemberDAO(getContext());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_output, container, false);
        tableLayout = rootView.findViewById(R.id.tableLayout);
        listBtnBack = rootView.findViewById(R.id.listBtnBack);

        tableLayout.removeAllViews();
        List<MemberDTO> list = memberDAO.listData();
        for(MemberDTO member : list){
            row = (TableRow) getLayoutInflater().inflate(R.layout.table_row, null);
            textViewNameIn = row.findViewById(R.id.textViewNameIn);
            textViewEmainIn = row.findViewById(R.id.textViewEmailIn);
            textViewPhoneIn = row.findViewById(R.id.textViewPhoneIn);
            textViewAddrIn = row.findViewById(R.id.textViewAddrIn);

            textViewNameIn.setText(member.getName());
            textViewEmainIn.setText(member.getEmail());
            textViewPhoneIn.setText(member.getPhone());
            textViewAddrIn.setText(member.getAddr());

            tableLayout.addView(row);
        }

        listBtnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().findViewById(R.id.layout_fragment).setVisibility(View.GONE);
                getActivity().findViewById(R.id.layout_main).setVisibility(View.VISIBLE);
            }
        });
        return rootView;
    }

}