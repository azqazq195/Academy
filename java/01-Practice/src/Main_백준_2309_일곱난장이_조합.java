import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_백준_2309_일곱난장이_조합 {
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
		// nCr 조합 => 1 2 3 => 3C2 => 1 2, 1 3, 2 3
		// nPr 조합 => 1 2 3 => 3P2 => 1 2, 1 3, 2 1, 2 3, 3 1, 3 2
		// 9난장이 중에 7난장이를 뽑아야 하는데 => 합이 100되면 끝
		// 9C7의 합이 100이 되면 종료
		
		n = 9;
		r = 7;
		
		arr = new int[n+1]; // 1번부터 9번 까지 저장, 0번 인덱스는 사용 안함
		
		for(int i=1; i<arr.length; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		for(int i=0; i<arr.length; i++) {
			System.out.println(arr[i] + " ");
		}
		
		int[] combArr = new int[r];
		combination(1, 0, combArr);
	}
	
	// 1 2 3 => 2개
	// 1 => 1,2 조합 생성
	//   => 1,3 조합 생성
	// 2 => 2,3 조합 생성
	//   => 2,1 이미 있는거
	// 3 => 3,1 이미 있는거
	//   => 3,2 이미 있는거
	private static void combination(int start, int index, int[] combArr) {
		// 조합 생성하고 조합 완성 되면 합친다음 100인지 확인
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
