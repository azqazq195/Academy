package aop01;

public class Man {
	public void classwork() {
		// 횡단 (공통) 관심사항
		System.out.println("교실문을 연다");
		
		try {
			// 핵심 관심 사항
			System.out.println("컴퓨터를 켜고 Game을 시작한다.");
		} catch (Exception e) {
			// 횡단 (공통) 관심사항
			System.out.println("** 오늘은 소독하는 날 **");
		} finally {
			// 횡단 (공통) 관심사항
			System.out.println("전등이 켜져 있는 지 확인한다.");
		}
		
		// 횡단 (공통) 관심사항
		System.out.println("교실문을 잠근다.");
	}
}
