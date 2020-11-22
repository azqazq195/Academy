package aop09;
// 핵심 관심 사항으로 구성된 클래스
public class CalcMethod {
	public void sum(int a, int b) {
		System.out.println(a + " + " + b + " = " + (a+b));
	}
	
	public void div(int a, int b) {
		try {
			System.out.println(a + " / " + b + " = " + (a/b));
		} catch (Exception e) {
			System.out.println("0으로 나눌 수 없습니다.");
		}		
	}
}
