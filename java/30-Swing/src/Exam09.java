import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

class Swing09 extends JFrame {
	Container container = this.getContentPane();
	JLabel label = new JLabel("ID : ", JLabel.RIGHT);
	JTextField textField = new JTextField(10);
	
	JDialog dialog = new JDialog(this, "확인");
	Container dialogContainer = dialog.getContentPane();
	JLabel dialogLabel = new JLabel("사용할 수 있는 ID입니다.", JLabel.CENTER);
	
	public Swing09() {
		// JFrame 설정
		setTitle("Swing09");
		setSize(300, 200);
		setLocation(300, 300);
		
		init();
		start();
		
		setVisible(true);
	}
	private void init() {
		// JFrame 구성
		container.setLayout(new FlowLayout());
		container.add(label);
		container.add(textField);
		// JDialog 구성
		dialog.setSize(200, 150); 
		dialog.setLocation(400, 400);
		
		dialogContainer.setLayout(new BorderLayout());
		dialogContainer.add("Center", dialogLabel);
		dialogLabel.setBorder(new BevelBorder(BevelBorder.RAISED));		
	}
	private void start() {
		// x button
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		// dialog x버튼 처리 : 숨김기능만 처리
		dialog.setDefaultCloseOperation(HIDE_ON_CLOSE);
		// TextField 이벤트 처리
		textField.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				dialog.setVisible(true);
			}
		});
	}
}

public class Exam09 {
	public static void main(String[] args) {
		new Swing09();
	}
}
