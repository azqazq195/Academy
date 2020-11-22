
public class Practice6 {
	public static void main(String[] args) {
		for(int x=1; x<=5; x++) {   		// 층 : 5층
			// 공백 문자 출력
			for(int y=1; y<=5-x; y++) {  	// 4, 3, 2, 1, 0
				System.out.print(" ");
			}
			// 별 출력
			for(int y=1; y<=(2*x-1); y++) { // 1, 3, 5, 7, 9
				System.out.print("*");
			}
			// 한줄 넘김
			System.out.println();
		}
	}
}
