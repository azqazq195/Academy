import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
9
1 2 2 4 4 5 7 7 2

9
4 1 3 3 2 2 9 2 3

10
1 5 3 6 4 7 1 3 2 9 5
 */

public class b2491 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int count = 1;
		// 카운트 셋던것 중에 가장 큰 수(큰 수 버전)
		int countMax = 0;
		// 카운트 셋던것 중에 가장 큰 수(작은 수 버전)
		int countMin = 0;
		int answer = 0;
		
		// 숫자 입력
		int num[] = new int[n];
		String s[] = br.readLine().split(" ");
		
		for(int i=0; i<n; i++) {
			num[i] = Integer.parseInt(s[i]);
		}
		
		/** 커지는 수 **/
		for(int i=0; i<n; i++) {
			// 첫번째 일경우 패스
			if(i==0) {
				continue; 
			}
			
			if(num[i] >= num[i-1]) {
				count++;
			}
			else {
				if(countMax < count) {
					countMax = count;
				}
				count=1;
			}
		}
		if(countMax < count) {
			countMax = count;
		}

		
		/** 작아지는 수 **/
		count = 1;
		for(int i=0; i<n; i++) {
			// 첫번째 일경우 패스
			if(i==0) {
				continue; 
			}
			
			if(num[i] <= num[i-1]) {
				count++;
			}
			else {
				if(countMin < count) {
					countMin = count;
				}
				count=1;
			}
		}
		if(countMin < count) {
			countMin = count;
		}
		
		answer = countMax >= countMin ? countMax : countMin;
		System.out.println(answer);
	}
}
