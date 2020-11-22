
public class Test {
	    // 결과 자료형 (=리턴값의 자료형) : 컴퓨터에게 리턴값의 자료형을 알려주는 것
	static int plus(int a, int b) { // 매개 변수 : 전달된 값을 저장하는 변수
		return a + b;   // 되돌아가라 : 즉시 호출된 곳으로 되돌아가라는 명령어
	}       // 결과값 = 리턴값                   만일, 리턴값이 있으면, 리턴값을 가지고 되돌아 감
	static void output(int cc) {
		System.out.println(cc);
		return;   // 마지막 줄에 리턴값이 없는 return은 생략할 수 있음
	}
	public static void main(String[] args) {
		// 선언
		int c=0;
		// 입력
		// 연산
		c = plus(5, 7);     // 함수의 호출 : 함수의 사용법
		// 출력
		output(c);
		return;
	}
}
