import java.io.*;
import java.util.*;

public class b1181_2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));		
		int n = Integer.parseInt(br.readLine());
		
		ArrayList<String> list = new ArrayList<>();
		
		for(int i=0;i<n;i++) {
			String str = br.readLine();
			if(list.contains(str)) continue;
			list.add(str);
		}
		

		Collections.sort(list, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				if(o1.length()==o2.length()) return o1.compareTo(o2);
				return o1.length() - o2.length();
				
			}
			
		});
		
		for(String s : list) {
			bw.write(s);
			bw.newLine();
		}
		bw.flush();
	}
}

