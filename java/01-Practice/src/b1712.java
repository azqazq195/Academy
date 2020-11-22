import java.util.Scanner;

public class b1712 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int staticCost = sc.nextInt();
		int cost = sc.nextInt();
		int price = sc.nextInt();
		int result;
		
		if(price <= cost) result = -1;
		else result = staticCost / (price - cost) + 1;
		System.out.println(result);

	}
}
