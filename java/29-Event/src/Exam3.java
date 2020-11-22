import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

class Event3 extends Frame {
	Button button = new Button("OK");
	
	public Event3() {
		// Frame 설정
		setTitle("Event 익명 클래스 이용");
		setSize(300, 200);
		
		init();
		start();
		
		setVisible(true);
	}
	private void init() {
		setLayout(null); 
		button.setBackground(Color.YELLOW);
		button.setBounds(100, 100, 80, 30);
		add(button);
	}
	private void start() {
		// 1. 버튼을 클릭할 때 동작될 Listener를 등록
		// 2. Listener에 있는 함수 구현
		// => 버튼을 클릭하면, ActionEvent 클래스가 event.actionPerformed() 함수를 호출함
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}			
		});
		// 프레임 창의 x버튼 종료 처리
		super.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				super.windowClosing(e);
				System.exit(0);
			}
		});
	}
}
public class Exam3 {
	public static void main(String[] args) {
		Event3 event3 = new Event3();
	}
}







