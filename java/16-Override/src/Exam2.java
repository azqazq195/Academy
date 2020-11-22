
public class Exam2 {
	public static void main(String[] args) {
		// 1. 자식 클래스 기준으로 상속된 클래스 사용하기
		Army army = new Army("육군");
		Navy navy = new Navy("해군");
		AirForce airForce = new AirForce("공군");
		
		army.attack();
		army.tank();
		
		navy.attack();
		navy.nucleus();
		
		airForce.attack();
		airForce.bombing();
	}
}
