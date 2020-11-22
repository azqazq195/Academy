package score;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ScoreForm extends Frame implements ActionListener{
	Button button1 = new Button("입력");
	Button button2 = new Button("출력");
	Button button3 = new Button("학번검색");
	Button button4 = new Button("이름검색");
	Button button5 = new Button("파일저장");
	Button button6 = new Button("파일읽기");
	
	Label labelHak = new Label("학번");
	Label labelName = new Label("이름");
	Label labelKor = new Label("국어");
	Label labelEng = new Label("영어");
	Label labelMat = new Label("수학");
	
	TextField textFieldHak = new TextField(15);
	TextField textFieldName = new TextField(15);
	TextField textFieldKor = new TextField(15);
	TextField textFieldEng = new TextField(15);
	TextField textFieldMat = new TextField(15);
	
	TextArea textArea = new TextArea();
	
	Panel panelCenter = new Panel();
	Panel panelBtn = new Panel();
	Panel panelBind = new Panel();
	Panel panelHak = new Panel();
	Panel panelName = new Panel();
	Panel panelKor = new Panel();
	Panel panelEng = new Panel();
	Panel panelMat = new Panel();
	// 학생 성적 처리
	Score score = new ScoreImpl();
	
	public ScoreForm() {
		// frame 설정
		setTitle("성적 관리");
		setSize(600, 250);
		setLocation(300, 300);
		
		init();		// 화면 구성
		start();	// 이벤트 설정
		
		setVisible(true);
	}	
	private void init() {
		/** Frame 구성 **/
		super.setLayout(new BorderLayout());
		super.add("Center", panelCenter);
		super.add("South", panelBtn);
		
		/** panelBtn 구성 **/
		panelBtn.setLayout(new GridLayout(1, 6));
		panelBtn.add(button1);
		panelBtn.add(button2);
		panelBtn.add(button3);
		panelBtn.add(button4);
		panelBtn.add(button5);
		panelBtn.add(button6);
		
		/** panelCenter 구성 **/
		panelCenter.setLayout(new GridLayout(1, 2));
		panelCenter.add(panelBind);
		panelCenter.add(textArea);
		
		/* panelBind */
		panelBind.setLayout(new GridLayout(5, 1));
		panelBind.add(panelHak);
		panelBind.add(panelName);
		panelBind.add(panelKor);
		panelBind.add(panelEng);
		panelBind.add(panelMat);
		
		FlowLayout flowLayout = new FlowLayout(FlowLayout.LEFT);
		// panelHak
		panelHak.setLayout(flowLayout);
		panelHak.add(labelHak);
		panelHak.add(textFieldHak);
		// panelName
		panelName.setLayout(flowLayout);
		panelName.add(labelName);
		panelName.add(textFieldName);
		// panelKor
		panelKor.setLayout(flowLayout);
		panelKor.add(labelKor);
		panelKor.add(textFieldKor);
		// panelEng
		panelEng.setLayout(flowLayout);
		panelEng.add(labelEng);
		panelEng.add(textFieldEng);
		// panelMat
		panelMat.setLayout(flowLayout);
		panelMat.add(labelMat);
		panelMat.add(textFieldMat);
		
		// 버튼 꾸미기
		button1.setBackground(Color.YELLOW);
		button2.setBackground(Color.YELLOW);
		button3.setBackground(Color.YELLOW);
		button4.setBackground(Color.YELLOW);
		button5.setBackground(Color.YELLOW);
		button6.setBackground(Color.YELLOW);
	}
	private void start() {
		// button event 설정
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		button4.addActionListener(this);
		button5.addActionListener(this);
		button6.addActionListener(this);
		
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
		if(e.getSource() == button1) {			// 입력
			String str_hak = textFieldHak.getText();
			String str_name = textFieldName.getText();
			String str_kor = textFieldKor.getText();
			String str_eng = textFieldEng.getText();
			String str_mat = textFieldMat.getText();
			// 입력 검사
			if(str_kor.equals("") || str_eng.equals("") || str_mat.equals("")) {
				textArea.setText("국어, 영어, 수학 점수를 입력해 주세요.");
				return;  // 함수 강제 종료
			}
			int kor = Integer.parseInt(str_kor);
			int eng = Integer.parseInt(str_eng);
			int mat = Integer.parseInt(str_mat);
			int tot = kor + eng + mat;
			double avg = (double)tot/3;
			
			ScoreVO vo = new ScoreVO();
			vo.setHak(str_hak);
			vo.setName(str_name);
			vo.setKor(kor);
			vo.setEng(eng);
			vo.setMat(mat);
			vo.setTot(tot);
			vo.setAvg(avg);
			
			score.input(vo);	
			textArea.setText("입력되었습니다.");
			// 화면 초기화
			textFieldHak.setText("");
			textFieldName.setText("");
			textFieldKor.setText("");
			textFieldEng.setText("");
			textFieldMat.setText("");
		} else if(e.getSource() == button2) {   // 출력
			String str = score.print();
			textArea.setText(str);
		} else if(e.getSource() == button3) {	// 학번 검색
			String hak = textFieldHak.getText();
			// 입력 검사
			if(hak.equals("")) {
				textArea.setText("학번을 입력하세요...");
				return;   // 함수 강제 종료
			}
			String hak_search = score.searchHak(hak);
			textArea.setText(hak_search);
		} else if(e.getSource() == button4) {	// 이름 검색
			String name = textFieldName.getText();
			// 입력 검사
			if(name.equals("")) {
				textArea.setText("이름을 입력하세요...");
				return;   // 함수 강제 종료
			}
			String name_search = score.searchName(name);
			textArea.setText(name_search);
		} else if(e.getSource() == button5) {	// 파일 저장
			String result = score.saveFile();
			textArea.setText(result);
		} else if(e.getSource() == button6) {	// 파일 읽기
			String result = score.loadFile();
			textArea.setText(result);
		}
	}	
}








