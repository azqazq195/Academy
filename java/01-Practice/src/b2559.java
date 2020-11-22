import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b2559 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String temp[] = br.readLine().split(" ");
		int n = Integer.parseInt(temp[0]);
		int k = Integer.parseInt(temp[1]);
		int sum = 0;
		int max = 0;
		int a;
		int num[] = new int[n];
		
		temp = br.readLine().split(" ");
		for(int i=0; i<n; i++) {
			a = Integer.parseInt(temp[i]);
			sum += a;
			if(i<k) {
				max = sum;
				continue;
			}
			sum -= Integer.parseInt(temp[i-k]);
			if(max < sum) max = sum;
		}
		System.out.println(max);
	}
}
