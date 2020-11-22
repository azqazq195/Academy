import java.util.Scanner;

class BBB {
	Scanner sc = new Scanner(System.in);
	// 선언 : 데이터를 저장할 변수 만들기
	int a, b, c;
	// 입력 : 변수에 데이터 저장하기
	void input() {
		System.out.print("정수 입력 : ");
		a = sc.nextInt();
		System.out.print("정수 입력 : ");
		b = sc.nextInt();
	}
	// 연산 : 저장된 데이터 가공하기
	void plus() {
		c = a + b;
	}			
	// 출력 : 결과값 확인하기
	void output() {
		System.out.println(a + " + " + b + " = " + c);
	}
}
public class Test1 {
	public static void main(String[] args) {
		BBB bb = new BBB();
		bb.input();
		bb.plus();
		bb.output();
	}
}



