import java.io.IOException;

public class Exam3 {
	public static void main(String[] args) throws IOException {
		// 1~10 합 구하기
		// for문 대신 사용하는 while문
		int sum = 0;
		int i = 1;  // 반복문에서 사용될 변수 : 명령을 몇번 실행할 지 설정함
		while(i <= 10) {
			//System.out.println("i=" + i + ", sum=" + sum);
			//System.in.read();  // 입력 명령어지만, 화면을 잠깐 멈추는 용도로도 사용함.
			//System.in.read();
			sum += i;
			i++;
		}
		
		System.out.println("sum = " + sum);
		//=============================
		sum = 0;
		for(int x=1; x<=10; x++) {
			sum += x;			
		}
		System.out.println("sum = " + sum);
	}
}







