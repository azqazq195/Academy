import java.util.Scanner;

public class Exam3 {
	static double plus(double x, double y) {
		return x + y;
	}
	
	static double minus(double x, double y) {
		return x - y;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자 입력 : ");
		double a = sc.nextDouble();
		System.out.print("숫자 입력 : ");
		double b = sc.nextDouble();
		
		System.out.println(plus(a, b));
		System.out.println(minus(a, b));
	}
}



