import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b3053 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int r = Integer.parseInt(br.readLine());
		double pi = Math.PI;
		
		System.out.println(r*r*Math.PI);
		System.out.println(2*r*r);
		
	}
}
