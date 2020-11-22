package com.example.practice7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.airbnb.lottie.LottieAnimationView;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity {

    // 스플래시 스크린 속도 ms
    private static int SPLASH_SCREEN = 3500;

    Animation bottomAnim;
    TextView textView;
    LottieAnimationView lottie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 위에 상태바 제거
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);

        bottomAnim = AnimationUtils.loadAnimation(this, R.anim.bottom_animation);

        textView = findViewById(R.id.textView);
        lottie = findViewById(R.id.lottie);

        textView.setAnimation(bottomAnim);
        lottie.setSpeed(2.3f);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, SPLASH_SCREEN);
    }
}