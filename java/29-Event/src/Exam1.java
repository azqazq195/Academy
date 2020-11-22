import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ActionDefine implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent e) {
		// 프로그램 종료
		System.exit(0);
	}	
}

class Event1 extends Frame {
	Button button = new Button("OK");
	ActionDefine actionDefine = new ActionDefine();
	
	public Event1() {
		// Frame 설정
		setTitle("Event  클래스 이용");
		setSize(300, 200);
		
		init();		// 화면 구성
		start();	// 이벤트 설정
		
		setVisible(true);
	}
	// 화면 구성
	private void init() {
		setLayout(null); 
		button.setBackground(Color.YELLOW);
		button.setBounds(100, 100, 80, 30);
		add(button);
	}
	// 이벤트 설정
	private void start() {
		// 1. 버튼을 클릭할 때 동작될 Listener를 등록
		// 2. Listener에 있는 함수 구현
		// => 버튼을 클릭하면, ActionEvent 클래스가 event.actionPerformed() 함수를 호출함
		button.addActionListener(actionDefine);
	}	
}

public class Exam1 {
	public static void main(String[] args) {
		Event1 event1 = new Event1();
	}
}





