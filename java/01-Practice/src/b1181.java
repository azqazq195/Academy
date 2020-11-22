import java.util.Scanner;

public class b1181 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		String str[] = new String[n];
		
		for(int i=0; i<str.length;i++) {
			str[i] = sc.next();
		}
		
		String tmp;
		
		for(int i=0; i<str.length;i++) {
			for(int j=0; j<str.length;j++) {
				if(i==j) continue;
				
				// 같은 길이 일시 정렬
				if(str[i].length()==str[j].length()) {
					for(int k=0;k<str[i].length();k++) {
						if(str[i].charAt(k)==str[j].charAt(k)) continue;
						if((int)str[i].charAt(k)<(int)str[j].charAt(k)) {
							tmp = str[j];
							str[j] = str[i];
							str[i] = tmp;
							break;
						}
					}
				}
				
				// 길이순 정렬
				if(str[i].length()<str[j].length()) {
					tmp = str[j];
					str[j] = str[i];
					str[i] = tmp;
				}
			}
		}
		
		// 출력
		System.out.println(str[0]);
		for(int i=1;i<str.length;i++) {
			if(str[i].equals(str[i-1])) continue;
			System.out.println(str[i]);
		}
	}
}
