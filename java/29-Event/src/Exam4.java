import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class Event4 extends Frame {
	Button button = new Button("OK");
	
	public Event4() {
		// Frame 설정
		setTitle("Event 다형성 이용"); 
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
		// 버튼 이벤트 처리
		ActionListener listener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}			
		};
		button.addActionListener(listener);
		// 프레임 창의 x버튼 종료 처리
		WindowAdapter adapter = new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				super.windowClosing(e);
				System.exit(0); 
			}
		};
		super.addWindowListener(adapter);
	}	
}
public class Exam4 {
	public static void main(String[] args) {
		Event4 event4 = new Event4();
	}
}




