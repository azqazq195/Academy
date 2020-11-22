
public class Circle {
	private int r;							// 반지름
	private double size;					// 계산 결과값
	private final double PI = 3.141592; 	// 원주율
	
	public Circle(int r) {
		this.r = r;
	}
	// 계산
	public void compute() {}    // 상속받은 자식클래스에서 사용되도록 틀을 잡아놓은 것임
	// 출력
	public void output() {}
	
	public int getR() {
		return r;
	}
	public void setR(int r) {
		this.r = r;
	}	
	public double getSize() {
		return size;
	}
	public void setSize(double size) {
		this.size = size;
	}
	public double getPI() {
		return PI;
	}	
}
