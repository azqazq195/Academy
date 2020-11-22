import java.util.Scanner;

public class Practice2 {
	static String grade(double avg) {
		switch((int)(avg/10)) {
		case 10:
		case 9: return "A";
		case 8: return "B";
		case 7: return "C";
		case 6: return "D";
		default: return "F";
		}
	}
	static int input(String str){
		Scanner sc = new Scanner(System.in);	
		System.out.print(str + "점수 입력 : ");
		int jumsu = sc.nextInt();
		return jumsu;
	}
	static int calc_tot(int kor, int eng) {
		return kor + eng;
	}
	static double calc_avg(int tot) {
		return (double)tot / 2;
	}
	static void output(double avg) {
		System.out.println(grade(avg) + "학점입니다.");
	}
	public static void main(String[] args) {			
		int kor, eng, tot;
		double avg;
		kor = input("국어");
		eng = input("영어");
		
		tot = calc_tot(kor, eng);
		avg = calc_avg(tot);
		output(avg);	
	}
}
