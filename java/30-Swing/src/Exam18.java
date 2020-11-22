import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

class Swing18 extends JFrame {
	Container container = getContentPane();
	// 첫번째 줄
	JLabel labelId = new JLabel("ID : ", JLabel.RIGHT);
	JTextField textField = new JTextField();
	// 두번째 줄
	JTextArea textArea = new JTextArea();
	JScrollPane scrollPane = new JScrollPane(textArea);
	// 세번째 줄
	JLabel labelPass = new JLabel("Password : ", JLabel.RIGHT);
	JPasswordField passwordField = new JPasswordField();
	// panel
	JPanel panel1 = new JPanel();
	JPanel panel2 = new JPanel();
	
	public Swing18() {
		setTitle("Swing18");
		setSize(300, 200);
		setLocation(3300, 300);
		init();
		start();
		setVisible(true);
	}
	private void init() {
		container.setLayout(new BorderLayout());
		container.add("North", panel1);
		container.add("Center", scrollPane);
		container.add("South", panel2);
		// panel1 구성
		panel1.setLayout(new BorderLayout());
		panel1.add("West", labelId);
		panel1.add("Center", textField);
		// panel2 구성 
		panel2.setLayout(new BorderLayout());
		panel2.add("West", labelPass);
		panel2.add("Center", passwordField);
		// 비밀번호를 적을 때 나타나는 문자 지정. 기본값은 '*'
		passwordField.setEchoChar('%');
	}
	private void start() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		passwordField.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				//String result = passwordField.getText();
				String result = new String(passwordField.getPassword());
				textArea.setText(result);
				passwordField.setText("");
			}
		});
	}
}
public class Exam18 {
	public static void main(String[] args) {
		new Swing18();
	}
}



