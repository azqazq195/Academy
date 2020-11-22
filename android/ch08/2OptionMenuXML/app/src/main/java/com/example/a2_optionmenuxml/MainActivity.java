package com.example.a2_optionmenuxml;

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
        getMenuInflater().inflate(R.menu.optionmenu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.jjajang:
                Toast.makeText(this, "짜장은 달콤해...",
                        Toast.LENGTH_SHORT).show();
                break;
            case R.id.jjambbong:
                Toast.makeText(this, "짬뽕은 맛있어...",
                        Toast.LENGTH_SHORT).show();
                break;
            case R.id.udong:
                Toast.makeText(this, "우동은 깔끔해...",
                        Toast.LENGTH_SHORT).show();
                break;
            case R.id.mandoo:
                Toast.makeText(this, "만두는 바싹해...",
                        Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}







