
public class Compute {
	private int x, y, sum, sub, mul;
	private double div;
	
	public void outputCalc() {
		System.out.printf("%8s%8s%8s%8s%8s%8s\n", "X", "Y", "SUM", "SUB", "MUL", "DIV");
		System.out.printf("%8d%8d%8d%8d%8d%8.1f\n", x, y, sum, sub, mul, div);
	}
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getSum() {
		sum = x+y;
		return sum;
	}
	public void setSum(int sum) {
		this.sum = sum;
	}
	public int getSub() {
		sub = x - y;
		return sub;
	}
	public void setSub(int sub) {
		this.sub = sub;
	}
	public int getMul() {
		mul = x * y;
		return mul;
	}
	public void setMul(int mul) {
		this.mul = mul;
	}
	public double getDiv() {
		div = (double)x / y;
		return div;
	}
	public void setDiv(double div) {
		this.div = div;
	}	
}
