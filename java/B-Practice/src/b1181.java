import java.io.*;
import java.util.*;

public class b1181 {
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
		
		Com comparator = new Com();
		Collections.sort(list, comparator);
		
		for(String s : list) {
			bw.write(s);
			bw.newLine();
		}
		bw.flush();
	}
}

class Com implements Comparator<String>{
	@Override
	public int compare(String o1, String o2) {
		if(o1.length()>o2.length()) return 1;
		else if(o1.length()==o2.length()) {
			for(int i=0; i<o1.length();i++) {
				if(o1.charAt(i)==o2.charAt(i)) {
					continue;
				}
				if(o1.charAt(i) < o2.charAt(i)) {
					return -1;
				}
				else return 1;
			}
		}
		else return -1;
		return 0;
	}
	
}