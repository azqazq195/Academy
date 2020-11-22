import java.util.Scanner;

public class Exam8 {
	public static void main(String[] args) {
		// 삼항 연산자 (= 조건 연산자)
		// (조건식) ? 값1 : 값2
		// => 조건식이 true이면 값1을
		//    조건식이 false이면 값2를 가짐
		
		// 선언 : 변수 만들기
		Scanner sc = new Scanner(System.in);
		int num1=0, num2=0;
		int result = 0;
		
		// 입력 : 변수에 데이터 저장하기
		System.out.print("정수 입력 : ");
		num1 = sc.nextInt();
		System.out.print("정수 입력 : ");
		num2 = sc.nextInt();
		// 연산 : 변수에 저장된 데이터 가공하기
		result = (num1 > num2) ? num1 : num2;
		// 출력 : 연산 결과 출력하기
		System.out.println("큰 수 : " + result);
	}
}






