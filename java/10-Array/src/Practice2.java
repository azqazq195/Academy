import java.util.Scanner;

public class Practice2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 선언
		int year, month, day, total=0;
		int[] months = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};		
		// 입력
		System.out.print("년 : ");
		year = sc.nextInt();
		System.out.print("월 : ");
		month = sc.nextInt();
		System.out.print("일 : ");
		day = sc.nextInt();
		// 연산
		// 윤년 검사 : 윤년일 경우 2월은 29일로 계산
		if((year%4 == 0) && (year%100 != 0) || (year%400 == 0)) {  
			months[2] = 29;
		}
		// 총 일수 계산 : 1월1일~5월 5일 => 1월 + 2월 + 3월 + 4월 + 5
		for(int i=1; i<month; i++) {
			total += months[i];
		}
		total += day;
		// 출력
		System.out.printf("1월1일부터  %d월%d일 까지는 %d일 입니다.", month, day, total);
	}
}







