import java.io.BufferedReader;
import java.io.InputStreamReader;

// 0 1 => 여자, 1학년
// 1 6 => 남자, 6학년

/*
16 2
1 1
0 1
1 1
0 2
1 2
0 2
0 3
1 3
1 4
1 3
1 3
0 6
1 5
0 5
1 5
1 6
 */
public class b13300 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int stu[][] = new int[2][6];
		String temp[] = br.readLine().split(" ");
		
		int num = Integer.parseInt(temp[0]);
		int k = Integer.parseInt(temp[1]);
		int sum = 0;
		
		while(num-->0) {
			temp = br.readLine().split(" ");
			stu[Integer.parseInt(temp[0])][Integer.parseInt(temp[1])-1]++;
		}
		
		for(int i=0;i<2;i++) {
			for(int j=0;j<6;j++) {
				sum += (stu[i][j]+(k-1)) / k;
			}
		}
		System.out.println(sum);
		
	}
}
