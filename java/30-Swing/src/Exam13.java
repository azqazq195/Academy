import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.beans.PropertyVetoException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;

class Swing13 extends JFrame {
	Container container = getContentPane();
	JPanel panel = new JPanel();
	JInternalFrame internalFrame = new JInternalFrame("제목", true, true, true, true);
	JButton button1 = new JButton("1");
	JButton button2 = new JButton("2");
	
	public Swing13() {
		// JFrame 설정
		setTitle("Swing13");
		setSize(300, 200);
		setLocation(300, 300);
		
		init();
		start();
		
		setVisible(true);
	}
	private void init() {
		// frame 구성
		container.setLayout(new BorderLayout());
		container.add("West", button1);
		container.add("Center", panel);
		container.add("South", button2);
		// panel 구성
		panel.setLayout(new BorderLayout());
		panel.add("Center", internalFrame);
		// internalFrame 구성
		Container interContainer = internalFrame.getContentPane();
		interContainer.setLayout(new FlowLayout());
		interContainer.add(new JButton("3"));
		interContainer.add(new JButton("4"));
		internalFrame.setFrameIcon(new ImageIcon("img/cat.gif"));
		try {
			internalFrame.setMaximum(true);  // 기본적으로 최대 크기로 보여줌 설정
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}
		internalFrame.setSize(100, 80);
		internalFrame.setVisible(true);		
	}
	private void start() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
public class Exam13 {
	public static void main(String[] args) {
		new Swing13();
	}
}





