import java.util.Calendar;

public class Exam2 {
	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance();
		DatePrinter.printDateTime(calendar);
		
		// 특정 날짜로 지정 : 2021. 5. 5. 15:30:33
		calendar.set(Calendar.YEAR, 2021);
		calendar.set(Calendar.MONTH, 4);
		calendar.set(Calendar.DAY_OF_MONTH, 5);
		calendar.set(Calendar.HOUR_OF_DAY, 15);
		calendar.set(Calendar.MINUTE, 30);
		calendar.set(Calendar.SECOND, 33);
		DatePrinter.printDateTime(calendar);
		
		// 특정 날짜로 지정 
		calendar.set(1998, 7, 10);
		DatePrinter.printDateTime(calendar);
		
		// 특정 날짜로 지정 
		calendar.set(1998, 7, 10, 1, 2, 3);
		DatePrinter.printDateTime(calendar);
	}
}








