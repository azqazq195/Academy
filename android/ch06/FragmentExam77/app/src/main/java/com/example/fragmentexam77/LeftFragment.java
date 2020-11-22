package com.example.fragmentexam77;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.fragmentexam77.adapter.JobAdapter;

public class LeftFragment extends Fragment implements AdapterView.OnItemClickListener {
    // 객체 선언
    ListView listView;
    JobAdapter adapter;
    OnListItemSelectedListener mListener; // user Listener

    // Activity가 attach 될때 즉 붙을때 동작되는 함수.
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            mListener = (OnListItemSelectedListener) context;
        } catch (ClassCastException e){
            throw new ClassCastException(context.toString()
            + " must implement OnListItemSelectedListener in MainActivity");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_left, container, false);
        listView = rootView.findViewById(R.id.listView);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        listView.setAdapter(adapter); // 화면이 뜨기 직전에 adpater 세팅함
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        mListener.onListItemSelected(position);
    }

    public void setAdapter(JobAdapter adapter) {
        this.adapter = adapter;
    }

    // user 리스너 ( Interface )
    public interface OnListItemSelectedListener {
        public void onListItemSelected(int position);
    }
}