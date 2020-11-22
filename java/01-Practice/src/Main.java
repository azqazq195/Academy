import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int t = Integer.parseInt(br.readLine());
		
		for(int i=1;i<=t;i++) {
			String[] temp = br.readLine().split(" ");
			bw.write("Case #" + i + ": "+ (Integer.parseInt(temp[0])+Integer.parseInt(temp[1]))+"\n");
		}
		bw.flush();
		bw.close();
		
	}
}
