import java.util.Scanner;
// user 자료형 : 사용자가 만든 새로운 자료형
class AAA2 {
	// 선언 : 정수, 실수, 문자, 문자열, boolean, 배열, 객체
	int a, b, c;
	Scanner sc = new Scanner(System.in);
	// 입력
	void input() {
		System.out.print("정수 입력 : ");
		a = sc.nextInt();
		System.out.print("정수 입력 : ");
		b = sc.nextInt();
	}
	// 연산
	void plus() {
		c = a + b;
	}
	// 출력
	void output() {
		System.out.println(a + " + " + b + " = " + c);
	}
}

public class Test2 {
	public static void main(String[] args) {
		// 선언 : 정수, 실수, 문자, 문자열, boolean, 배열, 객체
		// 자료형 변수명;
		AAA2 aa;
		aa = new AAA2();
		// 입력
		aa.input();
		// 연산
		aa.plus();
		// 출력
		aa.output();
	}
}
