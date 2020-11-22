package com.example.a4_activityforresultexam;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView textView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        button = findViewById(R.id.button);

        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String memo = textView.getText().toString();
        // 인텐트 설정
        Intent intent = new Intent(this, EditActivity.class);
        intent.putExtra("memo", memo);
        startActivityForResult(intent, 100);
    }

    /**
     * startActivityForResult()에 의해서 화면이 이동되었다가
     * 이 activity로 되돌아 올 경우, 자동으로 실행된다.
     * @param requestCode : activity id
     * @param resultCode : OK / CANCEL
     * @param data : 인텐트
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d("[TEST]", "requestCode : " + requestCode);
        Log.d("[TEST]", "resultCode : " + resultCode);
        switch (requestCode) {
            case 100:
                if(resultCode == RESULT_OK){
                    String edit = data.getStringExtra("edit");
                    textView.setText(edit);
                }
        }
    }
}