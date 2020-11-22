
public class Practice4 {
	static void output(int num, char ch) {
		for(int x=1; x<=num; x++) {
			// 공백문자 출력
			for(int y=1;y<=num-x; y++) {
				System.out.print(" ");
			}
			// 문자 출력
			for(int y=1; y<=(2*x - 1); y++) {
				System.out.print(ch);
			}
			// 1줄 넘김
			System.out.println();
		}
	}
	public static void main(String[] args) {
		output(5, 'Y');
	}
}
