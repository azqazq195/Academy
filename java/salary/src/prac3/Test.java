package prac3;

import java.util.Scanner;
// 클래스로 코딩
// 20명 데이터를 처리하는 클래스
class Emp {
	// 선언
	String[] name = new String[20];		// 이름
	String[] position = new String[20]; // 직급
	int[] basicPay = new int[20];		// 기본급
	int[] extraPay = new int[20];		// 수당
	double[] taxRate = new double[20];	// 세율
	int[] salary = new int[20];			// 월급
	int emp_cnt = 0;					// 직원 수 저장	
	Scanner sc = new Scanner(System.in);
	// 메뉴
	void menu() {
		int num = 0;
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
				end_pgm();
			}
			switch(num) {
			case 1: // 입력					
				input();
				calc_taxRate();
				calc_salary();
				break;
			case 2:	// 출력
				output();
				break;
			}
		}
	}
	// 프로그램 종료
	void end_pgm() {
		System.out.println("프로그램 종료...");
		System.exit(0);
	}
	// 입력 : 1명씩 저장
	void input() {		 
		System.out.println("-- <등록> --");
		if(emp_cnt < name.length) {
			System.out.print("이  름 : ");
			name[emp_cnt] = sc.next();
			System.out.print("직  급 : ");
			position[emp_cnt] = sc.next();
			System.out.print("기본급 : ");
			basicPay[emp_cnt] = sc.nextInt();
			System.out.print("수  당 : ");
			extraPay[emp_cnt] = sc.nextInt();
		} else {
			System.out.println("20명 이상은 입력을 못합니다.");
		}
	}	
	// 연산
	void calc_taxRate() {
		// 세율 계산 및 저장
		int pay = basicPay[emp_cnt] + extraPay[emp_cnt]; // 기본급 + 수당
		if(pay > 4000000) {
			taxRate[emp_cnt] = 0.03;
		} else if(pay > 2000000) {
			taxRate[emp_cnt] = 0.02;
		} else {
			taxRate[emp_cnt] = 0.01;
		}
	}
	void calc_salary() {
		// 월급 계산 및 저장
		int pay = basicPay[emp_cnt] + extraPay[emp_cnt]; // 기본급 + 수당
		salary[emp_cnt] = (int)(pay - pay*taxRate[emp_cnt]);
		emp_cnt++;
	}
	// 출력
	void output() {
		System.out.println("-- <출력> --");
		System.out.printf("%10s%10s%10s%10s%10s%10s\n", 
						  "이름", "직급", "기본급", "수당", "세율", "월급");
		for(int i=0; i<emp_cnt; i++) {
			System.out.printf("%10s%10s%10d%10d%10.2f%10d\n", 
					name[i], position[i], basicPay[i], extraPay[i], taxRate[i], salary[i]);
		}
	}		
}

public class Test {

	public static void main(String[] args) {	
		Emp emp = new Emp();
		emp.menu();
	}
}









