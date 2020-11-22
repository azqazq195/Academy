import java.util.Scanner;

public class Practice5 {
	static String input_name() {
		Scanner sc = new Scanner(System.in);
		System.out.print("품명을 입력하세요 : ");
		String name = sc.next();
		return name;
	}
	static int input_num(String str) {
		Scanner sc = new Scanner(System.in);
		System.out.print(str + "을(를) 입력하세요 : ");
		int num = sc.nextInt();
		return num;
	}
	static int compute(int num, int price) {
		return num * price;
	}
	static void output(String name, int totalMoney) {
		System.out.println("품명 : " + name);
		System.out.println("총액 : " + totalMoney);
	}
	public static void main(String[] args) {
		// 선언
		String name = "";  	// 품명
		int num = 0;		// 수량
		int price = 0;		// 가격
		int totalMoney = 0;	// 총액
		// 입력
		name = input_name();
		num = input_num("수량");
		price = input_num("단가");
		// 연산
		totalMoney = compute(num, price);
		// 출력
		output(name, totalMoney);
	}
}
