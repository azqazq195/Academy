import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b1085 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s[] = br.readLine().split(" ");
		int x = Integer.parseInt(s[0]);
		int y = Integer.parseInt(s[1]);
		int w = Integer.parseInt(s[2]);
		int h = Integer.parseInt(s[3]);
		
		int min = x;
		if(min > y) min = y;
		if(min > (w-x)) min = (w-x);
		if(min > (h-y)) min = (h-y);
		
		System.out.println(min);
		
				
	}
}
