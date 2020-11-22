
public class Exam1 {
	public static void main(String[] args) {
		// 자식 클래스 기준 (기본 방법)
		Army army = new Army("육군");
		army.move();
		army.attack();
		
		Navy navy = new Navy("해군");
		navy.move();
		navy.attack();
		
		AirForce airForce = new AirForce("공군");
		airForce.move();
		airForce.attack();
		
		System.out.println("--------------------");
		
		// 부모 클래스 기준 (다형성 방법)
		Unit unit = new Army("육군");
		unit.move();
		unit.attack();
		
		unit = new Navy("해군");
		unit.move();
		unit.attack();
		
		unit = new AirForce("공군");
		unit.move();
		unit.attack();	
		System.out.println("--------------------");
		
		// 부모 클래스 기준 : 객체 배열
		Unit[] units = new Unit[3];
		units[0] = new Army("육군");
		units[1] = new Navy("해군");
		units[2] = new AirForce("공군");
		
		for(int i=0; i<units.length; i++) {
			units[i].move();
			units[i].attack();
		}
		
	}
}









