import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b4344 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int C = Integer.parseInt(br.readLine());	// 테스트 케이스 수 C
		int n[] = new int[C];						// 테스트 케이스 배열	
		float result[] = new float[C];
		
		for(int i=0; i<n.length; i++) {
			int sum = 0;
			int count = 0;
			int avg = 0;
			
			String s[] = br.readLine().split(" ");	//s[0]은 숫자 개수
			int score[] = new int[Integer.parseInt(s[0])];
			
			// 점수 넣기 s[0] 제외
			for(int j=0; j<score.length; j++) {
				score[j] = Integer.parseInt(s[j+1]);
				sum += score[j];
			}
			
			avg = sum / Integer.parseInt(s[0]);
			
			// 평균 넘는지 갯수 s[0]제외
			for(int j=0; j<score.length; j++) {
				if(avg<score[j]) count++;
			}
			
			result[i] = (float)count / (Integer.parseInt(s[0]));
		}
		for(float f : result)
			System.out.printf("%.3f%%\n",f*100);
		
	}
}
