import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b2605 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		String s[] = br.readLine().split(" ");
		String line = "";
		String front = "";
		String back = "";
		
		for(int i=0; i<n; i++) {
			int num = Integer.parseInt(s[i]);
			num *= 2;
			
			front = line.substring(0, line.length()-num);
			back = line.substring(line.length()-num, line.length());
			
			line = front + (i+1) +" " + back;
		}
		
		System.out.println(line.trim());
	}
}
