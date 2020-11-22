import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b1152 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		String str = br.readLine().trim();
		String s[] = str.split(" ");
		if(str.isEmpty())
			System.out.println("0");
		else
			System.out.println(s.length);
	}
}
