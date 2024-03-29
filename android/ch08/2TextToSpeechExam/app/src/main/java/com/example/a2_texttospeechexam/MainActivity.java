package com.example.a2_texttospeechexam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Locale;

/*
    TTS 엔진이 무겁기 때문에, 초기화 시간이 오래 걸린다.
    초기화 작업은 백그라운드로 실행되며, 초기화가 완료되면 이벤트를 발생시킨다.
 */
public class MainActivity extends AppCompatActivity
        implements View.OnClickListener, TextToSpeech.OnInitListener {
    EditText editText;
    Button button;
    TextToSpeech tts;
    boolean init;  // tts 객체 초기화 여부 저장

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        button = findViewById(R.id.button);

        button.setOnClickListener(this);
        // tts 초기화
        init = false;
        tts = new TextToSpeech(this, this);
    }

    @Override
    public void onClick(View v) {
        if(!init) {  // tts가 초기화되지 않으면
            Toast.makeText(this, "아직 초기화 되지 않았습니다.",
                    Toast.LENGTH_SHORT).show();
            return;
        }
        // 사용자가 입력한 내용
        String msg = editText.getText().toString().trim();
        // 입력 검사
        if(msg.equals("")) {
            Toast.makeText(this, "내용을 입력하세요",
                    Toast.LENGTH_SHORT).show();
            return;
        }

        // 언어 선택
        Locale locale = Locale.KOREA;
        // 해당 언어가 지원되는 지 검사
        int available = tts.isLanguageAvailable(locale);

        if(available < 0) {
            Toast.makeText(this, "지원되지 않는 언어입니다.",
                    Toast.LENGTH_SHORT).show();
            return;
        }
        // 언어 설정
        tts.setLanguage(locale);
        // 읽기
        // TextToSpeech.QUEUE_FLUSH : 기존에 읽던 데이터가 남아있으면, 지우고, 처음부터 읽어라 옵션
        tts.speak(msg, TextToSpeech.QUEUE_FLUSH, null);
    }

    @Override
    public void onInit(int status) {
        init = (status == TextToSpeech.SUCCESS);
        String msg = "엔진이 초기화에 실패했습니다.";
        if(init) msg = "엔진이 초기화에 성공했습니다.";
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    // tts는 앱이 종료되어도 메모리에 상주하기 때문에
    // 앱이 종료되는 시점에 직접 메모리에서 해제시켜야 한다.
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(tts != null) {
            tts.stop();  // 음성 출력 정지
            tts.shutdown(); // tts 종료
        }
    }
}







