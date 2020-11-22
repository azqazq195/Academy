import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b2869 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str[] = br.readLine().split(" ");
		int a = Integer.parseInt(str[0]);
		int b = Integer.parseInt(str[1]);
		int v = Integer.parseInt(str[2]);
		
		System.out.println((v-a)%(a-b) > 0 ? 2 + (v-a)/(a-b) : 1 + (v-a)/(a-b));
		
	}
}
