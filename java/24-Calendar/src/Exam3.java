import java.util.Calendar;

public class Exam3 {
	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance();
		long ms1 = calendar.getTimeInMillis();
		System.out.println("파일 복사 시작 >> " + ms1);
		//System.out.println(calendar);
		
		int r = 0;
		for(int i=0; i<1000000000; i++) {
			for(int j=0; j<10; j++) {
				r += i;
			}
		}
		/*
		// 주어진 시간동안 대기
		try {  // 예외 처리
			Thread.sleep(5000);  // 5초동안 대기
		} catch(Exception e) {
			e.printStackTrace();
		}
		*/
		
		// 새로운 시간 얻기
		long ms2 = Calendar.getInstance().getTimeInMillis();
		System.out.println("파일 복사 끝 >> " + ms2);
		// 두시간 차 계산
		long result = ms2 - ms1;
		System.out.println(result + "ms 지났음");
	}
}






