import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b2675 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		String[] result = new String[n];
		
		for(int i=0; i<n; i++) {
			result[i] = "";
			String[] string = br.readLine().split(" ");
			int rep = Integer.parseInt(string[0]);
			
			String[] temp = string[1].split("");
			for(int j=0; j<temp.length;j++) {
				for(int k=0; k<rep;k++) {
					result[i] += temp[j];
				}
			
			}
		}
		for(String s : result)
			System.out.println(s);
	
		
		
	}
}
