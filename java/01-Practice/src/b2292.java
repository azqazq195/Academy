import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b2292 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int range = 1;
		int count = 0;
		int i = 0;
		int j = 0;
		
		while(range<n) {
			range = 1;
			range = range + (i)*6;
			j++;
			i += j;
			count++;
		}
		if(n==1) count=1;
		
		System.out.println(count);
	}
}
