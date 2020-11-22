import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class b2309 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n[] = new int[9];
		int sum = 0;
		int out1 = 0;
		int out2 = 0;
		
		List<Integer> list = new ArrayList<Integer>();
		
		// 입력
		for(int i=0; i<9; i++) {
			n[i] = Integer.parseInt(br.readLine());
			sum += n[i];
		}
		
		// 두개를 빼서 100이 되게 만들기
		for(int i=0; i<8; i++) {
			for(int k=i+1; k<9; k++) {
				if((sum-n[i]-n[k])==100) {
					out1 = i;
					out2 = k;
					break;
				}
			}
		}
		
		// 두개 빼고 입력
		for(int i=0; i<9; i++) {
			if(i==out1 || i==out2) continue;
			list.add(n[i]);
		}
		// 정렬
		Collections.sort(list);
		
		for(int i : list) {
			System.out.println(i);
		}
		
		
	}
}
