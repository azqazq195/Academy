import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Event2 extends Frame implements ActionListener {
	Button button = new Button("OK");
	
	public Event2() {
		// Frame 설정
		setTitle("Event Listener 상속 이용");
		setSize(300, 200); 
		
		init(); //화면구성
		start();//이벤트 설정
		
		setVisible(true);
	}
	private void init() {
		setLayout(null); 
		// 버튼 설정
		button.setBackground(Color.YELLOW);
		button.setBounds(100, 100, 80, 30);
		add(button);  // Frame에 버튼 추가
	}
	private void start() { // start(Event2 this)
		// 1. 버튼을 클릭할 때 동작될 Listener를 등록
		// 2. Listener에 있는 함수 구현
		// => 버튼을 클릭하면, ActionEvent 클래스가 event.actionPerformed() 함수를 호출함
		button.addActionListener(this);
	}
	// 버튼을 클릭하면 ActionEvent가 actionPerformed() 메소드를 호출함
	@Override
	public void actionPerformed(ActionEvent e) {
		System.exit(0); 
	}	
}
public class Exam2 {
	public static void main(String[] args) {
		Event2 event2 = new Event2();
	}
}












