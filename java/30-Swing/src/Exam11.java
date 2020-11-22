import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

class Swing11 extends JFrame {
	Container container = getContentPane();
	JLabel label = new JLabel("메모장", JLabel.CENTER);
	JButton button1 = new JButton("확인");
	JButton button2 = new JButton("취소");
	JTextArea textArea = new JTextArea();
	JScrollPane scrollPane = new JScrollPane(textArea);
	JPanel panelButton = new JPanel();
	
	public Swing11() {
		// JFrame 설정
		setTitle("Swing11");
		setSize(300, 200);
		setLocation(300, 300);
		
		init();
		start();
		
		setVisible(true);
	}
	private void init() {
		// JFrame 구성
		container.setLayout(new BorderLayout());
		container.add("North", label);
		container.add("Center", scrollPane);
		container.add("South", panelButton);
		// panelButton 구성
		panelButton.setLayout(new FlowLayout(FlowLayout.RIGHT));
		panelButton.add(button1);
		panelButton.add(button2);
		// TextArea 기능 설정
		textArea.setDragEnabled(true);  // 드래그 기능 활성화
		textArea.setFocusAccelerator('r');   // alt + r : 마지막 커서 위치로 이동
		textArea.setSelectedTextColor(Color.RED);  // 선택된 영역의 글자 색상 설정
		textArea.setSelectionColor(Color.YELLOW);  // 선택된 영역의 배경 색상 설정
		
		scrollPane.setWheelScrollingEnabled(true); // 마우스 휠로 스크롤 가능 설정
	}
	private void start() {
		// x button
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		// textArea 이벤트 처리
		textArea.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount() == 2) {  // 더블 클릭 인식
					textArea.paste();  // 붙여넣기					
				}
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				if(e.isPopupTrigger()) { // 오른쪽 마우스 키를 눌렀음을 인식
					textArea.copy();					
				}
			}
		});
	}
}

public class Exam11 {
	public static void main(String[] args) {
		new Swing11();
	}
}









