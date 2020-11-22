import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

class Swing01 extends JFrame {
	// 타이틀 바의 이미지를 가지는 객체
	ImageIcon imageIcon = new ImageIcon("img/Bird.gif");
	
	public Swing01() {
		// JFrame 설정
		this.setTitle("Swing01");	// 타이틀
		this.setIconImage(imageIcon.getImage()); // 타이틀 바에 이미지 넣기
		this.setSize(300, 200);
		// 모니터 한가운데 위치 지정
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension dim1 = toolkit.getScreenSize();  	// 모니터의 크기
		Dimension dim2 = this.getSize();			// 프로그램 창의 크기
		int x = (int)(dim1.getWidth()/2 - dim2.getWidth()/2);
		int y = (int)(dim1.getHeight()/2 - dim2.getHeight()/2);
		this.setLocation(x, y);
		
		init(); 	// 화면 구성
		start();	// 이벤트 설정
		
		this.setVisible(true);
	}
	private void init() {
		
	}
	private void start() {
		// x 버튼 이벤트 설정
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}

public class Exam01 {
	public static void main(String[] args) {
		new Swing01();
	}
}





