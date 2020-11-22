import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class PracForm1 extends Frame implements ActionListener {
	Button button1 = new Button("test");
	Button button2 = new Button("test1");
	Button button3 = new Button("test2");
	BorderLayout borderLayout = new BorderLayout();
	GridLayout gridLayout1 = new GridLayout(1, 2);
	GridLayout gridLayout2 = new GridLayout(2, 1);
	Panel panel1 = new Panel();
	Panel panel2 = new Panel();
	Dialog dialog = new Dialog(this);
	
	public PracForm1() {
		// Frame 설정
		setTitle("Panel 연습");
		setSize(300, 300);
		setLocation(300, 300);
		
		init();
		start();
		
		setVisible(true);
	}	
	private void init() {
		// top down 방식    (, bottom up 방식)
		// Frame 화면 설정
		setLayout(borderLayout);
		add("South", panel1);
		
		// panel1 화면 설정
		panel1.setLayout(gridLayout1);  // (1행, 2열)
		panel1.add(button1);
		panel1.add(panel2);
		// panel2 화면 설정
		panel2.setLayout(gridLayout2);  // (2행, 1열)
		panel2.add(button2);
		panel2.add(button3);
		// 버튼 설정
		button1.setBackground(Color.YELLOW);
		button2.setBackground(Color.MAGENTA);
		button3.setBackground(Color.GREEN);
		// 대화상자 설정
		dialog.setLocation(400, 400);
	}
	private void start() {
		// button event (일반 상속으로 이벤트 처리)
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		// x버튼 이벤트
		super.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				super.windowClosing(e);
				System.exit(0);
			}
		});
		// 대화상자 x버튼 이벤트 
		dialog.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				super.windowClosing(e);
				dialog.dispose();  // 대화상자 창 닫기
			}
		});
	}
	@Override
	public void actionPerformed(ActionEvent e) {		
		if(e.getSource() == button1) {
			dialog.setTitle("test");
			dialog.setVisible(true);
		} else if(e.getSource() == button2) {
			dialog.setTitle("test1");
			dialog.setVisible(true);
		} else if(e.getSource() == button3) {
			dialog.setTitle("test2");
			dialog.setVisible(true);
		} 		
	}	
}
public class Practice1 {
	public static void main(String[] args) {
		PracForm1 pracForm1 = new PracForm1();
	}
}







