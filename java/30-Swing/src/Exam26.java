import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

class Swing26 extends JFrame implements ActionListener{
	Container container = getContentPane();
	JButton button1 = new JButton("버튼1");
	JButton button2 = new JButton("버튼2");
	
	public Swing26() {
		setTitle("Swing26");
		setSize(300, 200);
		setLocation(3300, 300);
		init();
		start();
		setVisible(true);
	}
	private void init() {
		container.setLayout(new BorderLayout());
		container.add("Center", button1);
	}
	private void start() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		// 버튼 이벤트 설정
		button1.addActionListener(this);
		button2.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// 화면전환
		if(e.getSource() == button1) {  		// button2 화면으로 전환
			container.remove(button1); 			// 컴포넌트 없애기
			container.invalidate(); 			// 무효화
			container.add("Center", button2);	// 추가
			container.revalidate(); 			// 유효화
			container.repaint(); 				// 화면 갱신
		} else if(e.getSource() == button2) {	// button1 화면으로 전환
			container.remove(button2); 			// 컴포넌트 없애기
			container.invalidate(); 			// 무효화
			container.add("Center", button1);	// 추가
			container.revalidate(); 			// 유효화
			container.repaint(); 				// 화면 갱신
		}
	}
}

public class Exam26 {
	public static void main(String[] args) {
		new Swing26();
	}
}
