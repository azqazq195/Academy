import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class ScoreFrame extends Frame implements ActionListener {
	Button buttonInput = new Button("입력");
	Button buttonCancel = new Button("취소");
	// Label : 문자열 하나 보여주기 클래스
	Label labelKor = new Label("국어");
	Label labelEng = new Label("영어");
	Label labelTot = new Label(" 총점 : ");
	Label labelAvg = new Label(" 평균 : ");
	// TextField : 문자열 1개 입력 클래스
	TextField textFieldKor = new TextField(25);
	TextField textFieldEng = new TextField(25);
	// Panel
	Panel panelKor = new Panel();
	Panel panelEng = new Panel();
	Panel panelBind = new Panel();
	Panel panelButton = new Panel();
	// Layout	
	FlowLayout flowLayoutSubject = new FlowLayout(FlowLayout.LEFT); // panelKor, panelEng
	GridLayout gridLayoutBind = new GridLayout(4, 1);		// panelBind
	GridLayout gridLayoutButton = new GridLayout(1, 2);		// panelButton
	BorderLayout borderLayout = new BorderLayout();			// Frame
	
	public ScoreFrame() {
		// frame 설정
		setTitle("Panel");
		setSize(300, 200);
		setLocation(300, 300);
		
		init();
		start();
		
		setVisible(true);
	}	
	private void init() {
		// frame 화면
		setLayout(borderLayout);
		add("Center", panelBind);
		add("South", panelButton);
		// panelButton 화면
		panelButton.setLayout(gridLayoutButton);
		panelButton.add(buttonInput);
		panelButton.add(buttonCancel);
		// panelBind 화면
		panelBind.setLayout(gridLayoutBind);
		panelBind.add(panelKor);
		panelBind.add(panelEng);
		panelBind.add(labelTot);
		panelBind.add(labelAvg);
		// panelKor 화면
		panelKor.setLayout(flowLayoutSubject);
		panelKor.add(labelKor);
		panelKor.add(textFieldKor);
		// panelEng 화면
		panelEng.setLayout(flowLayoutSubject);
		panelEng.add(labelEng);
		panelEng.add(textFieldEng);
		// button 꾸미기
		buttonInput.setBackground(Color.YELLOW);
		buttonCancel.setBackground(Color.YELLOW);
	}
	private void start() {
		// button event
		buttonInput.addActionListener(this);
		buttonCancel.addActionListener(this);
		// x button event
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
		if(e.getSource() == buttonInput) { // 입력
			try {
				int kor = Integer.parseInt(textFieldKor.getText());
				int eng = Integer.parseInt(textFieldEng.getText());
				int tot = kor + eng;
				double avg = (double)tot / 2;
				labelTot.setText(" 총점 : " + tot);
				labelAvg.setText(" 평균 : " + avg);
			} catch(Exception ex) {
				Dialog dialog = new Dialog(this);
				dialog.setSize(200, 100);
				dialog.setLocation(400, 400);
				dialog.add(new Label("입력값이 잘못되었습니다."));
				dialog.setVisible(true);
				// dialog x button
				dialog.addWindowListener(new WindowAdapter() {
					@Override
					public void windowClosing(WindowEvent e) {
						super.windowClosing(e);
						dialog.dispose();
					}
				});
				
			}
		} else if(e.getSource() == buttonCancel) {  // 취소
			textFieldKor.getText();   // TextField 클래스가 문자를 인식
			textFieldEng.getText();
			textFieldKor.setText("");
			textFieldEng.setText("");
			labelTot.setText(" 총점 : ");
			labelAvg.setText(" 평균 : ");
		}
	}
}
public class Exam7 {
	public static void main(String[] args) {
		ScoreFrame scoreFrame = new ScoreFrame();
	}
}








