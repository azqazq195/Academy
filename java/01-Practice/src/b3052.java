import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b3052 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int num[] = new int[42];
		int count = 0;
		
		for(int i=0; i<10; i++)
			num[Integer.parseInt(br.readLine())%42]++;
		
		for(int i : num)
			if(i!=0) count++;
		
		System.out.println(count);
	}
}