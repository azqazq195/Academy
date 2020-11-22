import java.util.Scanner;

class Triangle {
	int base, height;
	
	void setTriangle(int b, int h) {
		base = b;
		height = h;
	}
	void setTriangle() {
		Scanner sc = new Scanner(System.in);
		System.out.print("밑변 : ");
		base = sc.nextInt();
		System.out.print("높이 : ");
		height = sc.nextInt();
	}	
	double getArea() {
		return base*height/2.0;
	}
	void output() {
		System.out.println("삼각형의 넓이 : " + getArea());
	}
}

public class Practice1 {
	public static void main(String[] args) {		
		System.out.println("***** 삼각형 넓이 구하기 *****\n");
		Triangle t = new Triangle();
		t.setTriangle();
		t.output();
	}
}

