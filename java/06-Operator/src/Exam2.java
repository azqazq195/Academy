
public class Exam2 {
	public static void main(String[] args) {
		// 산술 연산자 사용할 때 주의할 점
		// 정수의 나눗셈 : 정수끼리 나누면 반드시 결과는 정수
		int a = 7;
		int b = 3;
		int result1 = a / b;
		System.out.println(a + " / " + b + " = " + result1);
		
		// 실수 데이터는 정수형 변수에는 저장할 수 없다.
		// 그래도 저장하고 싶으면, 형변환을 해야함
		double c = 7.0;
		double d = 3.0;
		int result2 = (int)(c / d);
		System.out.println(c + " / " + d + " = " + result2);
		
		// 나머지 연산자는 가능한 정수계산에만 사용한다.
		System.out.println(7.7 % 2.2);
		
		// 0으로 나누기
		//System.out.println(5 / 0);  // error, 정수는 0으로 나누면 안됨
		System.out.println(5.0 / 0.0);
	}
}







