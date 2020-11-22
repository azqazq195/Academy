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

class PanelForm extends Frame implements ActionListener {
	Button button1 = new Button("button1");
	Button button2 = new Button("button2");
	GridLayout gridLayout = new GridLayout(1, 2);
	BorderLayout borderLayout = new BorderLayout();
	Panel panel = new Panel();
	
	public PanelForm() {
		// Frame 설정
		setTitle("Panel"); 
		setSize(300, 200);
		setLocation(300, 300);
		
		init();
		start();
		
		setVisible(true);
	}
	private void init() {
		// Frame 화면 구성
		setLayout(borderLayout);
		add("South", panel);
		// Panel 화면 구성
		panel.setLayout(gridLayout);
		panel.add(button1);
		panel.add(button2);
		// button 설정
		button1.setBackground(Color.YELLOW);
		button2.setBackground(Color.GREEN);
	}
	private void start() {
		button1.addActionListener(this);
		button2.addActionListener(this);
		// x버튼 종료 처리
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
		Dialog dialog = new Dialog(this);
		dialog.setLocation(400, 400);
		
		if(e.getSource() == button1) {
			dialog.setTitle("버튼1");
			dialog.setVisible(true);
		} else if(e.getSource() == button2) {
			dialog.setTitle("버튼2");
			dialog.setVisible(true);
		}
		// 대화상자 x버튼 종료 이벤트 설정
		dialog.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				super.windowClosing(e);
				dialog.dispose();
			}
		});
	}
}
public class Exam6 {
	public static void main(String[] args) {
		PanelForm panelForm = new PanelForm();
	}
}








