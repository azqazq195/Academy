import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b8958 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int num = Integer.parseInt(br.readLine());
		int score[] = new int[num];
		StringBuilder sb = new StringBuilder();
		
		for(int n=0; n<num; n++) {
			int count = 0;
			String s[] = br.readLine().split("");
			for(int i=0; i<s.length; i++) {
				if(s[i].equals("O")) {
					count++;
					score[n] += count;
				}
				else{
					count = 0;
				}
			}
			sb.append(score[n]+"\n");
		}
		
		System.out.println(sb);
		
	}
}
