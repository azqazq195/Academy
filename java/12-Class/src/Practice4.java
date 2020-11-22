import java.util.Scanner;

class AAA4 {
	Scanner sc = new Scanner(System.in);
	// 선언
	int kor, eng, mat, tot, avg;
	// 입력
	void input() {
		System.out.print("국어 점수 : ");
		kor = sc.nextInt();
		System.out.print("영어 점수 : ");
		eng = sc.nextInt();
		System.out.print("수학 점수 : ");
		mat = sc.nextInt();
	}
	// 연산
	void calc() {
		tot = kor + eng + mat;
		avg = tot/3;
	}
	// 출력
	void output() {
		if(avg>=60 && kor>=40 && eng>=40 && mat>=40) {
			System.out.println("합격");
		} else {
			System.out.println("불합격");
		}
	}
}
public class Practice4 {
	public static void main(String[] args) {
		AAA4 aa = new AAA4();
		aa.input();
		aa.calc();
		aa.output();
	}
}



