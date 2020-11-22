
public class Practice2 {
	public static void main(String[] args) {
		// 선언		
		// 입력
		String name = "L";
		int basePay = 2500000;
		int tax = 0;
		int salary = 0;
		
		// 연산
		tax = (int)(basePay * 0.033);
		salary = basePay - tax;
		
		// 출력
		System.out.println("*** " + name + "의 월급 ***");
		System.out.println("기본급 : " + basePay + "원");
		System.out.println("세   금 : " + tax + "원");
		System.out.println("월   급 : " + salary + "원");
		System.out.println("------------------------");
		// printf("서식문자", 데이터);
		// %d : 정수, %f : 실수, %s : 문자열
		// %3d : 정수, %3.1f : 실수, %3s : 문자열
		System.out.printf("기본급 : %d원\n", basePay);
		System.out.printf("세   금 : %d원\n", tax);
		System.out.printf("월   급 : %d원\n", salary);
		System.out.println("------------------------");
		System.out.printf("기본급 : %10d원\n", basePay);
		System.out.printf("세   금 : %10d원\n", tax);
		System.out.printf("월   급 : %10d원\n", salary);
	}
}









