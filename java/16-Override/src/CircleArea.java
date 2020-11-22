
public class CircleArea extends Circle{
	public CircleArea(int r) {
		super(r);
	}
	@Override
	public void compute() {
		// PI * r * r
		setSize(getPI() * getR() * getR());
	}
	@Override
	public void output() {
		System.out.println("원의 넓이 : " + getSize());
	}
}
