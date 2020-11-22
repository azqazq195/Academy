import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b4948 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder temp = new StringBuilder();
		StringBuilder sb = new StringBuilder();
		int max = 0;
		while(true) {
			String n = br.readLine();
			if(Integer.parseInt(n)==0) break;
			if(max<Integer.parseInt(n)) max = Integer.parseInt(n);
			
			temp.append(n+" ");
		}
		String s[] = temp.toString().split(" ");
		for(int i=0;i<s.length;i++) {
			decimalCount(Integer.parseInt(s[i]));
		}
		// 소수 계산
//		boolean[] b = new boolean[max*2+1];
//		b[0] = true;
//		b[1] = true;
//		for(int i=2; i<=max*2; i++) {
//			if(b[i]==true) continue;
//			for(int j=i; j<max*2; j+=j) {
//				if(b[i]==false) continue;
//				System.out.println("j = "+ j);
//				b[j]=true;
//			}
//		}
//		for(boolean r : b)
//			System.out.println(r);
	}
	public static int decimalCount(int num) {
		int result = 0;
		
		
		
		return result;
	}
}
