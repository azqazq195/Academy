import java.util.Scanner;

public class b10809 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String S = sc.next();
		
		int a[] = new int[26];
		for(int i=0; i<a.length;i++) {
			a[i]=-1;
		}
		
		//a=0
		for(int i=0; i<S.length(); i++) {
			if(a[(int)S.charAt(i)-97]==-1)a[(int)S.charAt(i)-97]=i;
		}
		
		for(int i=0; i<a.length;i++) {
			System.out.print(a[i]+" ");
		}
	}
}
