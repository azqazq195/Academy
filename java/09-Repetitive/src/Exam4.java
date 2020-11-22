
public class Exam4 {
	public static void main(String[] args) {
		// 1~10 합 구하기
		// for문 대신 사용하는 while문
		int sum = 0;
		int i = 1;
		// 조건식에 true를 사용하면, 조건식을 {}안에 위치를 유연하게 배치할 수 있다.
		while(true) { 			
			sum += i;
			if(i >= 10) break;
			i++;			
		}
		System.out.println("sum = " + sum);  // Error : Unreachable code
	}
}
