
public class Exam1 {
	// throws Exception : 예외 처리 중 예외 전가 시키는 명령어
	public static void main(String[] args) throws Exception{
		// 키보드로 부터 전달된 문자 1개를 변수에 저장하기
		System.out.print("문자 1개 입력 = ");
		// System.in.read() : 버퍼로 부터 ASCII 코드로 데이터를 1개 읽어옴
		// (char) : 형변환 연산자, 정수를 문자로 바꾸는 동작을 함
		char aa = (char)System.in.read();
		System.in.read();
		System.in.read();
		System.out.print("정수 1개 입력 = ");
		int bb = System.in.read() - 48;
		
		System.out.println("입력된 문자는 " + aa + "입니다.");
		System.out.println("입력된 숫자는 " + bb + "입니다.");
	}
}





