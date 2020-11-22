package com.example.practice7;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.practice7.dao.MemberDAO;
import com.example.practice7.model.MemberDTO;

import java.util.List;

public class OutputFragment extends Fragment implements View.OnClickListener {
    // 객체 선언
    TableLayout tableLayout;
    Button buttonBack3;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_output, container, false);
        // 객체 초기화
        tableLayout = rootView.findViewById(R.id.tableLayout);
        buttonBack3 = rootView.findViewById(R.id.buttonBack3);
        // 이벤트 설정
        buttonBack3.setOnClickListener(this);

        listData();
        return rootView;
    }

    @Override
    public void onClick(View v) {
        // 화면 전환
        getActivity().findViewById(R.id.layoutMain).setVisibility(View.VISIBLE);
        getActivity().findViewById(R.id.container).setVisibility(View.GONE);
    }

    // 4. 데이터 조회하기
    private void listData() {
        // TableLayout에 있는 기존 데이터 삭제
        tableLayout.removeAllViews();
        MemberDAO memberDAO = new MemberDAO(getActivity());
        List<MemberDTO> list = memberDAO.listData();

        for(MemberDTO member : list) {
            TableRow row = (TableRow) getLayoutInflater().inflate(R.layout.table_row, null);
            TextView textViewName = row.findViewById(R.id.textViewName);
            TextView textViewEmail = row.findViewById(R.id.textViewEmail);
            TextView textViewPhone = row.findViewById(R.id.textViewPhone);
            TextView textViewAddr = row.findViewById(R.id.textViewAddr);

            textViewName.setText(member.getName());
            textViewEmail.setText(member.getEmail());
            textViewPhone.setText(member.getPhone());
            textViewAddr.setText(member.getAddr());
            // TableLayout에 추가
            tableLayout.addView(row);
        }
    }
}











