package com.example.a3_menuonclick;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.onclickmenu, menu);
        return super.onCreateOptionsMenu(menu);
    }
    // onOptionsItemSelected() 대신 사용
    public void onMenuClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.about:
                Toast.makeText(this, "onClick속성으로 메뉴 이벤트를 처리합니다.",
                        Toast.LENGTH_SHORT).show();
                break;
            case R.id.help:
                Toast.makeText(this, "도움말 입니다.", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

}





