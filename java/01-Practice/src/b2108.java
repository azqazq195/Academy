import java.util.Scanner;

public class b2108 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int i;
		int res1, res2, res3, res4;
		res3=0;
		int sum=0;
		i = sc.nextInt();
		int num[] = new int[i];
		int count[] = new int[i];
		
		
		num[0] = sc.nextInt();
		sum += num[0];
		
		if(i>1) {
			count[0]=1;
			for(int x=1; x<num.length ;x++) {
				num[x] = sc.nextInt();
				sum += num[x];
				for(int y=0;y<num.length;y++) {
					if(num[y]==num[x]) count[x]++;
				}
			}
			
			
			for(int x=0; x<num.length-1; x++) {
				for(int y=x+1; y<num.length;y++) {
					if(num[x]>num[y]) {
						int temp1=num[x];
						num[x]=num[y];
						num[y]=temp1;
						
						int temp2=count[x];
						count[x]=count[y];
						count[y]=temp2;
					}
				}
			}
			
			res4 = num[num.length-1]-num[0];
		}
		else {
			res3 = num[0];
			res4 = 0;
			}
	
		
		
		
		
		
		res1 = sum / num.length;
		res2 = num[num.length/2];
		
		System.out.println(res1);
		System.out.println(res2);
		System.out.println(res3);
		System.out.println(res4);
		
		for(int x=0; x<num.length ;x++) {
			System.out.print(num[x]+" ");
		}
		System.out.println();
		for(int x=0; x<num.length ;x++) {
			System.out.print(count[x]+" ");
		}
		
		
		
	}
}
