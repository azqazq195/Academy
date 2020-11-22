import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class b10989 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		
		int num[] = new int[10000];
		
		for(int i=0; i<n; i++) {
			num[Integer.parseInt(br.readLine())-1]++;
		}
		
		for(int i=0; i<num.length; i++) {
			if(num[i]==0) continue;
			for(int j=0; j<num[i]; j++) {
				bw.write(String.valueOf(i+1));
				bw.newLine();
			}
		}
		bw.flush();
		bw.close();
	}
}
