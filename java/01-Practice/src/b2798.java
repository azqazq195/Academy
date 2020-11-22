import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b2798 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s[] = br.readLine().split(" ");
		
		int card[] = new int[Integer.parseInt(s[0])];
		int result = Integer.parseInt(s[1]);
		
		
		String num[] = br.readLine().split(" ");
		
		for(int i=0; i<card.length; i++) {
			card[i] = Integer.parseInt(num[i]);
		}
		
		int max = 0;
		
		for(int i=0; i<card.length; i++) {
			for(int j=0; j<card.length; j++) {
				if(i>=j) continue;
				for(int k=0; k<card.length; k++) {
					if(j>=k) continue;
					int sum = card[i] + card[j] + card[k];
					if(result >= sum && max<sum) max = sum;
				}
			}
		}
		
		System.out.println(max);
	}
}
