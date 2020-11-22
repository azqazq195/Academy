// 쓰레드 사용법 2
// Runnable 인터페이스 상속 : 다중 상속
class ThreadExam2 implements Runnable {
	@Override
	public void run() {
		System.out.println("Test thread 2");
		for(int i=0; i<58; i++) {
			System.out.print((char)(i+65) + " ");
			if(i%10 == 0 && i!=0) System.out.println();
		}
		System.out.println();
	}	
}
public class Exam2 {
	public static void main(String[] args) {
		// Runnable 상속 객체와 Thread 객체 생성
		ThreadExam2 threadExam2 = new ThreadExam2();
		Thread thread = new Thread(threadExam2);
		
		// Thread안의 run() 함수 실행
		System.out.println("run() 함수 호출전");		
		
		thread.start();  // 쓰레드로서 run() 함수를 동작시킴
							  // run() 함수가 쓰레드로 동작하기 위해서는 준비 시간이 필요함
				
		for(int i=0; i<300; i++) {
			System.out.print(i + " ");
			if(i%10 == 0 && i!=0) System.out.println();
		}
		System.out.println();
				
		System.out.println("run() 함수 호출후");
	}
}











