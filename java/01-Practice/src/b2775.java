import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b2775 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int num[][] = new int[n][2];
		int result[] = new int[n];
		
		int apt[][] = new int[15][14];

		for(int i=0; i<14; i++) {
			apt[0][i] = i+1;
		}
		
		for(int i=0; i<14; i++) {
			for(int j=0;j<14;j++) {
				for(int k=0; k<=j; k++) {
					apt[i+1][j] += apt[i][k];
				}
			}
		}
		
		for(int i=0; i<n; i++) {
			num[i][0] = Integer.parseInt(br.readLine());
			num[i][1] = Integer.parseInt(br.readLine());
			
			result[i] = apt[num[i][0]][num[i][1]-1];
		}
		
		for(int i : result)
			System.out.println(i);
	}
	
}
