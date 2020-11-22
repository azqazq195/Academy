import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;

public class Exam2 {
	public static void main(String[] args) {
		Frame f = new Frame();
		f.setSize(300, 200);
		f.setTitle("기본 화면");
		// 윈도우 창에 버튼 추가하기
		Button button = new Button("확인");
		button.setBackground(Color.YELLOW);	// 버튼의 바탕색 설정
		// 버튼의 위치와 크기 설정
		button.setBounds(100, 100, 80, 30);
		// 버튼 추가
		f.setLayout(null);	// 화면 분할에 Layout을 사용하지 않음
		f.add(button);
		f.setVisible(true);
	}
}
