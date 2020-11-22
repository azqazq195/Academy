import java.util.Calendar;

public class Exam4 {
	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance();
		
		// 요일에 해당하는 인덱스(요일수) : 일(1) ~ 토(7)
		int dayNum = calendar.get(Calendar.DAY_OF_WEEK);
		System.out.println("요일 인덱스(요일수) : " + dayNum);
		
		// 요일 출력
		String[] dayName = {"일", "월", "화", "수", "목", "금", "토"};
		System.out.println("오늘은 " + dayName[dayNum - 1] + "요일");
		
		// 이번 달은 몇주로 되어 있는가?
		int week_count = calendar.getActualMaximum(Calendar.WEEK_OF_MONTH);
		System.out.println("이번 달은 " + week_count + "주로 되어 있습니다.");
		
		// 이번 달은 몇일까지 있는가?
		int day_count = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		System.out.println("이번 달은 " + day_count + "일로 되어 있습니다.");
		
		// 이번 달은 무슨 요일부터 시작되는가?
		calendar.set(Calendar.DAY_OF_MONTH, 1);  // 일을 1일로 변경
		DatePrinter.printDateTime(calendar);
		int first_day = calendar.get(Calendar.DAY_OF_WEEK);
		System.out.println("이번 달의 시작 요일 인덱스 : " + first_day);
		System.out.println("이번 달의 시작 요일 : " + dayName[first_day - 1] + "요일");
	}
}









