import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exam2 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 선언  : 변수 만들기
		String name;
		int kor, eng, mat, tot;
		// 입력 : 변수에 데이터 저장하기
		System.out.print("이름 : ");
		// br.readLine() : 버퍼로부터 문자열 1개를 읽어옴
		//                읽어오려고 할때, 데이터가 \n\r이면 지워버림
		name = br.readLine();
		
		System.out.print("국어 : ");
		//Integer.parseInt(숫자로된 문자열) : 문자열을 정수로 바꿈
		kor = Integer.parseInt(br.readLine());
		
		System.out.print("영어 : ");
		eng = Integer.parseInt(br.readLine());
		
		System.out.print("수학 : ");
		mat = Integer.parseInt(br.readLine());
		// 연산 : 변수에 저장된 데이터 가공하기
		tot = kor + eng + mat;
		// 출력 : 가공된 결과값 출력하기
		System.out.println("이름 : " + name);
		System.out.println("총점 : " + tot);
		
	}
}






