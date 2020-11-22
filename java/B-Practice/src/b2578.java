import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b2578 {
	public static boolean bingoCheckMethod(int[][] bingo) {
		int bingoCheck = 0;
		boolean answer = false;
		// 행
		for(int i=0; i<5; i++) {
			if(bingo[i][0]==0&&
					bingo[i][1]==0&&
					bingo[i][2]==0&&
					bingo[i][3]==0&&
					bingo[i][4]==0) {
				bingoCheck++;
			}
		}
		
		// 열
		for(int i=0; i<5; i++) {
			if(bingo[0][i]==0&&
					bingo[1][i]==0&&
					bingo[2][i]==0&&
					bingo[3][i]==0&&
					bingo[4][i]==0) {
				bingoCheck++;
			}
		}
		
		// 대각선
		if(bingo[0][0]==0&&
				bingo[1][1]==0&&
				bingo[2][2]==0&&
				bingo[3][3]==0&&
				bingo[4][4]==0) {
			bingoCheck++;
		}
		
		if(bingo[0][4]==0&&
				bingo[1][3]==0&&
				bingo[2][2]==0&&
				bingo[3][1]==0&&
				bingo[4][0]==0) {
			bingoCheck++;
		}
		
		if(bingoCheck >= 3) answer = true;
		
		return answer;
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int bingo[][] = new int[5][5];
		int count = 0;
		boolean bingoCheck = false;
		
		for(int i=0; i<5; i++) {
			String[] s = br.readLine().split(" ");
			for(int k=0; k<5; k++) {
				bingo[i][k] = Integer.parseInt(s[k]);
			}
		}
		
		for(int i=0; i<5; i++) {
			String[] s = br.readLine().split(" ");
			for(int k=0; k<5; k++) {
				count++;
				int num = Integer.parseInt(s[k]);
				
				
				for(int a=0; a<5; a++) {
					for(int c=0; c<5; c++) {
						if(bingo[a][c] == num) {
							bingo[a][c] = 0;
							if(count >= 12) {
								bingoCheck = bingoCheckMethod(bingo);
							}
						}
						if(bingoCheck) break;
					}
					if(bingoCheck) break;
				}
				if(bingoCheck) break;
			}
			if(bingoCheck) break;
		}
		
		System.out.println(count);
	}
}
