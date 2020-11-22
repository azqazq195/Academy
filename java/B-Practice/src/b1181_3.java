import java.io.*;
import java.util.*;

public class b1181_3 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));		
		int n = Integer.parseInt(br.readLine());
		
		String[] str = new String[n];
		
		for(int i=0;i<n;i++) {
			str[i]=br.readLine();
		}
		

		Arrays.sort(str, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				if(o1.length()==o2.length()) return o1.compareTo(o2);
				return o1.length() - o2.length();
				
			}
			
		});
		
		for(int i = 0 ; i < n ; i++) {
			if(i+1 != n)
				if(str[i].equals(str[i+1])) continue;
			bw.write(str[i]);
			bw.newLine();
		}
		
		bw.flush();
	}
}

