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
import android.widget.TextView;
import android.widget.Toast;

import com.example.practice7.dao.MemberDAO;
import com.example.practice7.model.MemberDTO;

public class DeleteFragment extends Fragment implements View.OnClickListener {
    TextView textViewMember;
    Button buttonDelete, buttonBack;
    // 삭제할 이름 저장
    String deleteName = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_delete, container, false);
        // 객체 초기화
        textViewMember = rootView.findViewById(R.id.textViewMember);
        buttonDelete = rootView.findViewById(R.id.buttonDelete);
        buttonBack = rootView.findViewById(R.id.buttonBack);
        // 이벤트 설정
        buttonDelete.setOnClickListener(this);
        buttonBack.setOnClickListener(this);
        return rootView;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonDelete:
                if(deleteName != null) {
                    MemberDAO memberDAO = new MemberDAO(getActivity());
                    memberDAO.deleteData(deleteName);
                    // 화면 초기화
                    textViewMember.setText("회원 정보");
                } else {
                    Toast.makeText(getActivity(), "삭제할 수 없습니다.",
                            Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.buttonBack:
                // deleteName 초기화
                deleteName = null;

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
        showDeleteNameDialog();
    }

    private void showDeleteNameDialog() {
        final View deleteView = getActivity().getLayoutInflater()
                .inflate(R.layout.dialog_delete, null);

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("삭제 이름 입력");
        builder.setIcon(android.R.drawable.btn_star_big_on);
        builder.setView(deleteView);
        builder.setCancelable(false);

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                EditText editText = deleteView.findViewById(R.id.editText);
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
                    String result = "이름 : " + memberDTO.getName() + "\n"
                                  + "이메일 : " + memberDTO.getEmail() + "\n"
                                  + "전화번호 : " + memberDTO.getPhone() + "\n"
                                  + "주소 : " + memberDTO.getAddr();
                    textViewMember.setText(result);
                    // 전역변수에 이름 저장
                    deleteName = memberDTO.getName();
                } else {
                    // 전역변수 이름 초기화
                    deleteName = null;
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