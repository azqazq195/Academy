import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JToolBar;

class SwingPrac2 extends JFrame implements ActionListener {
	Container container = getContentPane();
	// JToolBar 영역
	JToolBar toolBar = new JToolBar();
	JButton button1 = new JButton("1번");
	JButton button2 = new JButton(new ImageIcon("img/middle.gif"));
	JButton button3 = new JButton("3번");
	JButton button4 = new JButton("4번");
	// JTabbedPane 영역
	JTabbedPane tabbedPane = new JTabbedPane();
	JPanel panel1 = new JPanel();
	JPanel panel2 = new JPanel();
	JPanel panel3 = new JPanel();
	JPanel panel4 = new JPanel();
	
	public SwingPrac2() {
		setTitle("SwingPrac2");
		setSize(350, 250);
		setLocation(3300, 300);
		init();
		start();
		setVisible(true);
	}
	private void init() {
		container.setLayout(new BorderLayout());
		container.add("North", toolBar);
		container.add("Center", tabbedPane);
		// toolBar 구성
		toolBar.add(button1);
		toolBar.addSeparator();
		toolBar.add(button2);
		toolBar.addSeparator();
		toolBar.add(button3);
		toolBar.add(button4);
		
		// tabbedPane 구성
		tabbedPane.add("1번 채널", panel1);
		tabbedPane.add("2번 채널", panel2);
		tabbedPane.add("3번 채널", panel3);
		tabbedPane.add("4번 채널", panel4);
		// panel 설정
		panel1.setBackground(Color.BLACK);
		panel2.setBackground(Color.RED);
		panel3.setBackground(Color.GREEN);
		panel4.setBackground(Color.BLUE);
	}
	private void start() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		// button 이벤트 설정
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		button4.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == button1) {
			tabbedPane.setSelectedIndex(0);
		} else if(e.getSource() == button2) {
			tabbedPane.setSelectedIndex(1);
		} else if(e.getSource() == button3) {
			tabbedPane.setSelectedIndex(2);
		} else if(e.getSource() == button4) {
			tabbedPane.setSelectedIndex(3);
		}  
	}
}
public class Practice2 {
	public static void main(String[] args) {
		new SwingPrac2();
	}
}







