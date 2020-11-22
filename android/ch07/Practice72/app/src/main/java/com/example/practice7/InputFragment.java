package com.example.practice7;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.fragment.app.Fragment;

import com.example.practice7.dao.MemberDAO;
import com.example.practice7.model.MemberDTO;

public class InputFragment extends Fragment implements View.OnClickListener {
    // 객체 선언
    EditText editTextName, editTextEmail, editTextPhone, editTextAddr;
    Button buttonInput2, buttonBack2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_input, container, false);
        // 객체 초기화
        editTextName = rootView.findViewById(R.id.editTextName);
        editTextEmail = rootView.findViewById(R.id.editTextEmail);
        editTextPhone = rootView.findViewById(R.id.editTextPhone);
        editTextAddr = rootView.findViewById(R.id.editTextAddr);
        buttonInput2 = rootView.findViewById(R.id.buttonInput2);
        buttonBack2 = rootView.findViewById(R.id.buttonBack2);
        // 이벤트 설정
        buttonInput2.setOnClickListener(this);
        buttonBack2.setOnClickListener(this);

        return rootView;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonInput2:
                insertData();
                break;
            case R.id.buttonBack2:
                // 화면 전환
                getActivity().findViewById(R.id.layoutMain).setVisibility(View.VISIBLE);
                getActivity().findViewById(R.id.container).setVisibility(View.GONE);
                //((MainActivity)getActivity()).test();  // 테스형
                break;
        }
    }
    // 3. 데이터 추가하기
    private void insertData() {
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
        memberDAO.insertData(member);
    }
}







