package test2;

public class CalcAdd implements Calc{
	private int x, y;
	
	public CalcAdd() {
		x = y = 0;
	}	
	public CalcAdd(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	@Override
	public void calculate() {
		System.out.println(x + " + " + y + " = " + (x+y));
	}
}
