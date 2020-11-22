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
		
		// �Է�
		for(int i=0; i<9; i++) {
			n[i] = Integer.parseInt(br.readLine());
			sum += n[i];
		}
		
		// �ΰ��� ���� 100�� �ǰ� �����
		for(int i=0; i<8; i++) {
			for(int k=i+1; k<9; k++) {
				if((sum-n[i]-n[k])==100) {
					out1 = i;
					out2 = k;
					break;
				}
			}
		}
		
		// �ΰ� ���� �Է�
		for(int i=0; i<9; i++) {
			if(i==out1 || i==out2) continue;
			list.add(n[i]);
		}
		// ����
		Collections.sort(list);
		
		for(int i : list) {
			System.out.println(i);
		}
		
		
	}
}
