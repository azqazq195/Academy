import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b2669 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean square[][] = new boolean[101][101];
		int count = 0;
		String temp[];
		int x1, y1, x2, y2;
		
		for(int i=0; i<4; i++) {
			temp = br.readLine().split(" ");
			x1 = Integer.parseInt(temp[0]);
			y1 = Integer.parseInt(temp[1]);
			x2 = Integer.parseInt(temp[2]);
			y2 = Integer.parseInt(temp[3]);
			
			for(int k=x1; k<x2; k++) {
				for(int z=y1; z<y2; z++) {
					square[k][z]=true;
				}
			}
		}
		
		for(int i=0; i<101; i++) {
			for(int k=0; k<101; k++) {
				if(square[i][k]) count++;
			}
		}
		
		System.out.println(count);
		
	}
}
