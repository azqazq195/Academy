package calendar;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class Swing28 extends JFrame implements ActionListener {
	Container container = getContentPane();
	JPanel panel1 = new JPanel();
	JPanel panel2 = new JPanel();
	
	JButton buttonBefore = new JButton("Before");
	JButton buttonAfter = new JButton("After");
	JLabel label = new JLabel("0000년 0월");
	
	JButton[] buttons = new JButton[49];  // 객체 배열 선언
	String[] dayNames = {"일", "월", "화", "수", "목", "금", "토"};
	// Calendar 관리 클래스
	HCalendar hCalendar = new HCalendar();
	
	public Swing28() {
		setTitle("만년 달력");
		setSize(550, 400);
		setLocation(3300, 300);
		setResizable(false); // 크기 변경 금지
		init();
		start();
		setVisible(true);
	}
	private void init() {
		// frame 구성
		container.setLayout(new BorderLayout());
		container.add("North", panel1);
		container.add("Center", panel2);
		
		// 버튼과 라벨 설정
		Font font = new Font("SansSerif", Font.BOLD, 20);
		buttonAfter.setFont(font);
		buttonBefore.setFont(font); 
		label.setFont(font); 
		label.setText(hCalendar.getCalText());
		
		// panel1 구성
		panel1.setLayout(new FlowLayout());
		panel1.add(buttonBefore);
		panel1.add(label);
		panel1.add(buttonAfter);
		
		// panel2 구성
		panel2.setLayout(new GridLayout(7, 7, 5, 5));
		
		for(int i=0; i<buttons.length; i++) {
			buttons[i] = new JButton();
			panel2.add(buttons[i]);
			// 버튼 폰트 설정
			buttons[i].setFont(new Font("Sherif", Font.BOLD, 24));
			
			// buttons[0]~[6] : 일~토 글씨넣기
			if(i < 7) buttons[i].setText(dayNames[i]);
			// 버튼 색 설정 : 일 => 빨간색, 토 => 파란색
			if(i%7 == 0) { // 일
				buttons[i].setForeground(Color.RED);
			}
			if(i%7 == 6) {  // 토
				buttons[i].setForeground(Color.BLUE);
			}
		}
		// 날짜 출력
		hCalendar.setButtons(buttons);  // hCalendar객체에 buttons 객체 배열 전달
		hCalendar.calSet();				// buttons 배열에 날짜 출력
	}
	private void start() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		// 버튼 이벤트 설정
		buttonAfter.addActionListener(this);
		buttonBefore.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == buttonBefore) {   		// 1달전
			hCalendar.allInit(-1);			
		} else if(e.getSource() == buttonAfter) {	// 1달후
			hCalendar.allInit(1);
		}
		label.setText(hCalendar.getCalText());  // 년/월 수정
	}
}

public class Exam28 {
	public static void main(String[] args) {
		new Swing28();
	}
}








