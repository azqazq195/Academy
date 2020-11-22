import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class Sub9 extends Frame implements ActionListener {
	Label label1 = new Label("결과 출력");
	Label label2 = new Label("입력 : ", Label.RIGHT);
	TextArea textArea = new TextArea("");
	TextField textField = new TextField();
	Panel panel = new Panel();
	
	public Sub9() {
		// Frame 설정
		setTitle("Test");
		setSize(300, 200);
		setLocation(300, 300);
		
		init();
		start();
		
		setVisible(true);
	}
	private void init() {
		// frame 구성
		setLayout(new BorderLayout());
		add("North", label1);
		add("Center", textArea);
		add("South", panel);
		// panel 구성
		panel.setLayout(new BorderLayout());
		panel.add("West", label2);
		panel.add("Center", textField);
		// TextArea 쓰기 금지
		textArea.setEditable(false);
	}
	private void start() {
		// textField 이벤트 설정
		textField.addActionListener(this);
		// x 버튼 이벤트 처리
		super.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				super.windowClosing(e);
				System.exit(0); 
			}
		});
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String str = textField.getText();
		if(!textArea.getText().equals("")) { // textArea에 문자열이 있으면
			str = textArea.getText() + "\n" + str;  // 기존 출력된 문자열에 덧붙여서 출력
		}
		textArea.setText(str);
		//TextArea 마지막 줄 표시
		textArea.setCaretPosition(textArea.getText().length());
		textField.setText("");
	}	
}
public class Exam9 {
	public static void main(String[] args) {
		Sub9 sub9 = new Sub9();
	}
}












