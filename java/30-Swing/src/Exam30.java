import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/** JFrame에 배경화면 넣기 **/
// JPanel을 하나 생성한 후, JPanel에 배경이미지를 그린후,
// JFrame의 Center에 붙이면된다.
class Swing30 extends JFrame {
	Container container = getContentPane();
	JButton button1 = new JButton("버튼1");
	JButton button2 = new JButton("버튼2");
	JButton button3 = new JButton("버튼3");
	JButton button4 = new JButton("버튼4");
	JButton button5 = new JButton("버튼5");
	JPanel panel;
	
	public Swing30() {
		setTitle("Swing30");
		setSize(600, 500);
		setLocation(3300, 300);
		init();
		start();
		setVisible(true);
	}
	private void init() {		
		// panel 설정
		panel = new JPanel() {
			// panel의 배경 설정
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				Image image = new ImageIcon("img/Dog.gif").getImage();
				g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
				setOpaque(false);  // 투명하게
			}
		};
		
		// frame 구성
		container.setLayout(new BorderLayout());
		container.add("Center", panel);
		// panel 구성
		panel.setLayout(new FlowLayout());
		panel.add(button1);
		panel.add(button2);
		panel.add(button3);
		panel.add(button4);
		panel.add(button5);		
	}
	private void start() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}

public class Exam30 {
	public static void main(String[] args) {
		new Swing30();
	}
}





