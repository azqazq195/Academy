import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JRadioButton;

class Swing06 extends JFrame implements ActionListener {
	Container container = getContentPane();
	JRadioButton radioButton1 = new JRadioButton("여자", true);
	JRadioButton radioButton2 = new JRadioButton("남자");
	JRadioButton radioButton3 = new JRadioButton("청소년");
	JRadioButton radioButton4 = new JRadioButton("성인", true);
	
	ButtonGroup buttonGroup1 = new ButtonGroup();
	ButtonGroup buttonGroup2 = new ButtonGroup();
	
	public Swing06() {
		// JFrame 설정
		setTitle("Swing06");
		setSize(200, 100);
		setLocation(2300, 300);
		
		init();
		start();
		
		setVisible(true);
	}
	private void init() {
		container.setLayout(new GridLayout(2, 2, 5, 5));
		container.add(radioButton1);
		container.add(radioButton2);
		container.add(radioButton3);
		container.add(radioButton4);
		// 그룹으로 묶음
		buttonGroup1.add(radioButton1);
		buttonGroup1.add(radioButton2);
		
		buttonGroup2.add(radioButton3);
		buttonGroup2.add(radioButton4);
		
	}
	private void start() {
		// x button
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		// button 이벤트 설정
		radioButton1.addActionListener(this);
		radioButton2.addActionListener(this);
		radioButton3.addActionListener(this);
		radioButton4.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == radioButton1) {
			System.out.println("여자");
		} else if(e.getSource() == radioButton2) {
			System.out.println("남자");
		} else if(e.getSource() == radioButton3) {
			System.out.println("청소년");
		} else if(e.getSource() == radioButton4) {
			System.out.println("성인");
		} 
	}
}
public class Exam06 {
	public static void main(String[] args) {
		new Swing06();
	}
}
