import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

class Swing10 extends JFrame implements ActionListener {
	Container container = getContentPane();
	JButton button1 = new JButton("색 선택");
	JButton button2 = new JButton("파일 선택");
	JColorChooser colorChooser = new JColorChooser();
	JFileChooser fileChooser = new JFileChooser("D://");
	
	public Swing10() {
		// JFrame 설정
		setTitle("Swing10");
		setSize(300, 200);
		setLocation(300, 300);
		
		init();
		start();
		
		setVisible(true);
	}
	private void init() {
		container.setLayout(new FlowLayout());
		container.add(button1);
		container.add(button2);
	}
	private void start() {
		// x button
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		// button 이벤트 설정
		button1.addActionListener(this);
		button2.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == button1) {
			execColorChooser();
		} else if(e.getSource() == button2) {
			execFileChooser();
		}
	}
	// ColorChooser 설정 및 실행
	private void execColorChooser() {
		Color color = colorChooser.showDialog(this, "나의 색상 선택", Color.BLACK);
		System.out.println("선택한 색상 = " + color);  // 콘솔 출력은 테스트용으로 사용함
		colorChooser.setColor(color);  // 기본 색상 지정
		System.out.println("저장된 색상 = " + colorChooser.getColor());
		button1.setBackground(color);
	}
	// FileChooser 설정 및 실행
	private void execFileChooser() {
		fileChooser.setDialogTitle("불러오기");
		fileChooser.setMultiSelectionEnabled(true); // 다중 선택 가능
		fileChooser.showDialog(this, "열기");
		File[] files =fileChooser.getSelectedFiles();
		for (int i = 0; i < files.length; i++) {
			System.out.println("파일명 = " + files[i]);
		}
	}
}

public class Exam10 {
	public static void main(String[] args) {
		new Swing10();
	}
}
