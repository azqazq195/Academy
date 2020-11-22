import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

class Swing25 extends JFrame {
	Container container = getContentPane();
	String[] str = {"1번", "2번", "3번", "4번"};
	// 제목으로 str배열을 배정, 5행으로 데이터가 들어갈 영역 설정
	DefaultTableModel defaultTableModel = new DefaultTableModel(str, 5);
	// TableModel을 기준으로 JTable 객체 생성
	JTable table = new JTable(defaultTableModel);
	// 스크롤 처리를 위해 JScrollPane에 테이블을 담는다.
	JScrollPane scrollPane = new JScrollPane(table);
	
	JLabel label = new JLabel("JTable!!!");
	JButton button1 = new JButton("확인");
	JButton button2 = new JButton("취소");
	
	JPanel panel = new JPanel();
	
	public Swing25() {
		setTitle("Swing25");
		setSize(300, 300);
		setLocation(300, 300);
		init();
		start();
		setVisible(true);
	}
	private void init() {
		container.setLayout(new BorderLayout());
		container.add("North", label);
		container.add("Center", scrollPane);
		container.add("South", panel);
		// panel 구성
		panel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		panel.add(button1);
		panel.add(button2);
		
		// 3행 3열의 위치에 문자열 추가
		defaultTableModel.setValueAt("Test", 2, 2);
		// 값 읽어오기
		String result = (String)defaultTableModel.getValueAt(2, 2);
		System.out.println(result);
	}
	private void start() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}

public class Exam25 {
	public static void main(String[] args) {
		new Swing25();
	}
}


