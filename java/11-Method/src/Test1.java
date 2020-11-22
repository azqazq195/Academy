import java.util.Scanner;

public class Test1 {
	static int input() {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 입력 : ");
		int n = sc.nextInt();
		return n;
	}
	static int plus(int a, int b) {
		return a + b;
	}
	static void output(int a, int b, int c) {
		System.out.println(a + " + " + b + " = " + c);
	}
	public static void main(String[] args) {
		// 선언 : 데이터를 저장할 변수만들기
		int a, b, c;
		// 입력 : 변수에 데이터 저장하기
		a = input();
		b = input();
		// 연산 : 저장된 데이터 가공하기
		c = plus(a, b);
		// 출력 : 결과 확인하기
		output(a, b, c);
	}
}
