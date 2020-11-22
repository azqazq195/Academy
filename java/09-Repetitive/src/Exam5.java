
public class Exam5 {
	public static void main(String[] args) {
		// 1~10 합 구하기
		// for문 대신 사용하는 while문
		int sum=0;
		int i=1;
		do {
			sum += i;
			i++;
		} while(i<=10);
		
		System.out.println("sum = " + sum);
	}
}
