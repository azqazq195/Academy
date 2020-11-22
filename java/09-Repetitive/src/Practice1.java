import java.util.Scanner;

public class Practice1 {
	static int input() {
		Scanner sc = new Scanner(System.in);
		System.out.print("1~100 사이의 배수를 구할 숫자 입력 : ");
		int num = sc.nextInt();
		return num;
	}
	static int calc_count(int num) {
		int cnt=0;
		for(int a=1; a<=100; a++) {
			if(a%num == 0) {
				System.out.print(a + " ");
				cnt++;
			}
		}
		return cnt;
	}
	static void output(int num, int cnt) {
		System.out.println();
		System.out.println("1~100 사이의 " + num + "의 배수 개수 = " + cnt);
	}
	public static void main(String[] args) {		
		// 선언
		int num=0, cnt=0;
		// 입력
		num = input();
		// 연산
		cnt = calc_count(num);
		// 출력
		output(num, cnt);
	}
}




