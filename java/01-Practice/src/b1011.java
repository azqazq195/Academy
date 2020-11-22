import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b1011 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int range[] = new int[n];
		int count[] = new int[n];
		
		for(int x=0; x<n; x++) {
			String s[] = br.readLine().split(" ");
			range[x] = Integer.parseInt(s[1])-Integer.parseInt(s[0]);
		}
		
		for(int i=0; i<range.length; i++) {
			if(range[i]==1) {
				count[i]=1;
				continue;
			} else if(range[i]==2) {
				count[i]=2;
				continue;
			} else {
				int num = (int)Math.sqrt(range[i]);
				if(num*num==range[i]) {
					count[i]=2*num-1;
					continue;
				}
				else if(num*num+num>=range[i]) {
					count[i]=2*num;
					continue;
				}
				else {
					count[i]=2*num+1;
					continue;
				}
			}
			
		}
		
		for(int i : count) {
			System.out.println(i);
		}
	}
}
