package com.example.practice7;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.practice7.member.MemberDAO;
import com.example.practice7.member.MemberDTO;

public class ModifyFragment extends Fragment implements View.OnClickListener {

    EditText editText1, editText2, editText3, editText4;
    Button modifyBtnModify, modifyBtnBack;
    MemberDAO memberDAO;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        memberDAO = new MemberDAO(getContext());
        modifyDialog();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_modify, container, false);
        modifyBtnModify = rootView.findViewById(R.id.modifyBtnModify);
        modifyBtnBack = rootView.findViewById(R.id.modifyBtnBack);
        editText1 = rootView.findViewById(R.id.editText1);
        editText2 = rootView.findViewById(R.id.editText2);
        editText3 = rootView.findViewById(R.id.editText3);
        editText4 = rootView.findViewById(R.id.editText4);

        modifyBtnModify.setOnClickListener(this);
        modifyBtnBack.setOnClickListener(this);

        return rootView;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.modifyBtnModify:
                modify();
                break;
            case R.id.modifyBtnBack:
                getActivity().findViewById(R.id.layout_fragment).setVisibility(View.GONE);
                getActivity().findViewById(R.id.layout_main).setVisibility(View.VISIBLE);
                break;
        }
    }

    private void modify() {
        String name = editText1.getText().toString().trim();
        String email = editText2.getText().toString().trim();
        String phone = editText3.getText().toString().trim();
        String addr = editText4.getText().toString().trim();
        MemberDTO member = new MemberDTO(name, email, phone, addr);
        memberDAO.modifyData(member);
    }

    private void modifyDialog() {
        final View modifyView = getLayoutInflater().inflate(R.layout.layout_dialog, null);
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("수정");
        builder.setIcon(android.R.drawable.btn_star);
        builder.setView(modifyView);
        builder.setCancelable(false);

        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                EditText editText = modifyView.findViewById(R.id.editText);
                String name = editText.getText().toString().trim();
                
                if(name.equals("")){
                    Toast.makeText(getContext(), "이름을 입력해 주세요", Toast.LENGTH_SHORT).show();
                    goMain();
                    return;
                }

                MemberDTO member = memberDAO.getData(name);
                if(member == null){
                    goMain();
                } else {
                    editText1.setText(member.getName());
                    editText2.setText(member.getEmail());
                    editText3.setText(member.getPhone());
                    editText4.setText(member.getAddr());
                }
            }
        });

        builder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                goMain();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    private void goMain(){
        getActivity().findViewById(R.id.layout_fragment).setVisibility(View.GONE);
        getActivity().findViewById(R.id.layout_main).setVisibility(View.VISIBLE);
        getActivity().getSupportFragmentManager().beginTransaction()
                .remove(this).commit();
    }
}