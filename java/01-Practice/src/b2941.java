import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b2941 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s[] = br.readLine().split("");
		int count = 0;
		
		for(int i=0; i<s.length; i++) {
			if(i+2<s.length) {
				// dz=
				if(s[i].equals("d") && s[i+1].equals("z") && s[i+2].equals("=")) {
					i+=2;
					count++;
					continue;
				}
			}
			
			if(i+1<s.length){
				// c=, c-
				if(s[i].equals("c")) {
					if(s[i+1].equals("=")) {
						i++;
						count++;
						continue;
					}
					if(s[i+1].equals("-")) {
						i++;
						count++;
						continue;
					}
				}
				// d-
				if(s[i].equals("d") && s[i+1].equals("-")) {
					i++;
					count++;
					continue;
				}
				// lj
				if(s[i].equals("l") && s[i+1].equals("j")) {
					i++;
					count++;
					continue;
				}
				// nj
				if(s[i].equals("n") && s[i+1].equals("j")) {
					i++;
					count++;
					continue;
				}
				// s=
				if(s[i].equals("s") && s[i+1].equals("=")) {
					i++;
					count++;
					continue;					
				}
				// z=
				if(s[i].equals("z") && s[i+1].equals("=")) {
					i++;
					count++;
					continue;
				}
			}
				count++;
			
			// 종료
		}
		System.out.println(count);
	}
}
