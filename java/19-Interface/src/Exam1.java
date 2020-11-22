
public class Exam1 {
	public static void main(String[] args) {
		// 자식 클래스 기준
		Character ch = new Character("주인공");
		ch.walk();
		ch.run();
		ch.attack();
		ch.shield();
		System.out.println("-------------");
		
		Monster mon = new Monster("악당");
		mon.walk();
		mon.run();
		mon.attack();
		mon.shield();
		System.out.println("-------------");
		
		// 부모 클래스 기준
		Move move = new Character("주인공");
		move.walk();
		move.run();		
		Fight fight = (Character)move;
		fight.attack();
		fight.shield();
		System.out.println("-------------");
		Move move2 = new Monster("악당");
		move2.walk();
		move2.run();
		Fight fight2 = (Monster)move2;
		fight2.attack();
		fight2.shield();
	}
}












