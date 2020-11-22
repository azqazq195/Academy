import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b2839 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int five = 0;
		int three = 0;
		int result = 0;
		
		five = n/5;
		
		for(int i=0;i<=(n/5);i++) {
			n -= five*5;
			if(n%3==0) {
				three = n/3;
				result = five + three;
				break;
			}
			
			n=n+5*five;
			five--;
		}
		System.out.println(result==0 ? -1 : result);
	}
}
