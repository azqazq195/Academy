import java.util.Calendar;
import java.util.Scanner;

class InfinityCalendar {
	// 선언
	Scanner sc = new Scanner(System.in);
	Calendar calendar = Calendar.getInstance();
	int y; 			// 년
	int m;			// 월
	int dayNum;		// 요일수
	
	// 입력
	void input() {
		do {
			System.out.print("년도? ");
			y = sc.nextInt();
		} while(y < 1);
		
		do {
			System.out.print("월? ");
			m = sc.nextInt();
		} while(m<1 || m>12);
		//System.out.println(y + "년 " + m + "월"); 
	}
	// 연산
	void setDate() {
		calendar.set(y, m-1, 1); 	// 날자를 입력받은 달의 1일로 설정
		// 그 달 1일의 요일수 저장
		dayNum = calendar.get(Calendar.DAY_OF_WEEK);
		System.out.println("요일수 : " + dayNum);
		DatePrinter.printDateTime(calendar);
	}
	// 출력
	void outputTitle() {
		System.out.println();
		System.out.println(" 일   월    화   수   목   금   토");
		System.out.println("---------------------");
	}
	void output() {
		outputTitle();
		// 요일수 만큼 커서 이동 시키기
		for(int i=1; i<dayNum; i++) {
			System.out.print("   ");  // 공백문자 3개
		}
		// 이번달의 총일수 구하기
		int daysOfMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		// 날짜 출력
		for(int i=1; i<=daysOfMonth; i++) {
			System.out.printf("%2d ", i);
			dayNum++;  // 요일수를 증가시킴
			// 요일수가 일요일인가? (일요일의 요일수 = 1)
			if(dayNum%7 == 1) {
				System.out.println();  // 요일수가 일요일이면, 1줄 넘김
			}
		}
	}
}

public class Exam5 {
	public static void main(String[] args) {
		InfinityCalendar infinityCalendar = new InfinityCalendar();
		infinityCalendar.input();
		infinityCalendar.setDate();
		infinityCalendar.output();
	}
}






