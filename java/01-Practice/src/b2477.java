import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
7
4 50
2 160
3 30
1 60
3 20
1 100
 */
public class b2477 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int answer=0;
		int a[] = new int[6];
		int k = 0;
		
		for(int i=0; i<6; i++) {
			String s[] = br.readLine().split(" ");
			a[i] = Integer.parseInt(s[1]);
		}
		if(a[3]>a[1]) {
			answer = n*(a[1]*a[2] + a[4]*a[5]);
		}
		else if(a[5]>a[1] && a[5]>a[3]) {
			answer = n*(a[3]*a[4] + a[0]*a[1]);
		}
		else {
			answer = n*(a[0]*a[5]+a[2]*a[3]);
		}
		
		System.out.println(answer);
		
	}
}
