import java.util.Scanner;

public class Exam1 {
	public static  void main(String[] args) {
		// 산술 연산자 : +(더하기 연산자) -(빼기 연산자) *(곱하기 연산자) /(나누기 연산자)  
		//            %(나머지 연산자)
		Scanner sc = new Scanner(System.in);
		// 선언 : 변수 만들기
		int num1, num2;
		// 입력 : 변수에 데이터 저장하기
		System.out.print("정수 입력 : ");
		num1 = sc.nextInt();
		System.out.print("정수 입력 : ");
		num2 = sc.nextInt();
		// 연산 : 데이터 가공하기
		int result1 = num1 + num2;
		int result2 = num1 - num2;
		int result3 = num1 * num2;
		int result4 = num1 / num2;
		int result5 = num1 % num2;
		// 출력 : 결과 확인하기
		System.out.println(num1 + " + " + num2 + " = " + result1);
		System.out.println(num1 + " - " + num2 + " = " + result2);
		System.out.println(num1 + " * " + num2 + " = " + result3);
		System.out.println(num1 + " / " + num2 + " = " + result4);
		System.out.println(num1 + " % " + num2 + " = " + result5);		
	}
}












