
public class Pyramid extends DrawData{
	@Override
	public void draw() {
		for(int i=1; i<=getHeight(); i++) {
			// 공백 문자 출력
			for(int j=1; j<=getHeight()-i; j++) {
				System.out.print(" ");
			}
			// 문자 출력
			for(int j=1; j<=2*i-1; j++) {
				System.out.print(getOutchar());
			}
			System.out.println();  // 한줄 넘김
		}
	}
}
