import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b2562 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int max = 0;
		int count = 0;
		
		for(int i=0;i<9;i++) {
			int n = Integer.valueOf(br.readLine());
			if(max<n) {
				max = n;
				count = i+1;
			}
		}
		
		System.out.println(max);
		System.out.println(count);
	}
}
	
//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		
//		int num[] = new int[101];
//		
//		int count=1;
//		int maxNum = count;
//		int max = Integer.parseInt(br.readLine());
//		num[max]++;
//		for(int i=0;i<8;i++) {
//			count++;
//			int n = Integer.parseInt(br.readLine());
//			if(max<n) {
//				max = n;
//				maxNum = count;
//			}
//			num[n]++;
//		}
//		
//		System.out.println(max);
//		System.out.println(maxNum);
//		
//		
//	}
//}
