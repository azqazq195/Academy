import java.util.Scanner;

public class b11720 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int length = sc.nextInt();
		String s = sc.next();
		int result = 0;
		
		for(int i=0;i<length;i++) {
			result += (int)s.charAt(i)-48;
		}
		
		System.out.println(result);
		
	}
}
