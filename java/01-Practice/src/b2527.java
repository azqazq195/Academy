import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
3 10 50 60 100 100 200 300
45 50 600 600 400 450 500 543
11 120 120 230 50 40 60 440
35 56 67 90 67 80 500 600
 */


public class b2527 {
	static boolean continuity;
	static int count;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i=0; i<4; i++) {
			String s[] = br.readLine().split(" ");
			System.out.println(square(s));
			System.out.println();
		}
		
	}
	public static int find(int x, int y, int p, int q, boolean square[][]) {
		continuity = false;
		count = 0;
		int temporaryCount;
		for(int i=x; i<=p; i++) {
			temporaryCount = 0;
			for(int k=y; k<=q; k++) {
				if(square[k][i]==true) {
					temporaryCount++;
					if(k>0) {
						if(square[k-1][i]) {
							continuity = true;
							System.out.println("temporaryCount : " + temporaryCount);
							return count;
						}
					}
				}
				count = temporaryCount;
			}
		}
		return count;
	}
	public static String square(String s[]) {
		boolean square[][] = new boolean[50001][50001];
		String answer = "";
		int x,y,p,q;
		
		x = Integer.parseInt(s[0]);
		y = Integer.parseInt(s[1]);
		p = Integer.parseInt(s[2]);
		q = Integer.parseInt(s[3]);
		
		for(int i=x; i<=p; i++) {
			for(int k=y; k<=q; k++) {
				square[k][i] = true;
			}
		}
		
		x = Integer.parseInt(s[4]);
		y = Integer.parseInt(s[5]);
		p = Integer.parseInt(s[6]);
		q = Integer.parseInt(s[7]);
		
		find(x,y,p,q,square);
		System.out.println(count);
		System.out.println(continuity);
		
		if(count > 0 && continuity && count != 1) {
			answer = "a";
		} 
		else if((count > 0 && !continuity)
				||
				(count == 1 && continuity)) {
			answer = "b";
		}
		else if(count > 0 && continuity) {
			answer = "c";
		}
		else if(count==0){
			answer = "d";
		}
		
		
		
		
		
		return answer;
	}
}
