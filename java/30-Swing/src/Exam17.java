import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

class Swing17 extends JFrame {
	Container container = getContentPane();
	JLabel label = new JLabel("이것은 탭 패인입니다.");
	JButton button1 = new JButton("확인");
	JButton button2 = new JButton("취소");
	JPanel panelButton = new JPanel();
	// 탭
	JPanel panel = new JPanel();
	// 아래쪽에 표시되는 탭 Pane을 선언
	JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP,
											JTabbedPane.SCROLL_TAB_LAYOUT);
	JButton tBtn1 = new JButton("첫번째 Tab");
	JButton tBtn2 = new JButton("두번째 Tab");
	JButton tBtn3 = new JButton("세번째 Tab");
	JButton tBtn4 = new JButton("네번째 Tab");
	JButton tBtn5 = new JButton("다섯번째 Tab");
	
	JPanel panel1 = new JPanel();
	JPanel panel2 = new JPanel();
	JPanel panel3 = new JPanel();
	JPanel panel4 = new JPanel();
	JPanel panel5 = new JPanel();
	
	public Swing17() {
		setTitle("Swing17");
		setSize(300, 200);
		setLocation(3300, 300);
		init();
		start();
		setVisible(true);
	}
	private void init() {
		container.setLayout(new BorderLayout());
		container.add("North", label);
		container.add("Center", panel);
		container.add("South", panelButton);
		// panelButton 구성
		panelButton.setLayout(new FlowLayout(FlowLayout.RIGHT));
		panelButton.add(button1);
		panelButton.add(button2);
		// panel 구성(Tab)
		panel.setLayout(new BorderLayout());
		panel.add("Center", tabbedPane);
		// tabbedPane 구성 (panel)
		panel1.setBackground(Color.YELLOW);
		panel2.setBackground(Color.GRAY);
		panel3.setBackground(Color.GREEN);
		panel4.setBackground(Color.BLUE);
		panel5.setBackground(Color.RED);
		
		tabbedPane.add("Yellow", panel1);
		tabbedPane.add("Gray", panel2);
		tabbedPane.add("Green", panel3);
		tabbedPane.add("Blue", panel4);
		tabbedPane.add("Red", panel5);
		
		// tabbedPane 구성 (button)
//		tabbedPane.add(tBtn1);
//		tabbedPane.add(tBtn2);
//		tabbedPane.add(tBtn3);
//		tabbedPane.add("Title", tBtn4);
//		tabbedPane.addTab("Title2", new ImageIcon("img/middle.gif") ,tBtn5,
//						  "여긴 아이콘이 있습니다.");
	}
	private void start() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
public class Exam17 {
	public static void main(String[] args) {
		new Swing17();
	}
}
