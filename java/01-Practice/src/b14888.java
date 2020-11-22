import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class b14888 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		int num[] = new int[n];
		int op[] = new int[4];
		
		for(int i=0; i<num.length;i++) {
			num[i] = Integer.parseInt(br.readLine());
		}
		
		for(int i=0; i<op.length;i++) {
			op[i] = Integer.parseInt(br.readLine());
		}
		
		for(int i=0; i<num.length;i++) {
			bw.write(String.valueOf(num[i]));
			bw.newLine();
		}
		
		bw.newLine();
		
		for(int i=0; i<op.length;i++) {
			bw.write(String.valueOf(op[i]));
			bw.newLine();
		}
		
		bw.flush();
		bw.close();
		
		
	}
}
