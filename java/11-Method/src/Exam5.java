import java.util.Scanner;

public class Exam5 {
	public static void inputNum(int[] nn) {
		Scanner sc = new Scanner(System.in);
		
		for(int a=0; a<nn.length; a++) {
			System.out.print((a+1) + "번째 숫자 입력 : ");
			nn[a] = sc.nextInt();
		}
	}
	
	public static void outputNum(int[] nn) {
		System.out.println();
		System.out.println("*** 출력 ***");
		for(int a=0; a<nn.length; a++) {
			System.out.print(nn[a] + " ");
		}
	}
	public static void main(String[] args) {
		int[] n = new int[5];
		inputNum(n);
		outputNum(n);
	}
}












