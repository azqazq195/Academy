import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.text.DateFormatSymbols;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerNumberModel;

class Swing20 extends JFrame {
	Container container = getContentPane();
	JSpinner spinner1 = new JSpinner();
	JSpinner spinner2 = new JSpinner();
	JSpinner spinner3 = new JSpinner();	
	JPanel panel = new JPanel();
	// spinner에 사용할 컴포넌트
	//JTextField textField = new JTextField();
	// 1월~12월 설정
	DateFormatSymbols dateFormatSymbols = new DateFormatSymbols();
	String[] str = dateFormatSymbols.getMonths();
	// spinner의 내용을 채우는 클래스
	SpinnerListModel spinnerListModel = new SpinnerListModel(str);
	// 현재 시스템의 날짜값을 그래도 가져온다.
	SpinnerDateModel spinnerDateModel = new SpinnerDateModel();
	// 0~100 사이의 숫자값으로, 50을 기본값으로 나타내고, 2씩 증가 감소시킨다.
	SpinnerNumberModel spinnerNumberModel = new SpinnerNumberModel(50, 0, 100, 2);
	
	public Swing20() {
		// JFrame 설정
		setTitle("Swing20");
		setSize(300, 200);
		setLocation(3300, 300);
		init();
		start();
		setVisible(true);
		
//		for(int i=0; i<str.length; i++) 
//			System.out.println(str[i]);
	}
	private void init() {
		container.setLayout(new BorderLayout());
		container.add("North", panel);
		
		panel.setLayout(new GridLayout(3, 1));
		panel.add(spinner1);
		panel.add(spinner2);
		panel.add(spinner3);
		
		// spinner 설정
		spinner1.setModel(spinnerListModel);
		spinner2.setModel(spinnerDateModel);
		// spiner의 TextField 영역의 편집 금지 기능 설정
		// spiner의 JTextField를 얻어옴
		JTextField textField = ((JSpinner.DateEditor)spinner2.getEditor()).getTextField();
		textField.setEditable(false);  // JTextField 비활성화 설정
		spinner3.setModel(spinnerNumberModel);
		
		System.out.println(spinner1.getValue());
		System.out.println(spinner2.getValue());
		System.out.println(spinner3.getValue());
	}
	private void start() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}

public class Exam20 {
	public static void main(String[] args) {
		new Swing20();
	}
}







