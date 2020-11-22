import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b3009 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String a[] = br.readLine().split(" ");
		String b[] = br.readLine().split(" ");
		String c[] = br.readLine().split(" ");
		
		String result[] = new String[2];
		
		for(int i=0; i<2; i++) {
			if(a[i].equals(b[i])) result[i] = c[i];
			else if(a[i].equals(c[i])) result[i] = b[i];
			else result[i] = a[i];
		}
		
		System.out.print(result[0] + " " + result[1]);
	}
}
