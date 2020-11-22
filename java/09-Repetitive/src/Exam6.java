
public class Exam6 {
	public static void main(String[] args) {
		/* continue
		 * => for, while, do-while에서만 사용한다.
		 * => for문안에서 continue를 만나면, for문의 증감식으로 이동을 한다.
		 * => while문안에서 continue를 만나면, while문의 조건식으로 이동을 한다.
		 */
		// 1 ~ 10 사이의 홀수의 합을 구하기
		int sum = 0;
		for(int a=1; a<=10; a++) {
			if(a%2 == 0) continue;
			sum += a;
		}
		System.out.println("sum = " + sum);
	}
}





