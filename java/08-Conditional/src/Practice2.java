import java.util.Scanner;

public class Practice2 {
	static int input(String str) {
		Scanner sc = new Scanner(System.in);
		System.out.print(str + "점수 입력 : ");
		int num = sc.nextInt();
		return num;
	}
	static int calc_tot(int kor, int eng) {
		return kor + eng;
	}
	static double calc_avg(int tot) {
		return (double)tot / 2;
	}
	static String calc_grade(double avg) {
		String grade = "";
		switch((int)(avg/10)) {
		case 10:
		case 9 : grade="A"; break;
		case 8 : grade="B"; break;
		case 7 : grade="C"; break;
		case 6 : grade="D"; break;
		default : grade="F"; break;
		}
		return grade;
	}
	static void output(int tot, double avg, String grade) {
		System.out.println("총점 : " + tot);
		System.out.println("평균 : " + avg);
		System.out.println("학점 : " + grade);
	}
	public static void main(String[] args) {		
		// 선언
		int kor=0, eng=0, tot=0;
		double avg=0;
		String grade="";
		// 입력
		kor = input("국어");
		eng = input("영어");
		// 연산
		tot = calc_tot(kor, eng);
		avg = calc_avg(tot);
		grade = calc_grade(avg);		
		// 출력
		output(tot, avg, grade);
	}
}






