package com.example.a3_cameraexam.helper;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.os.Environment;
import android.util.DisplayMetrics;
import android.util.Log;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;

public class PhotoHelper {
    //싱글톤 패턴 시작
    private static PhotoHelper instance;

    public static PhotoHelper getInstance() {
        if (instance == null) instance = new PhotoHelper();
        return instance;
    }

    private PhotoHelper() {
    }

    //싱글톤 패턴끝
    //DCIM 폴더 하위에 새로 저장될 사진 파일의 이름을 생성한다
    //@리턴 경로 문자열
    public String getNewPhotoPath() {
        Calendar calendar = Calendar.getInstance();
        int yy = calendar.get(Calendar.YEAR);
        int mm = calendar.get(Calendar.MONTH) + 1;
        int dd = calendar.get(Calendar.DAY_OF_MONTH);
        int hh = calendar.get(Calendar.HOUR_OF_DAY);
        int mi = calendar.get(Calendar.MINUTE);
        int ss = calendar.get(Calendar.SECOND);

        String fileName = String.format("p%4d-%02d-%02d %02d-%02d-%02d.jpg", yy, mm, dd, hh, mi, ss);
        File dir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);
        if (!dir.exists()) {//폴더가 없으면 폴더 생성
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

    public Bitmap getThumb(Activity activity, String path){
        // 실제 이미지를 저장하는 객체
        Bitmap bitmap = null;
        // 1. 스마트폰의 해상도 얻기 ( activity로 인해 얻어옴)
        // 해상도 관리 객체
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        // 스마트폰의 가로세로 크기 얻기
        int deviceWidth = displayMetrics.widthPixels;
        int deviceHeight = displayMetrics.heightPixels;
        // 긴 축을 골라내기
        int maxScale = deviceWidth;
        if (deviceWidth<deviceHeight)maxScale = deviceHeight;

        // 2. 이미지 크기 얻어오기
        // bitmap 이미지를 읽어오는 객체
        BitmapFactory.Options options = new BitmapFactory.Options();
        // 이미지를 읽어오지 말고 사진 정보(exif 정보)만 읽어오라는 설정
        options.inJustDecodeBounds = true;

        // 비트맵 이미지 읽어오기기
        BitmapFactory.decodeFile(path, options);

        // 이미지의 가로, 세로 값을 읽어와서 긴 축의 갑을 저장
        int fScale = options.outHeight;
        if (options.outHeight < options.outWidth){
            fScale = options.outWidth;
        }

        // 3. 이미지 리사이징
        if (maxScale < fScale){ // 이미지의 길이가 스마트폰의 화면보다 크면
            // 비율 계산
            // => fScale : 2400px , maxScale : 800px => 이미지가 핸드폰보다 3배 크다.
            int sampleSize = fScale/maxScale;

            // 비트맵 옵션 설정
            BitmapFactory.Options options2 = new BitmapFactory.Options();
            // 읽어올 이미지의 비율을 설정 : 3 => 1/3 크기로 읽어옴
            options2.inSampleSize = sampleSize;
            // 이미지 읽어오기
            bitmap = BitmapFactory.decodeFile(path,options2);
        } else {
            bitmap = BitmapFactory.decodeFile(path);
        }

        // 돌아간 사진 바로 세우기
        // => exif 정보에 orientation 값이 90, 180, 270으로 되있을 경우, 보정하기
        try {
            ExifInterface exif = new ExifInterface(path);
            int exifOrientation = exif.getAttributeInt(ExifInterface.TAG_ORIENTATION,
                    ExifInterface.ORIENTATION_NORMAL);
            // 상수값을 실제 각도로 전환
            int exifDegree = 0;
            if(exifOrientation == ExifInterface.ORIENTATION_ROTATE_90) {
                exifDegree = 90;
            } else if(exifOrientation == ExifInterface.ORIENTATION_ROTATE_180) {
                exifDegree = 180;
            } else if(exifOrientation == ExifInterface.ORIENTATION_ROTATE_270) {
                exifDegree = 270;
            }
            bitmap = rotate(bitmap, exifDegree);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bitmap;
    }
    // 각도 만큼 이미지를 돌리기
    private Bitmap rotate(Bitmap bitmap, int exifDegree) {
        if (exifDegree != 0 && bitmap != null) {
            // 이미지의 어느 위치 기준으로 몇도 회전할 지 설정
            Matrix m = new Matrix();
            m.setRotate(exifDegree, (float)bitmap.getWidth() / 2,
                    (float)bitmap.getHeight() / 2);

            Bitmap converted = Bitmap.createBitmap(bitmap, 0, 0,
                    bitmap.getWidth(), bitmap.getHeight(), m, true);

            bitmap.recycle();
            bitmap = converted;
        }
        return bitmap;
    }

}

