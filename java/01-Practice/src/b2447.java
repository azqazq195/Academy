import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b2447 {
	public static String[][] starMaker(int n) {
		String star[][] = new String[3][3];
		if(n==3) {
			for(int i=0; i<3; i++) {
				for(int k=0; k<3; k++) {
					if(i==1 && k==1) {
						star[i][k] = " ";
					} 
					else {
						star[i][k] = "*";
					}
				}
			}
		}
		
		else {
			for(int i=0; i<3; i++) {
				for(int k=0; k<3; k++) {
					if(i==1 && k==1) {
						star[i][k] = starMaker(n/3);
					} 
					else {
						star[i][k] = starMaker(n/3);
					}
				}
			}
		}
		
		return star;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		for(String[] ss : starMaker(n)) {
			for(String s : ss) {
				System.out.print(s);
			}
			System.out.println();
		}
	}
}
