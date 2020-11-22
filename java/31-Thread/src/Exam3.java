// 쓰레드 사용법 3
// Thread 클래스의 익명 클래스 사용
public class Exam3 {
	public static void main(String[] args) {
		// Thread안의 run() 함수 실행
		System.out.println("run() 함수 호출전");	
		
		(new Thread() {
			@Override
			public void run() {
				System.out.println("Test thread 3");
				for(int i=0; i<58; i++) {
					System.out.print((char)(i+65) + " ");
					if(i%10 == 0 && i!=0) System.out.println();
				}
				System.out.println();
			}
		}).start();
		
		for(int i=0; i<300; i++) {
			System.out.print(i + " ");
			if(i%10 == 0 && i!=0) System.out.println();
		}
		System.out.println();
		
		System.out.println("run() 함수 호출후");
	}
}
