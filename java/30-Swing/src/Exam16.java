import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

class Swing16 extends JFrame {
	Container container = getContentPane();
	JLabel label = new JLabel("메모를 하십시요");
	JTextArea textArea = new JTextArea();
	JScrollPane scrollPane = new JScrollPane(textArea);
	// 팝업창
	JPopupMenu popupMenu = new JPopupMenu();
	JMenuItem menuItem1 = new JMenuItem("복사");
	JMenuItem menuItem2 = new JMenuItem("붙여넣기");
	JMenuItem menuItem3 = new JMenuItem("잘라내기");
	
	public Swing16() {
		setTitle("Swing16");
		setSize(300, 200);
		setLocation(3300, 300);
		init();
		start();
		setVisible(true);
	}
	private void init() {
		container.setLayout(new BorderLayout());
		container.add("North", label);
		container.add("Center", scrollPane);
		// 팝업창 구성
		popupMenu.add(menuItem1);
		popupMenu.addSeparator();
		popupMenu.add(menuItem2);
		popupMenu.addSeparator();
		popupMenu.add(menuItem3);
	}
	private void start() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		// textArea 이벤트 설정
		textArea.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				// 팝업 띄우기
				if(e.isPopupTrigger()) { // 오른쪽 마우스 버튼
					popupMenu.show(textArea, e.getX(), e.getY());					
				}
			}
		});
		// 팝업 메뉴 이벤트 처리
		menuItem1.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				textArea.copy();
			}
		});
		menuItem2.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				textArea.paste();
			}
		});
		menuItem3.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				textArea.cut();
			}
		});
	}
}

public class Exam16 {
	public static void main(String[] args) {
		new Swing16();
	}
}





