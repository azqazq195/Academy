import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b2908 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String num[] = br.readLine().split(" ");
		int number[] = new int[2];
		
		for(int j=0; j<number.length; j++) {
				number[j] = Integer.parseInt(Character.toString(num[j].charAt(2))+
						Character.toString(num[j].charAt(1))+
						Character.toString(num[j].charAt(0)));
		}
		
		System.out.println(number[0]>number[1] ? number[0] : number[1]);
	}
}
