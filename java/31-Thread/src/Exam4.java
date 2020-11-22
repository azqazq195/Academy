// 쓰레드 사용법 4
// Runnable 인터페이스의 익명 클래스 사용
public class Exam4 {
	public static void main(String[] args) {
		// Thread안의 run() 함수 실행
		System.out.println("run() 함수 호출전");		
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("Test thread 4");
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
