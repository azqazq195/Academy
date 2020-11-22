import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b1002 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		
		for(int i = 0; i<n; i++) {
			String s[] = br.readLine().split(" ");
			int x1 = Integer.parseInt(s[0]);
			int y1 = Integer.parseInt(s[1]);
			int r1 = Integer.parseInt(s[2]);
			int x2 = Integer.parseInt(s[3]);
			int y2 = Integer.parseInt(s[4]);
			int r2 = Integer.parseInt(s[5]); 
			
			int d  = (x1-x2)*(x1-x2) + (y1-y2)*(y1-y2);
					
			int result = 0;
			
			if(d>(r1+r2)*(r1+r2)) result = 0;
			else if(d==(r1+r2)*(r1+r2)) {
				result = 1;
			}
			else if(d==0) {
				if(r1==r2) result = -1;
				else result = 0;
			}
			else if(d==(r1-r2)*(r1-r2)) {
				result = 1;
			}
			else if((r1-r2)*(r1-r2)<d && d<(r1+r2)*(r1+r2)) result = 2;
			else if(d<(r1-r2)*(r1-r2)) result = 0;
			sb.append(result+"\n");
		}
		
		
		
		System.out.println(sb);
	}
}
