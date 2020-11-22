
public class Exam1 {
	public static void main(String[] args) {
		long b=0, c=0;
		for(int a=1; a<=1000000000; a++) {
			if(a%5 == 0) b+=a;
			if(a%7 == 0) c+=a;
		}
		
		System.out.println("b=" + b + ", c=" + c);
	}
}
