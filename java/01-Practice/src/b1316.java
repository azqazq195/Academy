import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b1316 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		String str[] = new String[n];
		int result = 0;
		
		for(int i=0; i<n; i++) {
			str[i] = br.readLine();
			result +=groupCheck(str[i]);
		}
		System.out.println(result);
	}
	
	static int groupCheck(String str) {
		int count[] = new int[26];
		int result = 0;
		char temp=0;
		for(int i = 0; i<str.length(); i++) {
			if(i==0) {
				temp = str.charAt(i);
				continue;
			}
			if(temp == str.charAt(i)) {
				continue;
			} else {
				count[temp - 'a']++;
				temp = str.charAt(i);
			}
			
		}
		count[temp - 'a']++;
		
		for(int i : count) {
			if(i>1) {
				result = 0; break;
			}
			else result = 1;
		}
		
		return result;
	}
}
