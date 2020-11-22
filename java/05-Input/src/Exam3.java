import java.util.Scanner;

public class Exam3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 선언 : 변수만들기
		// 정수, 실수, 문자열, 문자, 
		String name;
		int kor;
		double r;
		char ch;
		// 입력 : 변수에 데이터 저장하기
		System.out.print("이름 : ");
		name = sc.next();
		System.out.print("국어 : ");
		kor = sc.nextInt();
		System.out.print("반지름 : ");
		r = sc.nextDouble();
		System.out.print("문자 1개: ");
		ch = sc.next().charAt(0);
		// 출력 : 변수에 저장된 데이터 확인하기
		System.out.println("name : " + name);
		System.out.println("kor : " + kor);
		System.out.println("r : " + r);
		System.out.println("ch : " + ch);
	}
}





