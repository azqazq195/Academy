package prac4;

import java.util.Scanner;
/** 객체 배열 이용 **/

// 직원 1명 데이터만 저장하는 클래스
class Emp {
	// 선언
	String name;		// 이름
	String position; 	// 직급
	int basicPay;		// 기본급
	int extraPay;		// 수당
	double taxRate;		// 세율
	int salary;			// 월급
	static int emp_cnt = 0;	// 직원 수 저장	
	Scanner sc = new Scanner(System.in);
	
	// 입력 : 1명씩 저장
	void input() {		 
		System.out.println("-- <등록> --");		
		System.out.print("이  름 : ");
		name = sc.next();
		System.out.print("직  급 : ");
		position = sc.next();
		System.out.print("기본급 : ");
		basicPay = sc.nextInt();
		System.out.print("수  당 : ");
		extraPay = sc.nextInt();	
		calc_taxRate();
		calc_salary();
		Emp.emp_cnt++;
	}	
	// 연산
	void calc_taxRate() {
		// 세율 계산 및 저장
		int pay = basicPay + extraPay; // 기본급 + 수당
		if(pay > 4000000) {
			taxRate = 0.03;
		} else if(pay > 2000000) {
			taxRate = 0.02;
		} else {
			taxRate = 0.01;
		}
	}
	void calc_salary() {
		// 월급 계산 및 저장
		int pay = basicPay + extraPay; // 기본급 + 수당
		salary = (int)(pay - pay*taxRate);		
	}
	// 출력
	void print_title() {
		System.out.println("-- <출력> --");
		System.out.printf("%10s%10s%10s%10s%10s%10s\n", 
						  "이름", "직급", "기본급", "수당", "세율", "월급");
	}
	void output() {		
		System.out.printf("%10s%10s%10d%10d%10.2f%10d\n", 
					name, position, basicPay, extraPay, taxRate, salary);		
	}	
	// 프로그램 종료
	static void end_pgm() {
		System.out.println("프로그램 종료...");
		System.exit(0);
	}
}
public class Test {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = 0;
		Emp[] emp = new Emp[4];
		
		// 메뉴 : 입력, 출력, 종료 분기
		while(true) {
			System.out.println();
			System.out.println("1. 등록");
			System.out.println("2. 출력");
			System.out.println("3. 종료");
			System.out.println("----------");
			System.out.print("번호 : ");
			num = sc.nextInt();
			System.out.println(); 	// 한줄 넘김
			
			if(num == 3) {
				Emp.end_pgm();
			}
			switch(num) {
			case 1: // 입력 : 1명 데이터 입력	
				if(Emp.emp_cnt < emp.length) {
					emp[Emp.emp_cnt] = new Emp();
					emp[Emp.emp_cnt].input();	
				} else {
					System.out.println((emp.length+1) + "명 이상은 입력을 못합니다.");
				}
				break;
			case 2:	// 출력
				emp[Emp.emp_cnt - 1].print_title();
				for(int i=0; i<Emp.emp_cnt; i++) {
					emp[i].output();
				}
				break;
			}
		}
	}
}









