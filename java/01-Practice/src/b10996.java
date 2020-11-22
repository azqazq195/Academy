import java.util.Scanner;

public class b10996 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		
		for(int x=0; x<num; x++) {
			for(int i=0; i<num; i++) {
				if(i%2==0) {
					System.out.print("*");
				}
				else {
					System.out.print(" ");
				}
			}
			
			System.out.println();
			
			for(int i=0; i<num; i++) {
				if(i%2==0) {
					System.out.print(" ");
				}
				else {
					System.out.print("*");
				}
			}
			
			System.out.println();
		}
		
		
	}
}
