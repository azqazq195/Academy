import java.util.Scanner;

class AAA6 {
	Scanner sc = new Scanner(System.in);
	// 선언
	int junggan, gimal, report, chulseok;
	double jumsu;
	String hak="", grade="";
	// 입력
	void input() {
		System.out.print("중간고사를 입력하세요 : ");
		junggan = sc.nextInt();
		System.out.print("기말고사를 입력하세요 : ");
		gimal = sc.nextInt();
		System.out.print("과제점수를 입력하세요 : ");
		report = sc.nextInt();
		System.out.print("출석점수를 입력하세요 : ");
		chulseok = sc.nextInt();
	}
	// 연산
	void calc() {
		/*조건1) (중간+기말)/2  ---> 60%
    			과제   		---> 20%
    			출석                   ---> 20% */ 
		jumsu = (junggan + gimal) / 2 * 0.6 + report * 0.2 + chulseok * 0.2;
		
		if(jumsu >= 90) hak = "A";
		else if(jumsu >= 80) hak = "B";
		else if(jumsu >= 70) hak = "C";
		else if(jumsu >= 60) hak = "D";
		else hak = "F";
		
		switch(hak) {
		case "A":
		case "B": grade = "excellent"; break;
		case "C":
		case "D": grade = "good"; break;
		case "F": grade = "poor"; break;
		}
	}
	// 출력
	void output() {
		System.out.printf("성적 = %.2f\n", jumsu);
		System.out.println("학점 = " + hak);
		System.out.println("평가 = " + grade);
	}
	void test() {
		System.out.printf("%d, %d, %d, %d\n", junggan, gimal, report, chulseok);
		System.out.printf("%.1f, %s, %s\n", jumsu, hak, grade);
	}
}
public class Practice6 {
	public static void main(String[] args) {
		AAA6 aa = new AAA6();
		aa.input();
		aa.calc();
		aa.output();
		//aa.test();
	}
}
