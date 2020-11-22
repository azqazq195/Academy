
public class Exam2 {
	public static void main(String[] agrs) {
		// 일반 변수
		int width = 100;
		// 상수형 변수
		final double PI = 3.14;
		System.out.println("width = " + width);
		System.out.println("PI = " + PI);
		
		width = 200;
		System.out.println("width = " + width);
		//PI = 3.141592;   // error, final 변수는 값 변경 불가
	}
}
