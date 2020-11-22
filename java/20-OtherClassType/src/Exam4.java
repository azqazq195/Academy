class Inner4 {
	int x = 40;
	int y = 50;
	public void disp() {
		System.out.println("x=" + x);
	}
	void test() {
		System.out.println("test 함수 호출");
	}
}
// 상속받는 법1 (일반 상속)
class Inner44 extends Inner4 {
	@Override
	public void disp() {
		super.disp();
		System.out.println("y=" + y);
	}
}
public class Exam4 {
	public static void main(String[] args) {
		// 상속받는 법2 (약식 상속)
		Inner4 inner = new Inner4() {
			@Override
			public void disp() {
				super.disp();
				System.out.println("무명 클래스 사용!!!");
			}
		};
		inner.test();
		inner.disp();
		System.out.println("-------------");
		
		// 부모
		Inner4 inner4 = new Inner44();
		inner4.disp();
		System.out.println("-------------");
		// 자식
		Inner44 inner44 = new Inner44();
		inner44.disp();
	}
}
