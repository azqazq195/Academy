package com.example.imageboard;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.FileProvider;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.imageboard.helper.FileUtils;
import com.example.imageboard.helper.PhotoHelper;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;

import cz.msebera.android.httpclient.Header;

public class WriteActivity extends AppCompatActivity implements View.OnClickListener {
    // 객체 선언
    EditText editText1, editText2, editText3, editText4, editText5;
    Button button1, button2, button3;
    AsyncHttpClient client;
    HttpResponse response;
    String url = "http://192.168.0.96:8080/imageboard/community/community_insert.do";
    //String url = "http://192.168.0.96:8080/imageboard/community/community_insert.jsp";
    // 업로드할 사진파일의 경로
    String filePath = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write);
        // 객체 초기화
        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);
        editText3 = findViewById(R.id.editText3);
        editText4 = findViewById(R.id.editText4);
        editText5 = findViewById(R.id.editText5);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        client = new AsyncHttpClient();
        response = new HttpResponse();
        // 이벤트 설정
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        // 퍼미션 체크
        permissionCheck();
    }

    private void permissionCheck() {
        if(ActivityCompat.checkSelfPermission(this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            if(ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
            } else {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 100);
            }
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button1:  // 사진 등록
                showListDialog();
                break;
            case R.id.button2:  // 저장하기
                String user_name = editText1.getText().toString().trim();
                String user_pwd = editText2.getText().toString().trim();
                String email = editText3.getText().toString().trim();
                String subject = editText4.getText().toString().trim();
                String content = editText5.getText().toString().trim();
                // 입력값 검사
                String msg = null;
                if(msg==null && user_name.equals("")) {
                    msg = "이름을 입력하세요";
                } else if(msg==null && user_pwd.equals("")) {
                    msg = "비밀번호를 입력하세요";
                } else if(msg==null && email.equals("")) {
                    msg = "이메일을 입력하세요";
                } else if(msg==null && subject.equals("")) {
                    msg = "제목을 입력하세요";
                } else if(msg==null && content.equals("")) {
                    msg = "내용을 입력하세요";
                } else if(msg==null && filePath==null) {
                    msg = "사진을 선택하세요";
                }
                if(msg != null) {
                    Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
                    return;
                }
                // 모든 값이 있으면
                RequestParams params = new RequestParams();
                params.put("user_name", user_name);
                params.put("user_pwd", user_pwd);
                params.put("email", email);
                params.put("subject", subject);
                params.put("content", content);
                try {
                    params.put("photo", new File(filePath));
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                // multipart로 보내기 설정 (파일이 없어도)
                params.setForceMultipartEntityContentType(true);
                client.post(url, params, response);
                break;
            case R.id.button3:  // 취소하기
                finish();
                break;
        }
    }

    private void showListDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        String[] items = {"새로 촬영하기", "갤러리에서 가져오기"};

        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = null;
                switch (which) {
                    case 0:     // 새로 촬영하기
                        filePath = PhotoHelper.getInstance().getNewPhotoPath();
                        // 카메라 앱 호출
                        File file = new File(filePath);
                        Uri uri = null;
                        intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                            uri = FileProvider.getUriForFile(getApplicationContext(),
                                    getApplicationContext().getPackageName()
                                            + ".fileprovider", file );
                            intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                            intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                        } else {
                            uri = Uri.fromFile(file);
                        }
                        // uri = content://com.example.imageboard.fileprovider/
                        //       external_files/DCIM/2020-11-10-07-50-28.jpg
                        Log.d("[TEST]", "uri = " + uri);
                        intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
                        startActivityForResult(intent, 100);
                        break;
                    case 1:     // 갤러리에서 가져오기
                        intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
                        intent.addCategory(Intent.CATEGORY_OPENABLE);
                        intent.setType("image/*");
                        intent.putExtra(Intent.EXTRA_LOCAL_ONLY, true);
                        startActivityForResult(intent, 101);
                        break;
                }

            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case 100:   // 카메라앱 호출 후
                // 촬영 결과를 갤러리에 등록
                Intent photoIntent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE,
                        Uri.parse("file://" + filePath));
                sendBroadcast(photoIntent);
                break;
            case 101:   // 갤러리 앱 호출 후
                if(resultCode == RESULT_OK) {
                    filePath = FileUtils.getPath(this, data.getData());
                    Log.d("[TEST]", data.getData().toString());
                    Log.d("[TEST]", "filePath=" + filePath);
                    // content://com.android.providers.media.documents/document/image%3A54
                    // filePath=/storage/emulated/0/DCIM/2020-11-10-07-56-06.jpg
                }
                break;
        }
    }

    class HttpResponse extends AsyncHttpResponseHandler {
        @Override
        public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
            String str = new String(responseBody);
            try {
                JSONObject json = new JSONObject(str);
                String rt = json.getString("rt");
                if(rt.equals("OK")) {
                    Toast.makeText(WriteActivity.this, "저장 성공", Toast.LENGTH_SHORT).show();
                    finish(); // 현재 액티비티 종료 -> 메인으로 돌아가기
                } else {
                    Toast.makeText(WriteActivity.this, "저장 실패", Toast.LENGTH_SHORT).show();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        @Override
        public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
            Toast.makeText(WriteActivity.this, "통신 실패", Toast.LENGTH_SHORT).show();
        }
    }
}