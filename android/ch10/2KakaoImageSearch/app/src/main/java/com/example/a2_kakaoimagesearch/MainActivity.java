package com.example.a2_kakaoimagesearch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.example.a2_kakaoimagesearch.adapter.ImageAdapter;
import com.example.a2_kakaoimagesearch.model.Image;
import com.example.a2_kakaoimagesearch.response.ImageResponse;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.RequestParams;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements View.OnClickListener, AbsListView.OnScrollListener {
    List<Image> list;
    ImageAdapter adapter;
    EditText editText;
    Button button;
    ListView listView;
    AsyncHttpClient client;
    ImageResponse response;
    // 푸터
    LinearLayout layoutFooter;
    /* 페이징 처리 */
    // 한 페이지에 보여질 목록 수
    public static final int PAGE_SIZE = 20;
    // 현재 페이지
    public static int PAGE = 1;
    // 화면에 리스트의 마지마 아이템이 보여지는지 체크
    boolean lastItemVisibleFlag = false;
    // 검색어 저장
    String keyword = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = new ArrayList<>();
        adapter = new ImageAdapter(this, R.layout.list_item, list);
        editText = findViewById(R.id.editText);
        button = findViewById(R.id.button);
        listView = findViewById(R.id.listView);

        View footerView = getLayoutInflater().inflate(R.layout.list_footer, null);
        layoutFooter = footerView.findViewById(R.id.layoutFooter);

        client = new AsyncHttpClient();
        response = new ImageResponse(this, adapter, listView, layoutFooter);
        // listView 설정
        listView.addFooterView(footerView);
        listView.setAdapter(adapter);
        footerView.setVisibility(View.GONE);
        // 이벤트 설정
        button.setOnClickListener(this);
        listView.setOnScrollListener(this); // 끝에 도착했는지 검사용

    }

    @Override
    public void onClick(View v) {
        keyword = editText.getText().toString().trim();
        if(keyword.equals("")) {
            Toast.makeText(this, "검색어를 입력하세요", Toast.LENGTH_SHORT).show();
            return;
        }
        // 버튼 클릭을 통한 검색은 신규 검색이므로, 페이징 처리 변수 초기화
        PAGE = 1;
        adapter.clear();    // 리스트의 데이터 모두 삭제
        // 검색 요청
        getKakaoData(keyword);
    }

    private void getKakaoData(String keyword) {
        // 파라미터 저장 객체
        RequestParams params = new RequestParams();
        params.put("query", keyword);
        params.put("size", String.valueOf(PAGE_SIZE));
        params.put("page", String.valueOf(PAGE));
        // 헤더 파일에 api 키 추가
        client.addHeader("Authorization", "KakaoAK 02456d03e8d507835b3dd88c71790615");
        // 요청
        String url = "https://dapi.kakao.com/v2/search/image";
        client.get(url, params, response);
    }

    // 움직이다가 멈추는지
    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
        // 스코롤이 바닥에 닿아 멈춘 상태일 때의 처리
        if(scrollState == SCROLL_STATE_IDLE && lastItemVisibleFlag) {
            PAGE++;     // 페이지 1 증가 -> 다음 페이지
            getKakaoData(keyword);
        }
    }

    /**
     * 리스트뷰의 마지막 번호에 도착했는지
     * @param view : 뷰~뷰쀼~
     * @param firstVisibleItem : 현재 화면에 보이는 첫번째 리스트 아이템
     * @param visibleItemCount : 현재 화면에 보이는 리스트 아이템의 갯수
     * @param totalItemCount : 리스트뷰 항목의 전체 갯수
     */
    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        Log.d("[TEST]", firstVisibleItem + ", " + visibleItemCount + ", " + totalItemCount);
        lastItemVisibleFlag = (totalItemCount > 0) &&
                (firstVisibleItem + visibleItemCount >= totalItemCount);
    }
}