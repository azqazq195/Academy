import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;

class Swing03 extends JFrame {
	Container container = getContentPane();
	JButton button1 = new JButton("Empty");
	JButton button2 = new JButton("Line");
	JButton button3 = new JButton("Etched");
	JButton button4 = new JButton("Bevel");
	JButton button5 = new JButton("SoftBevel");
	JButton button6 = new JButton("Matte");
	JButton button7 = new JButton("Titled");
	JButton button8 = new JButton("Compound");
	
	public Swing03() {
		// JFrame 설정
		setTitle("Swing03");
		setSize(300, 300);
		setLocation(2300, 300);
		
		init();
		start();
		
		setVisible(true);
	}
	private void init() {
		container.setLayout(new GridLayout(4, 2, 3, 3));
		container.add(button1);
		container.add(button2);
		container.add(button3);
		container.add(button4);
		container.add(button5);
		container.add(button6);
		container.add(button7);
		container.add(button8);
		
		// EmptyBorder : Label 처럼 평면 형태를 보여줌
		button1.setBorder(new EmptyBorder(50, 10, 50, 10));
		// LineBorder : 컴포넌트 주위에 라인을 표현
		button2.setBorder(new LineBorder(Color.RED, 3));
		// EtchedBorder : 컴포넌트 주위에 홈 표현
		button3.setBorder(new EtchedBorder());
		// BevelBorder : 컴포넌트가 올라오거나 내려간 모양을 표현
		button4.setBorder(new BevelBorder(BevelBorder.RAISED));
		// SoftBevelBorder : BevelBorder와 비슷
		button5.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
		// MatteBorder : 테두리의 두께를 설정
		button6.setBorder(new MatteBorder(5, 10, 15, 20, Color.BLUE));
		// TitleBorder : 컴포넌트 주위로 제목을 표현
		button7.setBorder(new TitledBorder("제목"));
		// CompoundBorder : 두가지 이상의 보더 효과를 동시에 줄 수 있다.
		SoftBevelBorder softBevelBorder = new SoftBevelBorder(SoftBevelBorder.RAISED);
		TitledBorder titledBorder = new TitledBorder("제목");
		button8.setBorder(new CompoundBorder(softBevelBorder, titledBorder));
	}
	private void start() {
		// x button
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
public class Exam03 {
	public static void main(String[] args) {
		new Swing03();
	}
}







