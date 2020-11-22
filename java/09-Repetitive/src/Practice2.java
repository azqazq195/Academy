
public class Practice2 {
	public static void main(String[] args) {
		int sum = 0;
		
		for(int a=1; a<=100; a++) {
			sum += a;
			
			if(a%10 == 1) { // a : 1, 11, 21,......
				System.out.printf("%2d ~ ", a);
			}
			if(a%10 == 0) { // a : 10, 20, 30, ......
				System.out.printf("%3d = %d\n", a, sum);
				sum = 0;
			}
		}
	}
}




