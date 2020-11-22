/** <여러줄 주석>
* 프로그램 소스의 최소 단위 = class
* 프로그램 시작 클래스 (메인 클래스) --> public class 클래스 이름
* 메인 클래스의 이름은 소스파일의 이름과 동일해야 하며, 영어/숫자/언더바(_)만 사용 가능하다.
* 클래스의 이름은 반드시 영어로만 구성되어야 한다.
* 클래스의 첫글자는 가능한 대문자로 시작한다.
*/
public class Exam1 {
	
	// 메인 함수 : 자바 프로그램의 진입점
	// => 자바 프로그램은 메인함수에서 시작해서, 
	//    메인함수에 있는 명령어들을 다 실행하고 종료된다.
	public static void main(String[] args) {
		// 콘솔에 데이터를 출력하기 이한 명령어
		// 문자열을 표현하는 방법 --> 쌍따옴표("")로 묶는다.
		System.out.println("Hello World");  // 데이터를 콘솔창에 출력하고, 한줄넘김 동작을 함
		System.out.print("자바");			// 데이터를 콘솔창에 출력만 함
		//System.out.println();				// 한줄넘김
		System.out.println("출발");
		
		// 여러 데이터 출력
		System.out.println(100);    // 정수
		System.out.println(5.5);    // 실수
		System.out.println('A');    // 문자
		System.out.println("홍길동");// 문자열
		System.out.println(true);	// boolean값	
	}
}
