import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
7 6
11

8 9
8
 */
public class b10157 {
	static int x = 1;
	static int y = 1;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s[] = br.readLine().split(" ");
		int c, r, k;
		c = Integer.parseInt(s[0]);
		r = Integer.parseInt(s[1]);
		k = Integer.parseInt(br.readLine());
		
		System.out.println(run(c, r, k));
	}
	
	public static String run(int c, int r, int k) {
		if(c*r < k) return "0";
		
		int count = 1;
		while(true) {
			k--;
			if(k==0) break;
			
			if(count<r) {
				y++;
			} else if(count < r + c - 1) {
				x++;
			} else if(count < 2*r + c - 2) {
				y--;
			} else if(count < 2*r + 2*c - 4) {
				x--;
			}
			else {
				run(c-2, r-2, k);
				y++;
				return x + " " + y;
			}
			count++;
		}
		
		
		return x + " " + y;
	}
}
