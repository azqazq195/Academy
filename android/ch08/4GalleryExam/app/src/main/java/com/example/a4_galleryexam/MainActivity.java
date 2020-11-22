package com.example.a4_galleryexam;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.a4_galleryexam.helper.FileUtils;
import com.example.a4_galleryexam.helper.PhotoHelper;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView imageView;
    Button button;
    Bitmap bmp = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);
        button = findViewById(R.id.button);

        button.setOnClickListener(this);
        
        permissionCheck();
    }

    private void permissionCheck() {
        if(ActivityCompat.checkSelfPermission(this,
                Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            if(ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.READ_EXTERNAL_STORAGE)) {

            } else {
                ActivityCompat.requestPermissions(this,
                        new String[] {Manifest.permission.READ_EXTERNAL_STORAGE}, 100);
            }
        }
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent.addCategory(Intent.CATEGORY_OPENABLE);

        // image File만 필터링 => MIME 형태
        intent.setType("image/*");
        // 구글 클라우드에 싱크된 이미지 파일 제외
        intent.putExtra(Intent.EXTRA_LOCAL_ONLY, true);
        // 선택된 파일을 돌려받아야 함
        startActivityForResult(intent, 200);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 200) {
            if(resultCode == RESULT_OK) {
                // 사용자가 선택한 파일 정보
                Uri photoUri = data.getData();
                Log.d("[TEST]", "photoUri = " + photoUri);
                String filePath = FileUtils.getPath(this, photoUri);
                Log.d("[TEST]", "filePath = " + filePath);

                imageView.setImageBitmap(null);
                if(bmp != null) {
                    bmp.recycle();
                    bmp = null;
                }

                bmp = PhotoHelper.getInstance().getThumb(this, filePath);
                imageView.setImageBitmap(bmp);
            }
        }
    }
}