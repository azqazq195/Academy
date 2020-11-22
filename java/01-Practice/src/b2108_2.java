import java.util.Scanner;

public class b2108_2 {
	static void sort(int[] num, int[] count) {
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
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);		
		int n= sc.nextInt();
		int num[] = new int[n];
		int count[] = new int[n];
		
		for(int i=0;i<n;i++) {
			num[i] = sc.nextInt();
		}
		
		sort(num, count);
		
		for(int x=0; x<num.length ;x++) {
			System.out.print(num[x]+" ");
		}
		
		System.out.println();
		
		for(int x=0; x<num.length ;x++) {
			System.out.print(count[x]+" ");
		}
		
		
		
		
	}
}
