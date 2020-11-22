import java.util.Scanner;

public class Practice3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 선언
		int money = 0;	// 금액
		int chun = 0;
		int baek = 0;
		int ten = 0;
		int one = 0;
		int namugy = 0; // 나머지
		// 입력
		System.out.print("금액 입력 : ");
		money = sc.nextInt();
		
		// 연산
		chun = money / 1000;   // 천원이 몇장인 지 저장
		namugy = money % 1000; // 천원 단위를 뺀 나머지 값 저장
		baek = namugy / 100;
		namugy = namugy % 100; 
		ten = namugy / 10;
		one = namugy % 10;
		// 출력
		System.out.println("--------------------");
		System.out.println("금액 : " + money + "원");
		System.out.println("천원 : " + chun + "장");
		System.out.println("백원 : " + baek + "개");
		System.out.println("십원 : " + ten + "개");
		System.out.println("일원 : " + one + "개");
	}
}




