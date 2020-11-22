package com.example.fragmentexam5;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.ListFragment;

public class SampleListFragment extends ListFragment {
    private int index = 0;
    private OnListItemSelectedListener mListener; // inner Interface

    // Fragment를 포함하는 Activity가 만들어질 때, 호출되는 메소드
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // ListView를 위한 어댑터 객체를 생성하여 설정
        // ArrayAdapter.createFromResource(android.content.Context context, : Activity의 부모클래스가 context
        //                                 @ArrayRes int textArrayResId,    : 배열의 id값
        //                                 @LayoutRes int textViewResId     : 사용할 TextView id < 안드로이드가 기본적으로 설정
        setListAdapter(ArrayAdapter.createFromResource(getActivity(),
                R.array.image_titles, android.R.layout.simple_list_item_1));
        // 선택된 아이템 인덱스 값을 읽어와서 리스트의 메소드 호출
        if(savedInstanceState != null) {
            index = savedInstanceState.getInt("index", 0);
            mListener.onListItemSelected(index);
        }
    }
    // 선택된 아이템 인덱스 값을 저장
    // 메모리 부족으로 인한 강제 종료, or 가로/세로 화면 전환시 호출된다.
    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("index", index);
    }
    // 프레그먼트가 액티비티와 연결할 때 호출된다.
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            mListener = (OnListItemSelectedListener) context;
        } catch (ClassCastException e) {
            throw  new ClassCastException(context.toString() + " must implement OnListItemSelectedListener in Activity");
        }
    }
    // ListFragment에서 보여주는 리스트의 한 아이템을 선택했을 때의 이벤트 처리
    @Override
    public void onListItemClick(@NonNull ListView l, @NonNull View v, int position, long id) {
        index = position;
        mListener.onListItemSelected(position);
    }
    // 리스너 인터페이스 정의 : 사용자 정의 리스너
    // => Activity에서 동작시킬 이벤트 Listener 정의
    public interface OnListItemSelectedListener {
        public void onListItemSelected(int index);
    }
}