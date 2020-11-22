package com.example.a1_simpledialogexam;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button button1, button2, button3, button4, button5;
    // 알림창에 표시될 문자열 배열
    String [] items = {"선택항목1", "선택항목2", "선택항목3"};
    // Single Choice 선택상태를 관리할 변수
    int checkedItem = 0;
    // mulit choice 선택상태를 관리할 배열
    boolean[] checkedItems = {false, false, false};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button1 :
                showAlertDialog();
                break;
            case R.id.button2 :
                showConfirmDialog();
                break;
            case R.id.button3 :
                showListDialog();
                break;
            case R.id.button4 :
                showSingleChoiceDialog();
                break;
            case R.id.button5 :
                showMulitChoiceDialog();
                break;
        }
    }

    private void showSingleChoiceDialog() {
        // 이전 선택값을 임시로 백업 : cancel되었을 때 원복시키기 위해서
        final int temp = checkedItem;

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("확인");
        builder.setIcon(R.mipmap.ic_launcher);
        // builder.setMessage(); 사용 X
        builder.setCancelable(false);

        // 라디오 버튼 추가
        // setSingleChoiceItems(문자열, 위치값, 이벤트 설정)
        builder.setSingleChoiceItems(items, checkedItem, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // 위치값 저장
                checkedItem = which;

            }
        });
        // 긍정 버튼 추가
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), items[checkedItem], Toast.LENGTH_SHORT).show();
            }
        });
        // 부정 버튼 추가
        builder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // 백업한 값을 원복시킴
                checkedItem = temp;
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    private void showMulitChoiceDialog() {
        // 이전 선택값을 임시로 백업
        final boolean[] temp = new boolean[checkedItems.length];
        System.arraycopy(checkedItems, 0, temp, 0, checkedItems.length);
//        for(int i=0; i<checkedItems.length; i++){
//            temp[i] = checkedItems[i];
//        }

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("확인");
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setCancelable(false);

        // 체크박스를 포함한 목록 등록과 이벤트 처리
        // setMulitChoiceItems(문자열 배열, 체크박스 상태 배열, 이벤트 처리)
        builder.setMultiChoiceItems(items, checkedItems, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                checkedItems[which] = isChecked;
            }
        });
        // 긍정버튼 추가
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // 선택 결과를 저장할 변수
                StringBuilder result = new StringBuilder();
                for(int i=0; i<checkedItems.length; i++) {
                    if(checkedItems[i]) {
                        result.append(items[i]).append("\n");
                    }
                }
                Toast.makeText(getApplicationContext(), result.toString(), Toast.LENGTH_SHORT).show();
            }
        });
        // 부정버튼 추가
        builder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // 백업한 값을 원복시킴
                System.arraycopy(temp, 0, checkedItems, 0, temp.length);
            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    // 기본 알림창 (AlertDialog.Builder - 다이얼로그 만드는 클래스)
    private void showAlertDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        // 아래 5가지 중 필요한 것을 선택해서 추가시킬 수 있음!!
        // 1.제목 설정
        builder.setTitle("알림");
        // 2.내용 설정
        builder.setMessage("알림 대화상자입니다.");
        // 3.아이콘 설정
        builder.setIcon(R.mipmap.ic_launcher);
        // 4.하드웨어 back key가 눌렸을 때 창이 닫히지 않도록 설정
        // 일반적으로는 ◀ backkey 누르면 뒤로 가버리는데 반드시 알려야하는 내용이 있으면, "버튼"을 눌러서 확인하도록 설정.
        // 반드시 버튼을 추가해야한다. 버튼이 없으면 앱을 강제 종료시키는 방법 밖에 없음!
        builder.setCancelable(false);
        // 5.버튼 추가 (이벤트를 함께 추가)
        builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "확인을 눌렀습니다.", Toast.LENGTH_SHORT).show();
            }
        });
        // 설정한 정보로 알림창 생성 (builder.create(); 해야 alert 창 객체 생성)
        AlertDialog alertDialog = builder.create();
        // 알림창 표시
        alertDialog.show();
    }

    // 확인 알림창
    private void showConfirmDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        // 아래 5가지 중 필요한 것을 선택해서 추가시킬 수 있음!!
        // 1.제목 설정
        builder.setTitle("확인");
        // 2.내용 설정
        builder.setMessage("확인 대화상자입니다.");
        // 3.아이콘 설정
        builder.setIcon(android.R.drawable.btn_star_big_on);
        // 4.하드웨어 back key가 눌렸을 때 창이 닫히지 않도록 설정
        // 일반적으로는 ◀ backkey 누르면 뒤로 가버리는데 반드시 알려야하는 내용이 있으면, "버튼"을 눌러서 확인하도록 설정.
        // 반드시 버튼을 추가해야한다. 버튼이 없으면 앱을 강제 종료시키는 방법 밖에 없음!
        builder.setCancelable(false);
        // 5-1.긍정의 버튼 추가 (이벤트를 함께 추가)
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "확인을 눌렀습니다.", Toast.LENGTH_SHORT).show();
            }
        });
        // 5-2.부정의 버튼 추가 (이벤트를 함께 추가)
        builder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "CANCEL을 눌렀습니다.", Toast.LENGTH_SHORT).show();
            }
        });

        // 설정한 정보로 알림창 생성 (builder.create(); 해야 alert 창 객체 생성)
        builder.setNeutralButton("취소", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "취소를 눌렀습니다.",
                        Toast.LENGTH_SHORT).show();
            }
        });
        AlertDialog alertDialog = builder.create();
        // 알림창 표시
        alertDialog.show();
    }

    // 목록 선택창
    private void showListDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("확인");
        // 메세지 입력시 메세지가 자리를 차지하고 리스가 들어가 자리를 안준다.
        // builder.setMessage("List Dialog");
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setCancelable(false);
        // 문자열 배열
        final String[] items = {"축구", "농구", "배구"};
        // 목록 추가 : 긍정의 버튼 역할

        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), items[which],
                        Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "CANCEL을 눌렀습니다.", Toast.LENGTH_SHORT).show();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

}