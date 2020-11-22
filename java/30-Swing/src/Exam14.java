import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JList;

class Swing14 extends JFrame {
	Container container = getContentPane();
	String[] str = {"AAA", "BBB", "CCC", "DDD", "EEE"};
	JList<String> list = new JList<String>(str);
	
	public Swing14() {
		setTitle("Swing14");
		setSize(300, 200);
		setLocation(2300, 300);
		init();
		start();
		setVisible(true);
		
		showChange();
	}
	private void showChange() {
		// 두번째~네번째 선택
		list.addSelectionInterval(1,  3);
		// 2초 지연
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// 선택 영역 해제
		list.clearSelection();
		// 2초 지연
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// 내용 바꾸기
		String[] str1 = {"aaa", "bbb", "ccc", "ddd", "eee"};
		list.setListData(str1);
		list.setSelectionBackground(Color.RED);
		list.setSelectionForeground(Color.YELLOW);
		list.setSelectedIndex(3);
	}
	private void init() {
		container.setLayout(new FlowLayout());
		container.add(list);
	}
	private void start() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
public class Exam14 {
	public static void main(String[] args) {
		new Swing14();
	}
}





