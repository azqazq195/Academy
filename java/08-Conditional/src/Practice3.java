import java.util.Scanner;

public class Practice3 {
	static int input() {
		Scanner sc = new Scanner(System.in);
		System.out.print("주민번호 7번째 자리를 입력하세요 : ");
		int num = sc.nextInt();
		return num;
	}
	static void output(int num) {
		if(num == 1) {
			System.out.println("당신은 1900년대 남성입니다.");
		} else if(num == 2) {
			System.out.println("당신은 1900년대 여성입니다.");
		} else if(num == 3) {
			System.out.println("당신은 2000년대 남성입니다.");
		} else if(num == 4) {
			System.out.println("당신은 2000년대 여성입니다.");
		} else {
			System.out.println("숫자를 1~4 사이로 입력하세요");
		}
	}
	public static void main(String[] args) {
		// 선언 : 변수 만들기
		int num = 0;
		// 입력 : 변수에 데이터 저장하기
		num = input();
		// 연산 : 저장된 데이터 가공하기
		// 출력 : 결과값 확인하기
		output(num);			
	}
}
