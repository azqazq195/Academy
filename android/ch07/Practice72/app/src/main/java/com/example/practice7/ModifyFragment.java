package com.example.practice7;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.practice7.dao.MemberDAO;
import com.example.practice7.model.MemberDTO;

public class ModifyFragment extends Fragment implements View.OnClickListener {
    // 객체 선언
    EditText editTextName, editTextEmail, editTextPhone, editTextAddr;
    Button buttonModify, buttonBack;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_modify, container, false);
        // 객체 초기화
        editTextName = rootView.findViewById(R.id.editTextName);
        editTextEmail = rootView.findViewById(R.id.editTextEmail);
        editTextPhone = rootView.findViewById(R.id.editTextPhone);
        editTextAddr = rootView.findViewById(R.id.editTextAddr);
        buttonModify = rootView.findViewById(R.id.buttonModify);
        buttonBack = rootView.findViewById(R.id.buttonBack);
        // 이벤트 설정
        buttonModify.setOnClickListener(this);
        buttonBack.setOnClickListener(this);
        return rootView;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonModify:
                String name = editTextName.getText().toString().trim();
                String email = editTextEmail.getText().toString().trim();
                String phone = editTextPhone.getText().toString().trim();
                String addr = editTextAddr.getText().toString().trim();

                if(name.equals("") || email.equals("") || phone.equals("") || addr.equals("")) {
                    Toast.makeText(getActivity(), "모두 입력하세요", Toast.LENGTH_SHORT).show();
                    return;
                }
                MemberDTO member = new MemberDTO(name, email, phone, addr);
                MemberDAO memberDAO = new MemberDAO(getActivity());
                memberDAO.modifyData(member);
                break;
            case R.id.buttonBack:
                // 화면 초기화
                editTextName.setText("");
                editTextEmail.setText("");
                editTextPhone.setText("");
                editTextAddr.setText("");
                // 화면 전환
                getActivity().findViewById(R.id.layoutMain).setVisibility(View.VISIBLE);
                getActivity().findViewById(R.id.container).setVisibility(View.GONE);
                // activity에서 fragment 제거
                getActivity().getSupportFragmentManager().beginTransaction()
                        .remove(this).commit();
                break;
        }
    }

    // 화면 뜨기 직전에 자동 호출
    @Override
    public void onResume() {
        super.onResume();
        showModifyNameDialog();
    }

    private void showModifyNameDialog() {
        final View modifyView = getActivity().getLayoutInflater()
                            .inflate(R.layout.dialog_modify, null);

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("수정 이름 입력");
        builder.setIcon(android.R.drawable.btn_star_big_on);
        builder.setView(modifyView);
        builder.setCancelable(false);

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                EditText editText = modifyView.findViewById(R.id.editText);
                String name = editText.getText().toString().trim();
                // 입력 검사
                if(name.equals("")) {
                    Toast.makeText(getActivity(), "이름을 입력하세요",
                            Toast.LENGTH_SHORT).show();
                    return; // 강제 종료
                }
                // 이름으로 데이터 확인
                MemberDAO memberDAO = new MemberDAO(getActivity());
                MemberDTO memberDTO = memberDAO.getData(name);
                if(memberDTO != null) {
                    editTextName.setText(memberDTO.getName());
                    editTextEmail.setText(memberDTO.getEmail());
                    editTextPhone.setText(memberDTO.getPhone());
                    editTextAddr.setText(memberDTO.getAddr());
                } else {
                    Toast.makeText(getActivity(), name + "님이 없습니다.",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

        builder.setNegativeButton("CANCEL", null);
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}







