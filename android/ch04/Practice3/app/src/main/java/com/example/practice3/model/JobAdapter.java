package com.example.practice3.model;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.practice3.R;

import java.util.List;

public class JobAdapter extends ArrayAdapter<Job> {
    Activity activity;
    int resource;

    // JobAdapter adapter = new JobAdapter(this, R.layout.list_item, list);
    public JobAdapter(@NonNull Context context, int resource, @NonNull List objects) {
        super(context, resource, objects);
        activity = (Activity) context;
        this.resource = resource;
    }

    /**
     * ListView에 의해서 호출되는 메소드
     * => 1줄 화면 만들기 메소드
     * => List안에서 한 줄에 대한 JavaBeans를 추출하여, 한 줄 레이아웃에 맵핑한 후,
     *    ListView에게 리턴해 준다.
     * @param position : 리스트의 몇번째 항목인 지를 의미하는 인덱스 값
     * @param convertView : 앞서 전달받았던 레이아웃 객체, 최초 호출시에는 null이지만,
     *                    이후 호출될 때마다 이전에 리턴 받았던 view를 이 파라미터를 통해
     *                    되돌려 준다.
     * @param parent : ListView 객체가 전달됨 (사용안함)
     * @return View : 한 줄의 모양을 정의한 레이아웃에 JavaBeans의 데이터를 맵핑하여 리턴
     */
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // 1. 1줄 화면 객체 생성 : list_item.xml 파일에 설정된대로 객체 생성
        Log.i("[Test]","position " + position + ", convertView " + convertView);
        if(convertView == null){
            convertView = activity.getLayoutInflater().inflate(resource, null);
        }
        // 2. 전달받은 위치 값으로 List에서 데이터를 하나 꺼낸다.
        Job item = getItem(position);

        // 3. 데이터가 존재하면, convertView객체에 포함된 컴포넌트들에게 데이터를 출력한다.
        // => convertView = 컴포넌트 클래스 + 1줄 데이터
        if(item != null) {
            ImageView imageView = convertView.findViewById(R.id.imageView);
            TextView textView1 = convertView.findViewById(R.id.textView1);
            TextView textView2 = convertView.findViewById(R.id.textView2);
            // 컴포넌트들에게 데이터를 설정
            imageView.setImageResource(item.getImage());
            textView1.setText(item.getTitle());
            textView2.setText(item.getDescription());
        }

        // 4. 1줄 화면 리턴
        return convertView;
    }
}