import java.util.Scanner;

public class Practice1 {
	static double input_num(String str) {
		Scanner sc = new Scanner(System.in);
		System.out.print(str + " 수 : ");
		double num = sc.nextDouble();
		return num;
	}
	static String input_op() {
		Scanner sc = new Scanner(System.in);
		String op = "";
		do {
			System.out.print("연산자 : ");
			op = sc.next();
			if(op.equals("+")) break;
			else if(op.equals("-")) break;
			else if(op.equals("*")) break;
			else if(op.equals("/")) break;
			else System.out.println("+ - * / 연산자만 입력하세요");
		} while(true);
		return op;
	}
	static double calc(double num1, double num2, String op) {
		double result=0;
		switch(op) {
		case "+" : result = num1 + num2;  break;
		case "-" : result = num1 - num2;  break;
		case "*" : result = num1 * num2;  break;
		case "/" : result = num1 / num2;  break;
		}	
		return result;
	}
	static void output(double num1, String op, double num2, double result) {
		System.out.printf("%.1f %s %.1f = %.2f", num1, op, num2, result);	
	}
	public static void main(String[] args) {		
		// 선언
		double num1=0, num2=0, result=0;
		String op="";
		// 입력
		num1 = input_num("첫번째");
		num2 = input_num("두번째");
		op = input_op();
		// 연산
		result = calc(num1, num2, op);
		// 출력
		output(num1, op, num2, result);
	}
}








