package com.example.fragmentexam7;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fragmentexam7.model.Job;

import java.util.List;

public class RightFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_right, container, false);
    }

    public void update(int index) {
        TextView textView1 = getView().findViewById(R.id.textView1);
        TextView textView2 = getView().findViewById(R.id.textView2);
        ImageView imageView = getView().findViewById(R.id.imageView);

        textView1.setText(((MainActivity)getActivity()).list.get(index).getTitle());
        textView2.setText(((MainActivity)getActivity()).list.get(index).getDescription());
        imageView.setImageResource(((MainActivity)getActivity()).list.get(index).getImage());
    }
}