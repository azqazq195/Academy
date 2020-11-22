import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b1929 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String s[] = br.readLine().split(" ");
		
		int a = Integer.parseInt(s[0]);
		int b = Integer.parseInt(s[1]);
	
		boolean[] decimal = new boolean[b+1];
		decimal[1] =true;
		for(int i=2; i<=b; i++) {
			if(decimal[i]==true) continue;
			if(i>=a) sb.append(i+"\n");
			
			for(int j=i*i; j<=b; j+=i) {
				if(j==i) continue;
				if(j%i==0) decimal[j]=true;
			}
		}
			
		System.out.println("결과 : "+sb);
		
	}
}