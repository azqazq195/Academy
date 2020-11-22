import java.awt.*;

class Form3 extends Frame {
	Button button = new Button("확인");
	
	public Form3() {
		// Frame 설정
		setTitle("기본 화면");
		setSize(300,200);
		
		init();		// 화면구성
		start();	// 이벤트 설정
		
		setVisible(true);
	}
	
	private void init() {
		setLayout(null);
		button.setBackground(Color.YELLOW);
		button.setBounds(100, 100, 80, 30);
		add(button);
	}
	
	private void start() {
		
	}
}

public class Exam3 {
	public static void main(String[] args) {
		Form3 form3 = new Form3();
	}
}
