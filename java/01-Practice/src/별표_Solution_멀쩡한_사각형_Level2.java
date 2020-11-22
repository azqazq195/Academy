import java.math.BigInteger;

public class 별표_Solution_멀쩡한_사각형_Level2 {
	public static void main(String[] args) {
		int w = 8;
		int h = 12;
		
		System.out.println(solution(w, h));
	}
	
	public static long solution(int w, int h) {
        long answer = 1;
        
        BigInteger a = BigInteger.valueOf(w);
        BigInteger b = BigInteger.valueOf(h);
        BigInteger gcd = a.gcd(b);
        
        w = w/gcd.intValue();
        h = h/gcd.intValue();
        
        answer = (long) (w*gcd.intValue())*(h*gcd.intValue()) - (w+h-1)*gcd.intValue();
        
        return answer;
    }
}
