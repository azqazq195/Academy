class Outer1 {
	// 멤버 변수
	private int x = 10;
	Inner1 inner1 = new Inner1();
	// 멤버 함수
	void ex() {
		inner1.output();
	}
	void test() {
		System.out.println("test");
	}
	
	// inner 클래스
	class Inner1 {
		int y=20;
		void output() {
			test();
			System.out.println("x = " + x);
			System.out.println("y = " + y);
		}
	}
}
public class Exam1 {
	public static void main(String[] args) {
		Outer1 outer1 = new Outer1();
		outer1.ex();
	}
}
