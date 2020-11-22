import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b1193 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		System.out.println(findFraction(n));
	}
	
	static String findFraction(int n) {
		String result = "";
		
		int i = 2;
		int range = 1;
		int prevRange = 1;
		boolean sequence = true;
		
		// 1老版快 蝶肺 贸府
		if(n==1) {
			return "1/1";
		}
		
		while(range<n) {
			prevRange = range;
			range += i;
			i++;

			if(sequence == true) sequence = false;
			else sequence = true;
			
		}
		
		int a = 0;
		int b = 0;
		
		if(sequence == true) {
			for(int x=0; x<n - prevRange;x++) {
				a = range - prevRange - x;
				b = 1 + x;
				if(n-prevRange-x-1 == 0) break;
			}
		}
		else {
			for(int x=0; x<n - prevRange;x++) {
				b = range - prevRange - x;
				a = 1 + x;
				if(n-prevRange-x-1 == 0) break;
			}
		}
		
		result = Integer.toString(a) + "/" + Integer.toString(b);
		
		return result;
	}
}
