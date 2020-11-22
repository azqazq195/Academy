import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

class Swing27 extends JFrame implements MouseListener{
	Container container = getContentPane();
	JPanel panel1 = new JPanel();
	JPanel panel2 = new JPanel();
	
	public Swing27() {
		setTitle("Swing27");
		setSize(300, 200);
		setLocation(3300, 300);
		init();
		start();
		setVisible(true);
	}
	private void init() {
		container.setLayout(new BorderLayout());
		container.add("Center", panel1);
		
		// panel 설정
		panel1.setBackground(Color.RED);
		panel2.setBackground(Color.BLUE);
	}
	private void start() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		// panel 이벤트 설정
		panel1.addMouseListener(this);
		panel2.addMouseListener(this);
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource() == panel1) {
			container.remove(panel1); 
			container.invalidate();
			container.add("Center", panel2);
			container.revalidate();
			container.repaint();
		} else if(e.getSource() == panel2) {
			container.remove(panel2); 
			container.invalidate();
			container.add("Center", panel1);
			container.revalidate();
			container.repaint();
		}
	}
	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}
	@Override
	public void mousePressed(MouseEvent e) {}
	@Override
	public void mouseReleased(MouseEvent e) {}	
}

class Swing277 extends JFrame implements MouseListener{
	Container container = getContentPane();
	JPanel panel1 = new JPanel();
	JPanel panel2 = new JPanel();
	CardLayout cardLayout = new CardLayout();
	
	public Swing277() {
		setTitle("Swing277");
		setSize(300, 200);
		setLocation(3300, 300);
		init();
		start();
		setVisible(true);
	}
	private void init() {
		container.setLayout(cardLayout);
		container.add(panel1, "red");
		container.add(panel2, "blue");
		
		// panel 설정
		panel1.setBackground(Color.RED);
		panel2.setBackground(Color.BLUE);
	}
	private void start() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		// panel 이벤트 설정
		panel1.addMouseListener(this);
		panel2.addMouseListener(this);
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource() == panel1) {
			cardLayout.show(container, "blue");
		} else if(e.getSource() == panel2) {
			cardLayout.show(container, "red");
		}
	}
	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}
	@Override
	public void mousePressed(MouseEvent e) {}
	@Override
	public void mouseReleased(MouseEvent e) {}	
}


public class Exam27 {
	public static void main(String[] args) {
		new Swing277();
	}
}










