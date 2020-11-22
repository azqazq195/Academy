import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b13458 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br.readLine();
		
		String candidateString[] = br.readLine().split(" ");
		String viewerString[] = br.readLine().split(" ");
		
		int candidate[] = new int[candidateString.length];
		int viewer[] = new int[viewerString.length];
		
		int count = 0;
		
		for(int i=0; i<candidateString.length; i++) {
			candidate[i] = Integer.parseInt(candidateString[i]);
		}
		for(int i=0; i<viewerString.length; i++) {
			viewer[i] = Integer.parseInt(viewerString[i]);
		}
		
		for(int i=0; i<candidate.length; i++) {
			candidate[i] = candidate[i] - viewer[0];
			count++;
			if(candidate[i] > 0) {
				count += (candidate[i]+viewer[1]-1)/viewer[1];
			}
		}
		System.out.println(count);
	}
}
