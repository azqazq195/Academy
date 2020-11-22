
public class IsoTriangle extends DrawData{
	@Override
	public void draw() {
		for(int i=1; i<=getHeight(); i++) {
			for(int j=1; j<=i; j++) {
				System.out.print(getOutchar());
			}
			System.out.println();  // 한줄 넘김
		}
	}
}
