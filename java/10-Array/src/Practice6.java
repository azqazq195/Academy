import java.util.Scanner;

public class Practice6 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 선언
		boolean[] parking = new boolean[5];
		int num = 0;  		// 메뉴 번호 저장
		int position = 0;  	// 위치값
		
		while(true) {
			// 입력
			System.out.println("주차 관리 프로그램");
			System.out.println("***************");
			System.out.println("    1. 입차");
			System.out.println("    2. 출차");
			System.out.println("    3. 리스트");
			System.out.println("    4. 종료");
			System.out.println("***************");
			System.out.print("메뉴 : ");
			num = sc.nextInt();	
			System.out.println(); // 한줄 넘김
			
			// 연산, 출력
			switch(num) {
			case 1: // 입차
				do {
					System.out.print("위치 입력 [1~5] : ");
					position = sc.nextInt();
				} while(position <=0 || position>5);
				
				if(parking[position - 1] == false) {     // 비어 있으면
					parking[position - 1] = true;
					System.out.println(position + "위치에 입차 / 주차되었습니다.");
				} else {   // 비어 있지 않으면
					System.out.println(position + "위치에 입차 / 이미 주차된 차가 있습니다.");
				}
				break;
			case 2: // 출차
				do {
					System.out.print("위치 입력 [1~5] : ");
					position = sc.nextInt();
				} while(position<=0 || position>5);
				
				if(parking[position - 1] == false) { // 비어 있으면
					System.out.println(position + "위치에 출차 / 주차되어 있지 않습니다.");
				} else {  	// 비어 있지 않으면
					System.out.println(position + "위치에 출차 / 출차되었습니다.");
					parking[position - 1] = false;
				}
				break;
			case 3: // 리스트
				System.out.println("--- 리스트 ---");
				for(int i=0; i<parking.length; i++) {
					System.out.println((i+1) + "위치 : " + parking[i]);
				}
				break;
			case 4: // 종료
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);  // 프로그램 종료 명령어
			}
			System.out.println();  // 한줄 넘김
			/*
			if(num == 4) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}
			*/
		}
	}
}






