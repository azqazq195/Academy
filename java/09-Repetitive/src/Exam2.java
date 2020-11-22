
public class Exam2 {
	public static void main(String[] args) {
		for(int a=2; a<=9; a++) {  		// 단 : 2단~9단
			for(int b=1; b<=9; b++) {	// 1~9
				System.out.printf("%d*%d=%2d  ", a, b, a*b);
			}
			System.out.println();  // 1줄 넘김
		}
	}
}
