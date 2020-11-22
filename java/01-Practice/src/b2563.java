import java.io.*;

/*
3
3 7
15 7
5 2
 */
public class b2563 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean mainPaper[][] = new boolean[101][101];
		int n = Integer.parseInt(br.readLine());
		int count = 0;
		while(n>0) {
			String s[] = br.readLine().split(" ");
			
			int column = Integer.parseInt(s[0]);
			int row = Integer.parseInt(s[1]);
			
			for(int i=0; i<10; i++) {
				for(int k=0; k<10; k++) {
					mainPaper[column+i][row+k] = true;
				}
			}
			n--;
		}
		for(int i=0; i<101; i++) {
			for(int k=0; k<101; k++) {
				if(mainPaper[i][k]==true) count++;
			}
		}
		System.out.println(count);
	}
}
