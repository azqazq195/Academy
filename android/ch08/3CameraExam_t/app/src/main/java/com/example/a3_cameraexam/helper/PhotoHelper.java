package com.example.a3_cameraexam.helper;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.util.DisplayMetrics;
import android.util.Log;

import java.io.File;
import java.util.Calendar;

public class PhotoHelper {
    // 싱글톤 패턴 시작
        private static PhotoHelper instance;

        public static PhotoHelper getInstance() {
            if(instance == null) instance = new PhotoHelper();
            return instance;
        }
        private PhotoHelper() {}
    // 실글톤 패턴 끝

    /**
     * DCIM 폴더 하위에 새로 저장될 사진 파일의 이름을 생성한다.
     * @return 경로 문자열
     */
    public String getNewPhotoPath() {
        Calendar calendar = Calendar.getInstance();
        int yy = calendar.get(Calendar.YEAR);
        int mm = calendar.get(Calendar.MONTH) + 1;
        int dd = calendar.get(Calendar.DAY_OF_MONTH);
        int hh = calendar.get(Calendar.HOUR_OF_DAY);
        int mi = calendar.get(Calendar.MINUTE);
        int ss = calendar.get(Calendar.SECOND);

        String fileName = String.format("p%4d-%02d-%02d %02d-%02d-%02d.jpg",
                                        yy, mm, dd, hh, mi, ss);
        File dir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);
        if(!dir.exists()) { // 폴더가 없으면 폴더 생성
            dir.mkdirs();
        }
        String photoPath = dir.getAbsolutePath() + "/" + fileName;
        Log.d("[TEST]", "photoPath = " + photoPath);
        return photoPath;
    }

    /**
     * 큰 이미지를 스마트폰 크기로 줄이기
     * @param activity
     * @param path : 파일 경로
     * @return Bitmap : 파일의 이미지
     */
    public Bitmap getThumb(Activity activity, String path) {
        // 실제 이미지를 저장하는 객체
        Bitmap bmp = null;

        // 1. 스마트폰의 해상도 얻기
        // 해상도 관리 객체
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        // 스마트 폰의 가로 세로 크기 얻기
        int deviceWidth = displayMetrics.widthPixels;
        int deviceHeight = displayMetrics.heightPixels;

        // 긴축을 골라내기
        int maxScale = deviceWidth;
        if(deviceWidth < deviceHeight) maxScale = deviceHeight;

        // 2. 이미지 크기 얻어오기
        // bitmap 이미지를 읽어오는 객체
        BitmapFactory.Options options = new BitmapFactory.Options();
        // 이미지를 읽어오지 말고 사진 정보(=exif 정보)만 읽어오라는 설정
        options.inJustDecodeBounds = true;

        // 비트맴 이미지 읽어오기 -> 옵션에 의해서 사진 정보만 읽어온다.
        BitmapFactory.decodeFile(path, options);

        // 이미지의 가로, 세로 값을 읽어와서, 긴 축의 값을 저장
        int fScale = options.outHeight;
        if(options.outHeight < options.outWidth) {
            fScale = options.outWidth;
        }

        // 3. 이미지 리사이징
        if(maxScale < fScale) {  // 이미지의 길이가 스마트폰보다 크면
            // 비율 계산
            // => fScale : 2400px, maxScale : 800px => 3 : 이미지가 핸드폰보다 3배 크다.
            int sampleSize = fScale / maxScale;

            // 비트맵 옵션 설정
            BitmapFactory.Options options2 = new BitmapFactory.Options();
            // 읽어올 이미지의 비율을 설정 : 3 => 1/3 크기로 읽어옴
            options2.inSampleSize = sampleSize;
            // 이미지 읽어오기
            bmp = BitmapFactory.decodeFile(path, options2);
        } else {  // 이미지가 핸드폰 보다 작으면
            bmp = BitmapFactory.decodeFile(path);
        }
        return bmp;
    }
}






