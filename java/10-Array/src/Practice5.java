
public class Practice5 {
	public static void main(String[] args) {		
		// 선언
		char[] alpha = new char[50];
		int[] cnt = new int[26];
		int min=65, max=90;
		// 입력
		for(int i=0; i<alpha.length; i++) {
			int rand = (int)(Math.random() * (max - min + 1) + min);
			alpha[i] = (char)rand;
		}
		// 연산
		for(int x=0; x<cnt.length; x++) {  		// 기준 26번 반복
			for(int y=0; y<alpha.length; y++) {	// 50번 반복
				if(alpha[y] == (65+x)) cnt[x]++;
			}
		}
		// 출력
		for(int i=0; i<alpha.length; i++) {
			if(i%10 == 0 && i!=0) System.out.println();
			System.out.print(alpha[i] + " ");			
		}
		System.out.println();
		for(int i=0; i<cnt.length; i++) {
			System.out.println((char)(65+i) + " : " + cnt[i]);
		}
	}
}







