
public class p123123 {
	public static void main(String[] args) {
		String s[] = {"aabbaccc",
				"ababcdcdababcdcd",
				"abcabcdede",
				"abcabcabcabcdededededede",
				"xababcdcdababcdcd"};
		int answer = 0;
		
		int count=0;
		String Overlap = "";
		
		if(s.length == 1) answer = 1;
		else {
			for(int i=0;i<s[0].length();i++) {
				for(int j=0;j<s[0].length();j++) {
					s[0].substring(i,i+j);				
				}
			}
		}
		
	}
}
