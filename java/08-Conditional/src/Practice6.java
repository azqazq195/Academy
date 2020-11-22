import java.util.Scanner;

public class Practice6 {
	static int input(String str) {
		Scanner sc = new Scanner(System.in);
		System.out.print(str + "를 입력하세요 : ");
		int score = sc.nextInt();
		return score;
	}
	static double calc_jumsu(int junggan, int gimal, int report, int chulseok) {
		/* (중간+기말)/2  ---> 60%  => 60/100 => 0.6
      	과제   		---> 20%
      	출석         	---> 20% 
		 */
		return ((double)(junggan + gimal)/2 * 0.6) + report * 0.2 + chulseok * 0.2;
	}
	static String calc_hak(double jumsu) {
		String hak="";
		if(jumsu>=90) hak="A";
		else if(jumsu>=80) hak="B";
		else if(jumsu>=70) hak="C";
		else if(jumsu>=60) hak="D";
		else hak="F";
		return hak;
	}
	static String calc_grade(String hak) {
		String grade = "";
		switch(hak) {
		case "A":
		case "B": grade="excellent"; break;
		case "C":
		case "D": grade="good"; break;
		case "F": grade="poor";
		}
		return grade;
	}
	static void output(double jumsu, String hak, String grade) {
		System.out.printf("성적 = %.2f\n", jumsu);
		System.out.println("학점 = " + hak);
		System.out.println("평가 = " + grade);
	}
	public static void main(String[] args) {		
		// 선언 : 변수 만들기
		int junggan = 0;  	// 중간고사 점수 저장
		int gimal = 0; 		// 기말고사 점수 저장
		int report = 0;		// 과제점수
		int chulseok = 0;	// 출석점수
		double jumsu = 0;	// 성적
		String hak = "";	// 학점
		String grade = "";	// 평가
		// 입력 : 변수에 데이터 저장하기
		junggan = input("중간고사");
		gimal = input("기말고사");
		report = input("과제점수");
		chulseok = input("출석점수");
		// 연산 : 저장된 데이터 가공하기		
		jumsu = calc_jumsu(junggan, gimal, report, chulseok);		
		// 학점 구하기
		hak = calc_hak(jumsu);
		// 평가 구하기
		grade = calc_grade(hak);	
		// 출력 : 결과값 확인하기
		output(jumsu, hak, grade);
	}
}



