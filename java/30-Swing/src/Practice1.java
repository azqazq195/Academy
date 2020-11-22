import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;

class SwingPrac1 extends JFrame {
	Container container = getContentPane();
	// 개인정보 영역
	JLabel labelName = new JLabel("이름 : ", JLabel.RIGHT);
	JLabel labelJumin = new JLabel("주민번호 : ", JLabel.RIGHT);
	JLabel labelPhone = new JLabel("전화번호 : ", JLabel.RIGHT);
	JLabel labelAddr = new JLabel("주소 : ", JLabel.RIGHT);
	
	JTextField textFieldName = new JTextField(14);
	JTextField textFieldJumin1 = new JTextField(7);
	JTextField textFieldJumin2 = new JTextField(7);
	JTextField textFieldPhone = new JTextField(14);
	JTextField textFieldAddr = new JTextField(14);
	
	JPanel panelLU = new JPanel();  // Left Up
	JPanel panelLabel = new JPanel();
	JPanel panelTextField = new JPanel();
	JPanel panelJumin = new JPanel();
	JPanel panelL = new JPanel();  // 개인정보영역 (LU) + 정보검색영역(LD)
	
	// 정보검색 영역
	JLabel labelS = new JLabel("검색 : ");
	JTextField textFieldS1 = new JTextField(7);
	JTextField textFieldS2 = new JTextField(7);
	JTextArea textAreaS = new JTextArea();
	JScrollPane scrollPaneS = new JScrollPane(textAreaS);
	
	JButton buttonS = new JButton("검색");
	JButton buttonAL = new JButton("<<");
	JButton buttonAR = new JButton(">>");
	
	JPanel panelLD = new JPanel();   // Left Down
	JPanel panelS = new JPanel();
	JPanel panelBtn = new JPanel();
	JPanel panelSC = new JPanel();   // JTextField 2개 묶기용
	
	// 개인정보 확인 영역
	JLabel labelR = new JLabel("<== 이것을 누르면 전체보기가 됩니다.");
	JTextArea textAreaR = new JTextArea();
	JScrollPane scrollPaneR = new JScrollPane(textAreaR);
	
	JButton buttonR = new JButton("전체보기");
	JButton button1 = new JButton("등록");
	JButton button2 = new JButton("수정");
	JButton button3 = new JButton("삭제");
	JButton button4 = new JButton("Clear");
	JButton button5 = new JButton("저장");
	JButton button6 = new JButton("로드");
	JButton button7 = new JButton("종료");
	
	JPanel panelR = new JPanel();
	JPanel panelRT = new JPanel();
	JPanel panelRB = new JPanel();
	
	public SwingPrac1() {
		// JFrame 설정
		setTitle("SwingPrac1");
		setSize(720, 400);
		setLocation(2200, 300);
		setResizable(false);  // 화면 크기 변경 금지
		
		init();		// 화면 구성
		start();	// 이벤트 설정
		
		setVisible(true);
	}
	private void init() {
		// frame 구성
		container.setLayout(new BorderLayout());
		container.add("West", panelL);
		container.add("Center", panelR);
		
		/** panelL 구성 **/
		panelL.setLayout(new GridLayout(2, 1, 3, 3));
		panelL.add(panelLU);
		panelL.add(panelLD);
		
		/* 왼쪽 상단부 (panelLU) */
		panelLU.setLayout(new BorderLayout());
		panelLU.setBorder(new TitledBorder(new BevelBorder(BevelBorder.RAISED),"개인정보"));
		panelLU.add("West", panelLabel);
		panelLU.add("Center", panelTextField);
		// panelLabel 구성
		panelLabel.setLayout(new GridLayout(4, 1));
		panelLabel.add(labelName);
		panelLabel.add(labelJumin);
		panelLabel.add(labelPhone);
		panelLabel.add(labelAddr);
		// panelTextField 구성
		panelTextField.setLayout(new GridLayout(4, 1));
		panelTextField.add(textFieldName);
		panelTextField.add(panelJumin);
		panelTextField.add(textFieldPhone);
		panelTextField.add(textFieldAddr);
		// panelJumin 구성
		panelJumin.setLayout(new GridLayout(1, 2, 3, 3));
		panelJumin.add(textFieldJumin1);
		panelJumin.add(textFieldJumin2);
		
		/* 왼쪽 하단부 (panelLD) */
		panelLD.setLayout(new BorderLayout());
		panelLD.setBorder(new TitledBorder(new BevelBorder(BevelBorder.RAISED),"정보검색"));
		panelLD.add("North", panelS);
		panelLD.add("Center", scrollPaneS);
		panelLD.add("South", panelBtn);
		// panelS 구성
		panelS.setLayout(new BorderLayout());
		panelS.add("West", labelS);
		panelS.add("Center", panelSC);
		panelS.add("East", buttonS);
		// panelSC 구성
		panelSC.setLayout(new GridLayout(1, 2, 3, 3));
		panelSC.add(textFieldS1);
		panelSC.add(textFieldS2);
		// panelBtn 구성
		panelBtn.setLayout(new FlowLayout());
		panelBtn.add(buttonAL);
		panelBtn.add(buttonAR);
		
		/** panelR 구성 **/
		panelR.setLayout(new BorderLayout());
		panelR.setBorder(new TitledBorder(new BevelBorder(BevelBorder.RAISED),"개인정보확인"));
		panelR.add("North", panelRT);
		panelR.add("Center", scrollPaneR);
		panelR.add("South", panelRB);
		// panelRT 구성
		panelRT.setLayout(new FlowLayout(FlowLayout.LEFT));
		panelRT.add(buttonR);
		panelRT.add(labelR);
		// panelRB 구성
		panelRB.setLayout(new GridLayout(1, 7));
		panelRB.add(button1);
		panelRB.add(button2);
		panelRB.add(button3);
		panelRB.add(button4);
		panelRB.add(button5);
		panelRB.add(button6);
		panelRB.add(button7);
		
		// 버튼 비활성화
		buttonS.setEnabled(false);
		buttonAL.setEnabled(false);
		buttonAR.setEnabled(false);
		buttonR.setEnabled(false);
		button1.setEnabled(false);
		button2.setEnabled(false);
		button3.setEnabled(false);
		button4.setEnabled(false);
		button5.setEnabled(false);		
	}
	private void start() {
		// x button 이벤트 처리
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}

public class Practice1 {
	public static void main(String[] args) {
		new SwingPrac1();
	}
}




