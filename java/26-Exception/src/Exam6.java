
class AAA {	
	// 예외처리 방법1
	void ex() { 
		try {
			// 숫자로 변환할 수 없는 문자열이므로, 에러가 발생한다.
			String year2 = "뭘까요?";
			int age2 = 2020 - Integer.parseInt(year2) + 1;
			System.out.println(age2);
		} catch(Exception e) {
			System.out.println("에러 발생");
		}
	}
	// 예외처리 방법2 : 예외 전가
	// => 사용하는 쪽에서 에러를 처리(예외처리)하도록 하는 것
	void ex1() throws Exception {		
		// 숫자로 변환할 수 없는 문자열이므로, 에러가 발생한다.
		String year2 = "뭘까요?";
		int age2 = 2020 - Integer.parseInt(year2) + 1;
		System.out.println(age2);		
	}
}

public class Exam6 {
	public static void main(String[] args){
		AAA aa = new AAA();
		
		try {
			aa.ex1();
		} catch (Exception e) {
			System.out.println("숫자로 변환할 수 없습니다.");
			e.printStackTrace();
		}
		
		//aa.ex();
		System.out.println("--- 프로그램이 종료되었습니다. ---");
	}
}










