import java.util.Scanner;

public class Practice4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 선언
		int num1=0, num2=0;
		String str1="", str2="";
		// 입력
		System.out.print("첫번째 수 = ");
		num1 = sc.nextInt();
		System.out.print("두번째 수 = ");
		num2 = sc.nextInt();
		// 연산
		str1 = "첫번째 수(" + num1 + ")가 두번째 수(" + num2 + ")보다 작은 수 입니다.";
		str2 = "첫번째 수(" + num1 + ")가 두번째 수(" + num2 + ")보다 큰 수 입니다.";
		// 출력
		System.out.println(num1 < num2 ? str1 : str2);
	}
}






