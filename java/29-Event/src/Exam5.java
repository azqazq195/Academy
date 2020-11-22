import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class BaseForm extends Frame implements ActionListener {
	// 컴포넌트 선언
	Button button1 = new Button("button1");
	Button button2 = new Button("button2");
	Button button3 = new Button("button3");
	// FlowLayout : 컴포넌트를 왼쪽에서 오른쪽으로 배치
	FlowLayout flowLayout = new FlowLayout();
	// GridLayout : 컴포넌트를 행열로 배치
	// GridLayout(행의 수, 열의 수, 가로여백, 세로여백)
	GridLayout gridLayout = new GridLayout(2, 2, 5, 5);
	// BorderLayout : 컴포넌트를 동서남북으로 배치
	BorderLayout borderLayout = new BorderLayout();
	
	public BaseForm() {
		// button 설정
		button1.setBackground(Color.YELLOW);
		button2.setBackground(Color.GREEN);
		button3.setBackground(Color.CYAN);
		// Frame 설정
		setTitle("Layout Manager"); // 윈도우 창의 제목 설정
		setSize(300, 200); 			// 윈도우 창의 크기 설정
		setLocation(300, 300); 		// 윈도우 창의 위치 설정 (모니터 기준)
		
		init3();		// 화면 구성
		start();	// 이벤트 처리
		
		setVisible(true);			// 윈도우 창 보이기
	}	
	// 화면 구성 : FlowLayout
	private void init() {
		setLayout(flowLayout);
		add(button1);
		add(button2);
		add(button3);
	}
	// 화면 구성 : GridLayout
	private void init2() {
		setLayout(gridLayout);
		add(button1);
		add(button2);
		add(button3);
	}
	// 화면 구성 : BorderLayout
	private void init3() {
		setLayout(borderLayout);
		add("North", button1);
		add("Center", button2);
		add("South", button3);
	}
	private void start() {
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		
		// 프레임 창의 x버튼 종료처리
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				super.windowClosing(e);
				System.exit(0); 
			}
		});
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// 대화상자
		Dialog dialog = new Dialog(this);
		dialog.setLocation(400, 400);  // 대화상자 위치 지정 (모니터 기준)
		
		if(e.getSource() == button1) {  // button1 클릭
			dialog.setTitle("버튼1");
			dialog.setVisible(true);
		} else if(e.getSource() == button2) {  // button2 클릭
			dialog.setTitle("버튼2");
			dialog.setVisible(true);
		} else if(e.getSource() == button3) {  // button3 클릭
			dialog.setTitle("버튼3");
			dialog.setVisible(true);
		}  
		// 대화상자의 x버튼 클릭 이벤트
		dialog.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				super.windowClosing(e);
				dialog.dispose();   // Dialog 창 닫기
			}
		});
	}
}

public class Exam5 {
	public static void main(String[] args) {
		BaseForm baseForm = new BaseForm();
	}
}








