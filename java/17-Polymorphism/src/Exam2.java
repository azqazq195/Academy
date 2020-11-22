
public class Exam2 {
	public static void main(String[] args) {
		// 2. 부모 클래스 기준으로 상속된 클래스 사용하기		
		// 부대 지정
		Unit[] units = new Unit[5];
		
		units[0] = new AirForce("공군1호");
		units[1] = new AirForce("공군2호");
		units[2] = new Navy("해군1호");
		units[3] = new Army("육군1호");
		units[4] = new Army("육군2호");
		// 부대 일괄 공격
		for(int i=0; i<units.length; i++) {
			units[i].attack();
			
			if(units[i] instanceof Army) {
				Army army = (Army)units[i];
				army.tank();				
			} else if(units[i] instanceof Navy) {
				Navy navy = (Navy)units[i];
				navy.nucleus();
			} else if(units[i] instanceof AirForce) {
				AirForce airForce = (AirForce) units[i];
				airForce.bombing();
			}
		}
	}
}











