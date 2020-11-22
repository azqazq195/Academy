import java.util.Scanner;

public class Exam6 {
	public static void main(String[] args) {
		// 관계 연산자 : <  >  <=  >=  
		// 비교 연산자 : ==  !=
		// => 연산식이 옳은면 true, 연산식이 틀리면 false
		
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 입력 : ");
		int num1 = sc.nextInt();
		System.out.print("정수 입력 : ");
		int num2 = sc.nextInt();
		
		// 관계연산자의 결과는 boolean값이다.
		boolean r1 = num1 > num2;   // 왼쪽값이 오른쪽값보다 큰 지 검사
		boolean r2 = num1 < num2;
		boolean r3 = num1 >= num2;
		boolean r4 = num1 <= num2;
		boolean r5 = num1 == num2;  // 두값이 같은 지 검사
		boolean r6 = num1 != num2;  // 두값이 같지 않은 지 검사
		
		System.out.println(r1);
		System.out.println(r2);
		System.out.println(r3);
		System.out.println(r4);
		System.out.println(r5);
		System.out.println(r6);		
	}
}
