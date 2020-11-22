import java.util.Scanner;

public class Practice4 {
	static int input(String str) {
		Scanner sc = new Scanner(System.in);
		System.out.print(str + " 점수 : ");
		int num = sc.nextInt();
		return num;
	}
	static int calc_tot(int kor, int eng, int mat) {
		return kor + eng + mat;
	}
	static int calc_avg(int tot) {
		return tot / 3;
	}
	static void output(int avg, int kor, int eng, int mat) {
		if((avg >= 60) && (kor>=40) && (eng>=40) && (mat>=40)) {
			System.out.println("합격");
		} else {
			System.out.println("불합격");
		}
	}
	public static void main(String[] args) {		
		// 선언
		int kor=0, eng=0, mat=0, tot=0, avg=0;
		// 입력
		kor = input("국어");
		eng = input("영어");
		mat = input("수학");
		// 연산
		tot = calc_tot(kor, eng, mat);
		avg = calc_avg(tot);
		// 출력
		output(avg, kor, eng, mat);
	}
}





