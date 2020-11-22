import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b4948 {
	public static boolean[] prime = new boolean[246913];
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        // 소수 찾기 실행
        while(true) {
        	int num = Integer.parseInt(br.readLine());
        	if(num==0) break;
        	getPrime(num);
        	int count = 0;
        	for(int i = num+1; i <= num * 2; i++) {
        		if(!prime[i]) count++;
        	}
        	sb.append(count);
        	sb.append("\n");
        }
        System.out.println(sb.toString());
	}
	
	public static void getPrime(int num) {
		prime[0] = prime[1] = true;
		
		for(int i=2; i<=Math.sqrt(num*2); i++) {
			if(prime[i]) continue;
			for(int j=i*i; j<=num*2; j+=i) {
				prime[j] = true;
			}
		}
	}
}
