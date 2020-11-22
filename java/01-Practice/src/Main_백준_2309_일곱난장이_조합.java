import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_����_2309_�ϰ�������_���� {
	private static int n;
	private static int r;
	private static int[] arr;
	
/*
20
7
23
19
10
15
25
8
13
*/
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// nCr ���� => 1 2 3 => 3C2 => 1 2, 1 3, 2 3
		// nPr ���� => 1 2 3 => 3P2 => 1 2, 1 3, 2 1, 2 3, 3 1, 3 2
		// 9������ �߿� 7�����̸� �̾ƾ� �ϴµ� => ���� 100�Ǹ� ��
		// 9C7�� ���� 100�� �Ǹ� ����
		
		n = 9;
		r = 7;
		
		arr = new int[n+1]; // 1������ 9�� ���� ����, 0�� �ε����� ��� ����
		
		for(int i=1; i<arr.length; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		for(int i=0; i<arr.length; i++) {
			System.out.println(arr[i] + " ");
		}
		
		int[] combArr = new int[r];
		combination(1, 0, combArr);
	}
	
	// 1 2 3 => 2��
	// 1 => 1,2 ���� ����
	//   => 1,3 ���� ����
	// 2 => 2,3 ���� ����
	//   => 2,1 �̹� �ִ°�
	// 3 => 3,1 �̹� �ִ°�
	//   => 3,2 �̹� �ִ°�
	private static void combination(int start, int index, int[] combArr) {
		// ���� �����ϰ� ���� �ϼ� �Ǹ� ��ģ���� 100���� Ȯ��
		if(r==index) {
			int sum = 0;
			for (int i=0; i<r; i++){
				sum += combArr[i];
			}
			if(sum)
			
			System.out.println(Arrays.toString(combArr));
			return;
		}
		
		for(int i=start; i<arr.length; i++) {
			combArr[index] = arr[i];
			combination(i+1, index+1, combArr);
		}
	}
}
