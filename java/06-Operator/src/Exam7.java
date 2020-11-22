
public class Exam7 {
	public static void main(String[] args) {
		// 논리 연산자 : 수학의 집합 기호를 명령어로 만든 것
		// => && : and,  || : or, ! : not
		/* <진리표>
			x		y		x && y		x || y		!x
			true	true	true		true		false
			true	false	false		true		false
			false	true	false		true		true
			false	false	false		false		true
		*/
		int a = 100;
		int b = 200;
		int x = 5;
		int y = 3;
		
		boolean r1 = a>=b;   // 100>=200   false
		boolean r2 = x>=y;   // 5>=3       true
		boolean result1 = r1 && r2;
		boolean result2 = r1 || r2;
		System.out.println(result1);
		System.out.println(result2);
		System.out.println("-------------");
		
		System.out.println(!true);
		System.out.println(!false);
	}
}
