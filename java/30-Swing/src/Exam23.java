import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSplitPane;

class Swing23 extends JFrame {
	Container container = getContentPane();
	JLabel label = new JLabel("Test");
	JButton buttonUp = new JButton("위 버튼");
	JButton buttonDown = new JButton("아래 버튼");
	JButton buttonLeft = new JButton("좌측 버튼");
	// JSplitPane(int newOrientation, boolean newContinuousLayout,
	//			  Component newLeftComponent, Component newRightComponent)
	JSplitPane splitPane1 = new JSplitPane(JSplitPane.VERTICAL_SPLIT,
										true, buttonUp, buttonDown);
	JSplitPane splitPane2 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
										true, buttonLeft, splitPane1);
	
	public Swing23() {
		setTitle("Swing23");
		setSize(300, 200);
		setLocation(3300, 300);
		init();
		start();
		setVisible(true);
	}
	private void init() {
		container.setLayout(new BorderLayout());
		container.add("North", label);
		container.add("Center", splitPane2);
		// 아래의 컴포넌트를 다른 컴포넌트로 변경
		JButton buttonDown1 = new JButton("아래1 버튼");
		splitPane1.setBottomComponent(buttonDown1);
	}
	private void start() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}

public class Exam23 {
	public static void main(String[] args) {
		new Swing23();
	}
}




