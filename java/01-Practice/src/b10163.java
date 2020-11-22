import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b10163 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int square[][] = new int[101][101];
		int n = Integer.parseInt(br.readLine());
		int x, y, width, height, count;
		int num = 0;
		while(n-->0) {
			num++;
			String temp[] = br.readLine().split(" ");
			
			x = Integer.parseInt(temp[0]);
			y = Integer.parseInt(temp[1]);
			width = Integer.parseInt(temp[2]);
			height = Integer.parseInt(temp[3]);
			
			for(int i=x; i<width+x; i++) {
				for(int j=y; j<height+y; j++) {
					square[i][j] = num;
				}
			}
		}
		
		for(int z=1; z<=num; z++) {
			count = 0;
			for(int i=0; i<101; i++) {
				for(int j=0; j<101; j++) {
					if(square[i][j] == z) count++;
				}
			}
			System.out.println(count);
		}
		
	}
}
