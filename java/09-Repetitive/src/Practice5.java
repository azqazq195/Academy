
public class Practice5 {
	public static void main(String[] args) {
		for(int x=1; x<=5; x++) {   // 층 : 5층
			// 공백문자 출력
			for(int y=1; y<=5-x; y++) {
				System.out.print(" ");
			}
			// 별 출력
			for(int y=1; y<=x; y++) {
				System.out.print("*");
			}
			// 1줄넘김
			System.out.println();
		}
	}
}
