import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b2108_2 {
	
	static void sort(int[] num) {
		for(int x=0; x<num.length-1; x++) {
			for(int y=x+1; y<num.length;y++) {
				if(num[x]>num[y]) {
					int temp1=num[x];
					num[x]=num[y];
					num[y]=temp1;
				}
			}
		}
	}
	
	static int avg(int[] num) {
		int sum=0;
		
		for(int i=0;i<num.length;i++) {
			sum+=num[i];
		}
		return (int)Math.floor((double)sum/num.length+0.5);
	}
	
	static int range(int[] num) {
		int range;
		if(num.length==1) range=0;
		else range = num[num.length-1]-num[0];
		return range;
	}
	
	static int middle(int[] num) {
		return num[num.length/2];
	}
	
	static int mode(int[] num, int[] count) {
		int first = 0, second = 0;
		int temp=0;
		
		// 숫자하나면 바로 뱉음
		if(num.length==1) {
			return num[0];
		}
		else {
			// 빈도수 측정
			for(int i=0;i<num.length; i++) {
				
				for(int j=0;j<num.length; j++) {
					if(num[i]==temp) continue;
					else {
						if(num[i]==num[j]) count[i]++;
					}
				}
				temp = num[i];
			}
		}
		
		// 빈도수 최댓값
		int maxValue=count[0];
		int maxNum=0;
		boolean MAX = false;
		boolean overlap = false;
		
		for(int i=1; i<count.length; i++) {
			if(maxValue==count[i]) {
				if(overlap==false) {
					first=maxNum;
					second=i;
					MAX=false;
					overlap = true;
				}
			}
			else if(maxValue<count[i]) {
				//최빈값 삽입
				maxValue = count[i];
				
				// 번호기억
				maxNum = i;
				MAX=true;
				overlap = false;
			}
		}
		
		if(MAX) return num[maxNum];
		else return num[second];
		
	}

	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	    int n = Integer.parseInt(reader.readLine());
		int num[] = new int[n];
		int count[] = new int[n];

		for(int i=0;i<n;i++) {
			num[i] = Integer.parseInt(reader.readLine());
		}

		sort(num);
		
		System.out.println(avg(num));
		System.out.println(middle(num));
		System.out.println(mode(num,count));
		System.out.println(range(num));
		
	}
}