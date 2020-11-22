import java.util.Scanner;

public class b10817 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num[] = new int[3];
		
		for(int i=0;i<3;i++) {
			num[i]=sc.nextInt();
		}
		
		// 최대값 구하기
		int max = num[0];
		int min = num[0];
		for(int i=0;i<3;i++) {
			if(max<num[i]) max=num[i];
			if(min>num[i]) min=num[i];
		}
		
		// 최대값보다 작은 수
		int answer = 0;
		int countMax = 0;
		int countMin = 0;
		
		for(int i=0;i<3;i++) {
			if(max==num[i]) countMax++;
			if(min==num[i]) countMin++;
			if(max>num[i] && min<num[i]) {
				answer = num[i];
				break;
			}
			if(countMax==2 || countMin==2) {
				answer = num[i];
				break;
			}
		}
		
		System.out.println(answer);
		
		
		
		
		
	}
}
