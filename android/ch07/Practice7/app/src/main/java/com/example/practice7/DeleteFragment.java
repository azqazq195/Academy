package com.example.practice7;

import android.app.AlertDialog;
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
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.practice7.member.MemberDAO;
import com.example.practice7.member.MemberDTO;

import java.util.List;

public class DeleteFragment extends Fragment implements View.OnClickListener {

    TableRow row;
    TextView textViewNameIn, textViewEmainIn, textViewPhoneIn, textViewAddrIn;
    TableLayout tableLayout;
    Button deleteBtnDelete, deleteBtnBack;
    MemberDAO memberDAO;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        memberDAO = new MemberDAO(getContext());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_delete, container, false);
        tableLayout = rootView.findViewById(R.id.tableLayout);
        deleteBtnDelete = rootView.findViewById(R.id.deleteBtnDelete);
        deleteBtnBack = rootView.findViewById(R.id.deleteBtnBack);

        deleteBtnDelete.setOnClickListener(this);
        deleteBtnBack.setOnClickListener(this);

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
        return rootView;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.deleteBtnDelete:
                deleteDialog();
                break;
            case R.id.deleteBtnBack:
                getActivity().findViewById(R.id.layout_fragment).setVisibility(View.GONE);
                getActivity().findViewById(R.id.layout_main).setVisibility(View.VISIBLE);
                break;
        }
    }

    private void deleteDialog() {
        final View deleteView = getLayoutInflater().inflate(R.layout.layout_dialog, null);
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("삭제");
        builder.setIcon(android.R.drawable.btn_star);
        builder.setView(deleteView);
        builder.setCancelable(false);

        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                EditText editText = deleteView.findViewById(R.id.editText);
                String name = editText.getText().toString().trim();

                if(name.equals("")){
                    Toast.makeText(getContext(), "이름을 입력해 주세요", Toast.LENGTH_SHORT).show();
                    return;
                }
                memberDAO.deleteData(name);
                refresh();
            }
        });

        builder.setNegativeButton("CANCEL", null);
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    private void refresh() {
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.detach(this).attach(this).commit();
    }
}