
public class Exam4 {
	// 전달 값들 사이의 합을 구하는 함수
	static int sum(int from, int to) {
		int tot = 0;
		for(int a=from; a<=to; a++) {
			tot += a;
		}
		return tot;
	}
	
	public static void main(String[] args) {
		System.out.println(sum(1, 10));
		System.out.println(sum(1, 100));
	}
}







