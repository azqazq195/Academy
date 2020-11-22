import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b1546 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		final int n = Integer.parseInt(br.readLine());
		final String[] s = br.readLine().split(" ");
		
		int max = 0;
		int score = 0;
		float sum = 0;
		
		for(int i=0; i<s.length;i++) {
			score = Integer.parseInt(s[i]);
			if(max<score) max = score;
			sum += score;
		}
		
		System.out.println(sum * 100 / max / n);
		
	}
}
