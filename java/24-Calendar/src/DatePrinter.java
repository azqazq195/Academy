import java.util.Calendar;

public class DatePrinter {
	public static void printDateTime(Calendar calendar) {
		// 년, 월, 일, 시, 분, 초 추출
		int yy = calendar.get(Calendar.YEAR);
		int mm = calendar.get(Calendar.MONTH) + 1;  // 월은 0부터 시작됨
		int dd = calendar.get(Calendar.DAY_OF_MONTH);
		int hh = calendar.get(Calendar.HOUR_OF_DAY);  // 24시간제
		int mi = calendar.get(Calendar.MINUTE);
		int ss = calendar.get(Calendar.SECOND);
				
		System.out.printf("%04d년 %02d월 %02d일 %02d시 %02d분 %02d초\n",
		 				  yy, mm, dd, hh, mi, ss);
	}
}
