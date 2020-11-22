import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.SwingConstants;

class Swing02 extends JFrame implements MouseListener {
	// getContentPane() : JFrame 4개 영역 중에서 ContentPane을 얻어옴
	Container container = getContentPane();
	ImageIcon icon1 = new ImageIcon("img/cat.gif");
	ImageIcon icon2 = new ImageIcon("img/pig.gif");
	ImageIcon icon3 = new ImageIcon("img/dog.gif");
	
	JButton button1 = new JButton("String");
	JButton button2 = new JButton(icon1);
	JButton button3 = new JButton("Str & Icon", icon1);
	
	JDialog dialog = new JDialog();
	
	public Swing02() {
		// JFrame 설정
		this.setTitle("Swing02");
		this.setSize(500, 200);
		this.setLocation(2300, 300);
		
		init();
		start();
		
		this.setVisible(true);
	}
	private void init() {
		// JFrame 구성
		container.setLayout(new FlowLayout());
		container.add(button1);
		container.add(button2);
		container.add(button3);
		
		// button1 비활성화
		button1.setEnabled(false);
		// button2 단축키 지정 (alt + a)
		button2.setMnemonic('a');
		/* button3 설정 */
		// Text 위치 지정
		button3.setHorizontalTextPosition(SwingConstants.LEFT);
		button3.setVerticalTextPosition(SwingConstants.TOP);
		button3.setMnemonic('b');
		// 마우스로 눌렀을 때의 이미지 변화
		button3.setPressedIcon(icon2);
		// 마우스로 올렸을 때의 이미지 변화
		button3.setRolloverIcon(icon3);
	}
	private void start() {		
		// x 버튼
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		// 버튼 이벤트 설정
		button2.addMouseListener(this);
		button3.addMouseListener(this);
		// dialog x 버튼
		dialog.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				super.windowClosing(e);
				dialog.dispose();
			}
		});
	}

	@Override
	public void mouseClicked(MouseEvent e) { // press + release
		if(e.getSource() == button2) {
			dialog.setTitle("버튼 2");
			dialog.setLocation(2400, 500);
			dialog.setVisible(true);
		} else if(e.getSource() == button3) {
			dialog.setTitle("버튼 3 clicked");
			dialog.setLocation(2600, 500);
			dialog.setVisible(true);
		}
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		if(e.getSource() == button3) {
			dialog.setTitle("버튼 3 entered");
			dialog.setLocation(2600, 500);
			dialog.setVisible(true);
		}
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		
	}
	@Override
	public void mousePressed(MouseEvent arg0) {
		
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		
	}
}
public class Exam02 {
	public static void main(String[] args) {
		new Swing02();
	}
}







