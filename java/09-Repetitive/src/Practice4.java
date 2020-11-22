
public class Practice4 {
	public static void main(String[] args) {
		for(int x=1; x<=5; x++) {  		// 총 층수 : 5층
			for(int y=1; y<=x; y++) {  	// 별의 갯수 : x값으로 결정
				System.out.print("*");
			}
			System.out.println();  		// 한줄 넘김
		}
	}
}
