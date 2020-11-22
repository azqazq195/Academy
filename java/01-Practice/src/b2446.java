import java.util.Scanner;

public class b2446 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		
		for(int i=1;i<=num;i++) {
			for(int k=1;k<i;k++) {
				System.out.print(" ");
			}
			for(int j=0;j<=2*(num-i);j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		for(int i=1;i<num;i++) {
			for(int k=1;k<num-i;k++) {
				System.out.print(" ");
			}
			for(int j=0;j<=2*i;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
	
		
	}
}
