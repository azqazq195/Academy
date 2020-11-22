import java.util.Scanner;

public class Practice5 {
	static char input() {
		Scanner sc = new Scanner(System.in);
		System.out.print("문자 입력 : ");
		char ch = sc.next().charAt(0);
		return ch;
	}
	static void output(char ch) {
		if(ch >= 'A' && ch <= 'Z') {		// 대문자인지 검사, 65~90 -> 'A'~'Z'
			System.out.println(ch + " -> " + (char)(ch+32));
		} else if(ch >= 'a' && ch <= 'z') {	// 소문자인지 검사, 97~122 -> 'a'~'z'
			System.out.println(ch + " -> " + (char)(ch-32));
		} else {		// 다른 문자가 입력되었을 때
			System.out.println("알파벳이 아닙니다. 알파벳을 입력하세요");
		}
	}
	public static void main(String[] args) {		
		// 선언
		char ch;
		// 입력
		ch = input();
		// 연산, 출력
		output(ch);
	}
}
