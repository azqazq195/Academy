
public class Exam1 {
	public static void main(String[] args) {
		String year1 = "1994";
		int age1 = 2020 - Integer.parseInt(year1) + 1;
		System.out.println(age1);
		// 숫자로 변환할 수 없는 문자열이므로, 에러가 발생한다.
		String year2 = "뭘까요?";
		int age2 = 2020 - Integer.parseInt(year2) + 1;
		System.out.println(age2);
		
		System.out.println("--- 프로그램을 종료합니다. ---");
	}
}
