
public class Exam1 {
	static void star(int n) {
		for(int a=1; a<=n; a++) {
			System.out.print("*");
		}
		System.out.println();  // 한줄 넘김
	}
	public static void main(String[] args) {
		// for을 사용해서 15층 별탑을 출력하세요
		for(int i=1; i<=15; i++) {
			star(i);
		}
		
		star(1);
		star(2);
	}
}
