import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b10870 {
	
	public static int function(int n) {
		
		if(n == 0) return 0;
		else if(n == 1) return 1;
		else {
			return function(n-1) + function(n-2);
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		System.out.println(function(n));
	}
}
