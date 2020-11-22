import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
5
0 1 1 3 2 
*/

public class Main_백준_2605_줄세우기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		ArrayList<Integer> arrList = new ArrayList<Integer>();
		
		for(int i=1; i<=n; i++) {
			arrList.add(Integer.parseInt(st.nextToken()), i);
		}
		
		for(int i=arrList.size()-1; i>=0; i--) {
			System.out.print(arrList.get(i) + " ");
		}
		
		System.out.println(arrList.toString());
	}
}
