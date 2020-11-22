// 쓰레드 사용법 1
// Thread 클래스 상속
class ThreadExam1 extends Thread {
	@Override
	public void run() {
		System.out.println("Test thread 1");
		for(int i=0; i<58; i++) {
			System.out.print((char)(i+65) + " ");
			if(i%10 == 0 && i!=0) System.out.println();
		}
		System.out.println();
	}
}
public class Exam1 {
	public static void main(String[] args) {
		// Thread  객체 생성
		ThreadExam1 threadExam1 = new ThreadExam1();
		
		// Thread안의 run() 함수 실행
		System.out.println("run() 함수 호출전");		
		//threadExam1.run();  // 일반 함수 호출
		threadExam1.start();  // 쓰레드로서 run() 함수를 동작시킴
							  // run() 함수가 쓰레드로 동작하기 위해서는 준비 시간이 필요함
		
		for(int i=0; i<300; i++) {
			System.out.print(i + " ");
			if(i%10 == 0 && i!=0) System.out.println();
		}
		System.out.println();
		
		System.out.println("run() 함수 호출후");
	}
}




