import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b2108 {
	// 평균
	static int avg(int[] num) {
		int sum=0;
		
		for(int i=0;i<num.length;i++) {
			sum+=num[i];
		}
		return (int)Math.floor((double)sum/num.length+0.5);
	}
	
	static int middle(int[] num, int[] count) {
		int sum=0;
		int no=0;
		for(int i=0;i<num.length;i++) {
			// 카운트
			count[num[i]+4000]++;
		}
		
		for(int i=0;i<count.length;i++) {
			sum+=count[i];
			if(sum>=(num.length/2+1)) {
				no=i;
				break;
			}
		}
		return no-4000;
	}
	
	static int range(int[] num) {
		int min = num[0];
		int max = num[0];
		
		for(int i=1;i<num.length;i++) {
			if(min>num[i]) min=num[i];
			if(max<num[i]) max=num[i];
		}
		return max-min;
	}
	
	static int mode(int[] num, int[] count) {
		
		
		for(int i=0;i<num.length;i++) {
			// 카운트
			count[num[i]+4000]++;
		}
		
		int no=0;
		int max=0;
		int first=0;
		int second=0;
		boolean overlap = true;
		
		for(int i=0;i<count.length;i++) {
			if(overlap==false) {
				if(max==count[i]) {
					first = no;
					second = i;
					overlap=true;
				}
			}
			if(max<count[i]) {
				max=count[i];
				no=i;
				overlap=false;
			}
		}
		
		if(overlap) return second-4000;
		else 		return no-4000;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	    int n = Integer.parseInt(reader.readLine());
	    
		int num[] = new int[n];
		int count[] = new int[8001];
		
		if(n==1) {
			num[0] = Integer.parseInt(reader.readLine());
			System.out.println(num[0]);
			System.out.println(num[0]);
			System.out.println(num[0]);
			System.out.println(0);
		}
		else {
			// 입력
			for(int i=0;i<num.length;i++) {
				num[i] = Integer.parseInt(reader.readLine());
			}
			
			System.out.println(avg(num));
			System.out.println(middle(num,count));
			System.out.println(mode(num,count));
			System.out.println(range(num));
		}
			
		
	
		
	}
}