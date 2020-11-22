
public class Practice1 {
	public static void main(String[] args) {
		DrawData data = new IsoTriangle();
		data.setHeight(10);
		data.setOutchar("X");
		data.draw();
	
		data = new Pyramid();
		data.setHeight(10);
		data.setOutchar("#");
		data.draw();
	}
}
