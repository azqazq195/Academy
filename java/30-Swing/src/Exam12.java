import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;

class Swing12 extends JFrame {
	Container container = getContentPane();
	String[] str = {"AAA", "BBB", "CCC", "DDD", "EEE"};
	JComboBox<String> comboBox = new JComboBox<String>(str); 
	
	public Swing12() {
		// JFrame 설정
		setTitle("Swing12");
		setSize(300,200);
		setLocation(300, 300);
		
		init();
		start();
		
		setVisible(true);
	}
	private void init() {
		container.setLayout(new FlowLayout());
		container.add(comboBox);
	}
	private void start() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		// comboBox 이벤트 처리
		comboBox.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(comboBox.getSelectedItem());
			}
		});
	}
}

public class Exam12 {
	public static void main(String[] args) {
		new Swing12();
	}
}
