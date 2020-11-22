package prac1;

import java.util.Scanner;
// main 함수로만 코딩
public class Test {
	public static void main(String[] args) {
		// 선언
		String[] name = new String[20];		// 이름
		String[] position = new String[20]; // 직급
		int[] basicPay = new int[20];		// 기본급
		int[] extraPay = new int[20];		// 수당
		double[] taxRate = new double[20];	// 세율
		int[] salary = new int[20];			// 월급
		int emp_cnt = 0;					// 직원 수 저장
		int num = 0;						// 메뉴 번호 저장
		Scanner sc = new Scanner(System.in);
		
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
				System.out.println("프로그램 종료...");
				System.exit(0);
			}
			switch(num) {
			case 1: // 입력 : 1명씩 저장
				System.out.println("-- <등록> --");
				System.out.print("이  름 : ");
				name[emp_cnt] = sc.next();
				System.out.print("직  급 : ");
				position[emp_cnt] = sc.next();
				System.out.print("기본급 : ");
				basicPay[emp_cnt] = sc.nextInt();
				System.out.print("수  당 : ");
				extraPay[emp_cnt] = sc.nextInt();				
				// 연산
				// 세율 계산 및 저장
				int pay = basicPay[emp_cnt] + extraPay[emp_cnt]; // 기본급 + 수당
				if(pay > 4000000) {
					taxRate[emp_cnt] = 0.03;
				} else if(pay > 2000000) {
					taxRate[emp_cnt] = 0.02;
				} else {
					taxRate[emp_cnt] = 0.01;
				}
				// 월급 계산 및 저장
				salary[emp_cnt] = (int)(pay - pay*taxRate[emp_cnt]);
				emp_cnt++;
				break;
			case 2:	// 출력
				System.out.println("-- <출력> --");
				System.out.printf("%10s%10s%10s%10s%10s%10s\n", 
								  "이름", "직급", "기본급", "수당", "세율", "월급");
				for(int i=0; i<emp_cnt; i++) {
					System.out.printf("%10s%10s%10d%10d%10.2f%10d\n", 
							name[i], position[i], basicPay[i], extraPay[i], taxRate[i], salary[i]);
				}
				break;
			}			
		}
	}
}









