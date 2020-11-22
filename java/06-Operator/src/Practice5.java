import java.util.Scanner;

public class Practice5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 선언
		char ch, result;
		// 입력
		System.out.print("문자 입력 : ");
		ch = sc.next().charAt(0);		
		// 연산 : 대문자인지 소문자인지 구분을 해야함
		result = (ch>='A' && ch<='Z') ? (char)(ch + 32) :
				 (ch>='a' && ch<='z') ? (char)(ch - 32) : '0';
		// 출력
		System.out.println((result != '0') ? (ch + " -> " + result) : "문자가 아닙니다.");		 
	}
}
