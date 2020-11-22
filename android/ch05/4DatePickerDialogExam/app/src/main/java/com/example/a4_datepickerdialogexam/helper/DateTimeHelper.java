package com.example.a4_datepickerdialogexam.helper;


import java.util.Calendar;

public class DateTimeHelper {
    // 싱글톤 패턴 시작
    private static DateTimeHelper instance = null;

    public static DateTimeHelper getInstance() {
        if(instance == null) instance = new DateTimeHelper();
        return instance;
    }
    private DateTimeHelper() {}
    // 싱글톤 패턴 끝

    // 현재 날짜 구하기
    public int[] getDate() {
        Calendar calendar = Calendar.getInstance();
        int yy = calendar.get(Calendar.YEAR);
        int mm = calendar.get(Calendar.MONTH) + 1;
        int dd = calendar.get(Calendar.DAY_OF_MONTH);

        return new int[]{yy, mm, dd};
    }
    // 현재 시간 구하기
    public int[] getTime() {
        Calendar calendar = Calendar.getInstance();
        int hh = calendar.get(Calendar.HOUR_OF_DAY);
        int mi = calendar.get(Calendar.MINUTE);
        int ss = calendar.get(Calendar.SECOND);

        return new int[]{hh, mi, ss};
    }
}
