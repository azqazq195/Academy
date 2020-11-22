import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b10250 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int a = Integer.parseInt(br.readLine());
		int result[] = new int[a];
		for(int i = 0; i<a; i++) {
			String str[] = br.readLine().split(" ");
			
			int h = Integer.parseInt(str[0]);
			int w = Integer.parseInt(str[1]);
			int n = Integer.parseInt(str[2]);
			
			if(n%h==0) result[i] = h*100 + (n/h);
			else result[i] = (n%h)*100 + (n/h+1);
			
		}
		
		for(int i : result) System.out.println(i);
	}
}
