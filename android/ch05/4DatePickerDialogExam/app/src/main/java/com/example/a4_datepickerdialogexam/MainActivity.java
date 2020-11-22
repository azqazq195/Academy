package com.example.a4_datepickerdialogexam;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;

import com.example.a4_datepickerdialogexam.helper.DateTimeHelper;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button button1, button2;
    // 상태유지를 위한 전역변수
    int YEAR = 0, MONTH = 0, DAY = 0, HOUR = 0, MINUTE = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        // 시간 초기화
        int[] date = DateTimeHelper.getInstance().getDate();
        YEAR = date[0];
        MONTH = date[1];
        DAY = date[2];

        int[] time = DateTimeHelper.getInstance().getTime();
        HOUR = time[0];
        MINUTE = time[1];
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button1:
                showDatePickerDialog();
                break;
            case R.id.button2:
                showTimePickerDialog();
                break;

        }
    }

    // 날짜 선택창
    private void showDatePickerDialog() {
        // 원복처리에 사용될 임시 값
        final int temp_yy = YEAR;
        final int temp_mm = MONTH;
        final int temp_dd = DAY;

        // DatePickerDialog(액티비티, 이벤트 처리, 년, 월, 일)
        DatePickerDialog dialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                YEAR = year;
                MONTH = month + 1;
                DAY = dayOfMonth;
                button1.setText(YEAR + "년 " + MONTH + "월 " + DAY + "일");
            }
        }, YEAR, MONTH - 1, DAY);

        // 취소 버튼 또는 back key를 눌렀을 때, 이벤트 처리
        dialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialog) {
                // 백업된 값을 원복시킴
                YEAR = temp_yy;
                MONTH = temp_mm;
                DAY = temp_dd;
            }
        });

        // 안드로이드 버전에 따라서 보이기도 하고, 안보이기도 한다.
        dialog.setTitle("날짜 선택");
        dialog.setMessage("생일을 선택하세요");
        dialog.setIcon(R.mipmap.ic_launcher);
        dialog.show();
    }

    // 시간 선택창
    private void showTimePickerDialog() {
        // 시간 백업
        final int temp_hh = HOUR;
        final int temp_mi = MINUTE;

        // TimePickerDialog(액티비티, 이벤트 처리, 시, 분, 24시간제 표시 설정)
        TimePickerDialog dialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                HOUR = hourOfDay;
                MINUTE = minute;
                button2.setText(HOUR + "시 " + MINUTE + "분");
            }
        }, HOUR, MINUTE, false);

        dialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialog) {
                // 시간 원복
                HOUR = temp_hh;
                MINUTE = temp_mi;
            }
        });

        dialog.setTitle("시간 선택");
        dialog.setIcon(R.mipmap.ic_launcher);
        dialog.setMessage("약속시간을 선택하세요.");

        dialog.show();
    }
}