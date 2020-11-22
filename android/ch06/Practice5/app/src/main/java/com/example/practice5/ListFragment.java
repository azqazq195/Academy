package com.example.practice5;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.practice5.adapter.JobAdapter;
import com.example.practice5.model.Job;

import java.util.List;

public class ListFragment extends Fragment implements AdapterView.OnItemClickListener {
    ListView listView;
    List<Job> list;
    JobAdapter adapter;
    OnListItemSelectedListener mListener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Log.d("[TEST]", "onAttach 호출");
        try {
            mListener = (OnListItemSelectedListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " must implement OnListItemSelectedListener in MainActivity");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d("[TEST]", "onCreateView 호출");
        View rootView = inflater.inflate(R.layout.fragment_list, container, false);
        listView = rootView.findViewById(R.id.listView);
        listView.setOnItemClickListener(this);

        return rootView;
    }

    @Override
    public void onResume() {
        Log.d("[TEST]", "onResume 호출");
        super.onResume();
        listView.setAdapter(adapter);
    }

    public JobAdapter getAdapter() {
        return adapter;
    }

    public void setAdapter(JobAdapter adapter) {
        Log.d("[TEST]", "setAdapter 호출");
        this.adapter = adapter;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        mListener.onListItemSelected(position);
    }

    public interface OnListItemSelectedListener {
        public void onListItemSelected(int position);
    }
}