import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b9020 {
	public static boolean[] prime = new boolean[10001];
	public static void getPrime() {
		// false 이면 소수
		prime[0] = prime[1] = true;
		for(int i=2; i<=Math.sqrt(prime.length); i++) {
			if(prime[i]) continue;
			for(int j=i*i; j<prime.length; j+=i) {
				prime[j] = true;
			}
		}
		
	}
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        while(n-->0) {
        	int num = Integer.parseInt(br.readLine());
        	int halfNum = num/2;
        	
        	int lowIndex = halfNum;
        	int highIndex = halfNum;
        	
        	int lowNum = 0;
        	int highNum = 0;
        	
        	// 소수 구하기 실행
        	getPrime();
        	
//        // 소수 출력
//        for(int i=0; i<prime.length; i++) {
//        	if(!prime[i]) System.out.println(i);
//        }
        	
        	while(lowNum+highNum != num) {
        		
        		if(!prime[lowIndex]) lowNum = lowIndex;
        		if(!prime[highIndex]) highNum = highIndex;
        		
        		lowIndex--;
        		highIndex++;
        	}
        	sb.append(lowNum + " " + highNum + "\n");
        }
        System.out.println(sb);
	}
}
