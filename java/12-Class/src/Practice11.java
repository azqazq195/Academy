import java.util.Scanner;

class AAA11 {
	Scanner sc = new Scanner(System.in);
	// 선언
	int[] jumsu = new int[5];
	int total;
	double avg;
	// 입력
	void input() {
		for(int i=0; i<jumsu.length; i++) {
			System.out.print((i+1) + "번 학생의 점수를 입력 : ");
			jumsu[i] = sc.nextInt();
		}
	}
	// 연산
	void calc() {
		for(int i=0; i<jumsu.length; i++) {
			total += jumsu[i];
		}
		avg = (double)total / jumsu.length;
	}
	// 출력
	void output() {
		System.out.println("총점 : " + total + ", 평균 : " + avg);
	}
	void test() {
		for(int i=0; i<jumsu.length; i++) {
			System.out.print(jumsu[i] + " ");
		}
		System.out.println();
		System.out.printf("%d, %.1f\n", total, avg);
	}
}

public class Practice11 {
	public static void main(String[] args) {
		AAA11 aa = new AAA11();
		aa.input();
		aa.calc();
		aa.output();
		//aa.test();
	}
}
