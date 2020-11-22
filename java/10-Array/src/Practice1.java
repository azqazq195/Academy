import java.util.Scanner;

public class Practice1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 선언
		int[] jumsu = new int[5];
		int tot = 0;
		double avg = 0;		
		// 입력
		for(int i=0; i<jumsu.length; i++) {
			System.out.print((i+1) + "번 학생의 점수를 입력 : ");
			jumsu[i] = sc.nextInt();
		}
		// 연산
		for(int i=0; i<jumsu.length; i++) {
			tot += jumsu[i];
		}
		avg = (double)tot / jumsu.length;
		// 출력
		System.out.println("총점: " + tot + ", 평균: " + avg);
	}
}
