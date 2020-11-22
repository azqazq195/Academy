package com.example.practice5;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.practice5.model.Job;

public class ItemFragment extends Fragment implements View.OnClickListener {
    LinearLayout linearLayout;
    TextView textView1, textView2;
    ImageView imageView;
    ListFragment listFragment;
    Job item;

    public ItemFragment(ListFragment listFragment) {
        this.listFragment = listFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_item, container, false);
        linearLayout = rootView.findViewById(R.id.linearLayout);
        textView1 = rootView.findViewById(R.id.textView1);
        textView2 = rootView.findViewById(R.id.textView2);
        imageView = rootView.findViewById(R.id.imageView);

        linearLayout.setOnClickListener(this);
        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        textView1.setText(item.getTitle());
        textView2.setText(item.getDescription());
        imageView.setImageResource(item.getImage());
    }

    @Override
    public void onClick(View v) {
        // 화면 전환
        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, listFragment)
                .commit();
    }

    public void update(Job item) {
        this.item = item;
    }
}