import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b1157 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] s = br.readLine().toCharArray();
		int count[] = new int[26];
		int maxValue = 0;
		int max = 0;
		char maxChar = 0;
		
		for(char c : s) {
			if(c>96) c -= 32;
			count[c-65]++;
			if(max<count[c-65]) {
				max = count[c-65];
			}
		}
		int j = 0;
		for(int i=0; i<count.length; i++)
			if(count[i]==max) {
				maxValue++;
				maxChar = (char)(i+65);
				j=i;
			}
		
		if(maxValue>1)
			System.out.println("?");
		else {
			System.out.println(maxChar);
		}
			
	}
}
