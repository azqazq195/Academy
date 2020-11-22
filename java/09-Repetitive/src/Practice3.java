import java.util.Scanner;

public class Practice3 {
	static int input_dan() {
		Scanner sc = new Scanner(System.in);
		System.out.print("몇 단을 출력할 지 입력하세요 : ");
		int dan = sc.nextInt();
		return dan;
	}
	static void output_gugudan(int dan) {
		for(int x=1; x<=9; x++) {
			System.out.printf("%d * %d = %d\n", dan, x, dan*x);
		}
	}
	static void is_continue() {
		Scanner sc = new Scanner(System.in);
		System.out.print("선택하세요(y:계속) : ");
		String str = sc.next();
		if(!(str.equals("y") || str.equals("Y"))) {
			System.out.println("종료합니다.");
			System.exit(0);   // 프로그램 종료 명령어
		}
	}
	public static void main(String[] args) {		
		// 선언
		int dan = 0;  		// 구구단의 단 저장
		while(true) {
			// 입력
			dan = input_dan();
			// 연산, 출력
			output_gugudan(dan);
			// 계속 여부 선택
			is_continue();
		}
	}
}
