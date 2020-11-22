import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b1978 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n[] = new int[Integer.parseInt(br.readLine())];
		String s[] = br.readLine().split(" ");
		int count = 0;
		for(int i=0; i<n.length; i++) {
			n[i] = Integer.parseInt(s[i]);
		}
		
		for(int i=0; i<n.length; i++) {
			boolean check = true;
			if(n[i]==1) continue;
			if(n[i]==2) {
				count++; 
				continue;
			}
			for(int j=2; j<n[i]; j++) {
				if(n[i]%j==0) {
					check = false;
					break;
				}
			}
			if(check == true) count++;
		}
		
		System.out.println(count);
		
	}
}
