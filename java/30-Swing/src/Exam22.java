import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
// Runnable : 쓰레드 인터페이스
// 쓰레드(Thread) : run() 함수를 메인 함수와는 별개로 동작을 시키는 것
class Swing22 extends JFrame implements ActionListener, Runnable{
	Container container = getContentPane();
	JLabel label = new JLabel("Progress Bar");
	// JProgressBar(int orient, int min, int max)
	JProgressBar progressBar = new JProgressBar(JProgressBar.HORIZONTAL, 0, 100);
	JButton buttonStart = new JButton("시작");
	JButton buttonEnd = new JButton("멈춤");
	JPanel panel = new JPanel();
	// 진행 상태 관리 변수
	boolean isProgress = true;
	int num = 0;  // 0~100 사이값 저장용
	
	public Swing22() {
		setTitle("Swing22");
		setSize(300, 200);
		setLocation(3300, 300);
		init();
		start();
		setVisible(true);
	}
	private void init() {
		container.setLayout(new BorderLayout());
		container.add("North", label);
		container.add("Center", progressBar);
		container.add("South", panel);
		// panel 구성
		panel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		panel.add(buttonStart);
		panel.add(buttonEnd);
		// progressBar 설정
		progressBar.setStringPainted(true);
		progressBar.setString("0%");
	}
	private void start() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		// 버튼 이벤트 설정
		buttonStart.addActionListener(this);
		buttonEnd.addActionListener(this);
	}	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == buttonStart) {
			isProgress = true;  // 진행중 상태
			new Thread(this).start();   	// run() 함수를 동작시킴
			buttonStart.setEnabled(false);  // 버튼 비활성화
			buttonEnd.setEnabled(true); 	// 버튼 활성화
		} else if(e.getSource() == buttonEnd) {
			isProgress = false;  // 멈춤 상태
			buttonStart.setEnabled(true);  	// 버튼 활성화
			buttonEnd.setEnabled(false); 	// 버튼 비활성화
		}
	}
	// main 함수와 상관없이, 독립적으로 동작되는 함수
	@Override
	public void run() {
		if(num == 100) num = 0;
		for(int i=num; i<=100; i++) {
			if(!isProgress) break;
			try {
				Thread.sleep(50);   // 50ms 지연
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			num = i;
			progressBar.setValue(i);		// 진행바의 현재값 지정
			progressBar.setString(i + "%"); // 진행바와 같이 보여줄 문자열 지정
		}
		
		buttonStart.setEnabled(true); 
		buttonEnd.setEnabled(false);
	}
}

public class Exam22 {
	public static void main(String[] args) {
		new Swing22();
	}
}




