
public class Exam {
	public static void main(String[] args) {
		// 난수 만들기 : 임의의 숫자 만들기
		// Math 클래스
		// Math.random() : 0.0<= 실수 <1.0 사이의 임의의 실수를 만드는 명령어
		//System.out.println(Math.random());
		
		// 대문자 아스키 : 'A'~'Z' : 65~90
		int min = 65;
		int max = 90;
		double rand = Math.random();
		int result = (int)(rand * (max - min + 1) + min);
		// 0.0 * (90 - 65 + 1) + 65 = 65
		// 0.999 * (90 - 65 + 1) + 65 = 0.9 * 26 + 65 = 25.974 + 65 = 90.974
		System.out.println(rand);
		System.out.println("result = " + result + ", 문자 : " + (char)result);
	}
}





