
public class CircleRound extends Circle{

	public CircleRound(int r) {
		super(r);		
	}
	@Override
	public void compute() {
		setSize(2*getPI()*getR());
	}
	@Override
	public void output() {
		System.out.println("원의 둘레 : " + getSize());
	}
}
