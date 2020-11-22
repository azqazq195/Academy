import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

class Swing04 extends JFrame {
	Container container = getContentPane();	
	JPanel panelNorth = new JPanel();
	JPanel panelCenter = new JPanel();
	JPanel panelWest = new JPanel();
	JPanel panelEast = new JPanel();
	JPanel panelSouth = new JPanel();
	
	JLabel labelTitle = new JLabel("", JLabel.CENTER);
	JButton button1 = new JButton();
	JButton button2 = new JButton("인사과");
	JButton button3 = new JButton("총무과");
	JButton button4 = new JButton("서무과");
	JButton button5 = new JButton("경리과");
	JButton button6 = new JButton("컴퓨터");
	JButton button7 = new JButton("핸드폰");
	JButton button8 = new JButton("안경");
	
	public Swing04() {
		// JFrame 설정
		setTitle("Swing04");
		setSize(500, 300);
		setLocation(2300, 300);
		
		init();
		start();
		
		setVisible(true);
	}
	private void init() {
		// JFrame 구성
		container.setLayout(new BorderLayout());
		container.add("North", panelNorth);
		container.add("Center", panelCenter);
		container.add("West", panelWest);
		container.add("East", panelEast);
		container.add("South", panelSouth);
		// panelNorth 구성
		panelNorth.setLayout(new BorderLayout());
		panelNorth.setBorder(new TitledBorder("Title Label"));
		panelNorth.add("Center", labelTitle);		
		labelTitle.setFont(new Font("궁서체", Font.BOLD, 24));
		labelTitle.setText("BorderLayout");
		// panelCenter 구성
		panelCenter.setLayout(new FlowLayout());
		panelCenter.setBorder(new TitledBorder("Center"));
		panelCenter.add(button2);
		panelCenter.add(button3);
		panelCenter.add(button4);
		panelCenter.add(button5);
		// panelWest 구성
		panelWest.setLayout(new FlowLayout());
		panelWest.setBorder(new TitledBorder("West"));
		panelWest.add(button1);
		button1.setText("Add");
		// panelEast 구성
		panelEast.setLayout(new GridLayout(3, 1));
		panelEast.setBorder(new TitledBorder("East"));
		panelEast.add(button6);
		panelEast.add(button7);
		panelEast.add(button8);
		// panelSouth 구성
		panelSouth.setBorder(new TitledBorder("South"));
	}
	private void start() {
		// x button
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
public class Exam04 {
	public static void main(String[] args) {
		new Swing04();
	}
}







