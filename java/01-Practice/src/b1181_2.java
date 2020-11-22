import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class b1181_2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		List<String> list = new ArrayList<String>();
		
		for(int i=0;i<n;i++) {
			String s = sc.next();
			if(list.contains(s)) continue;
			list.add(s);
		}
		
		Com comparator = new Com();
		Collections.sort(list, comparator);
		
		for(String s : list) {
			System.out.println(s);
		}
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