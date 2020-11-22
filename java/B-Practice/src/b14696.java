import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
5
1 4
4 3 3 2 1
5 2 4 3 2 1
4 4 3 3 1
4 3 2 1 1
4 2 3 2 1
4 4 3 2 1
3 4 3 2
5 4 4 2 3 1
5 4 2 4 1 3
 */

// 별 개수 => 동그라미 개수 => 네모 개수 => 세모 개수 => 무승부
// 별 : 4, 동그라미 : 3, 네모 : 2, 세모 : 1
public class b14696 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		String temp[];
		int aCard[];
		int bCard[];
		
		for(int i=0; i<n; i++) {
			temp = br.readLine().split(" "); 
			aCard = new int[5];
			for(int k=0; k<Integer.parseInt(temp[0]); k++) {
				aCard[Integer.parseInt(temp[k+1])]++;
			}
			temp = br.readLine().split(" "); 
			bCard = new int[5];
			for(int k=0; k<Integer.parseInt(temp[0]); k++) {
				bCard[Integer.parseInt(temp[k+1])]++;
			}
			
			for(int k=4; k>0; k--) {
				if(aCard[k] > bCard[k]) {
					sb.append("A\n");
					break;
				}
				else if(aCard[k] == bCard[k]) {
					if(k==1) sb.append("D\n");
					continue;
				}
				else {
					sb.append("B\n");
					break;
				}
			}
		}
		System.out.println(sb);
	}
}
