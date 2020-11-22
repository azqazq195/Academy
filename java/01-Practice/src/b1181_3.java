import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class b1181_3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		String str[] = new String[n];
		
		for(int i=0; i<str.length;i++) {
			str[i] = sc.next();
		}
		
		Arrays.sort(str, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.length() > o2.length() ? 1 : -1;
			}
		});
		
		Arrays.sort(str, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				if(o1.length()==o2.length()) {
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
				return 1;
			}
		});
		
		// 출력
		System.out.println(str[0]);
		for(int i=1;i<str.length;i++) {
			if(str[i].equals(str[i-1])) continue;
			System.out.println(str[i]);
		}
	}
}
