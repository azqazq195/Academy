import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b2577 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int numCount[] = new int[10];
		
		int n = Integer.parseInt(br.readLine())*
				Integer.parseInt(br.readLine())*
				Integer.parseInt(br.readLine());
		
//		String num[] = String.valueOf(n).split("");
//		
//		for(String s : num) {
//			numCount[Integer.parseInt(s)]++;
//		}
//		
//		for(int i : numCount)
//			System.out.println(i);
		
		String temp = String.valueOf(n);
		
		for(int i=0; i<temp.length(); i++) {
			numCount[Integer.parseInt(temp.substring(i,i+1))]++;
		}
		
		for(int i : numCount)
			System.out.println(i);
	}
}
