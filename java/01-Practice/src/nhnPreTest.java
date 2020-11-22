import java.io.*;
import java.util.*;

/*
6
1 0 1 0 0 0
1 1 1 0 1 1
0 0 0 0 1 1
0 0 0 0 1 1
1 1 0 0 1 0
1 1 1 0 0 0
*/


public class nhnPreTest {
	static int num;
	static String arrayString[][];
	static int array[][];
	static boolean check[][];
	static int count = 0;
	static List<Integer> answer = new ArrayList<Integer>();
	
	public static void main(String[] args) throws Exception{
		StringBuilder sb = new StringBuilder();
		input();
		print();
		solve();
		Collections.sort(answer);
		
		System.out.println();
		System.out.println("--정답--");
		if(answer.size() == 0){
			System.out.println("0");
		} else {
			System.out.println(answer.size());
			for(int i=0; i<answer.size(); i++) {
				sb.append(answer.get(i) + " ");
			}
			System.out.println(sb.toString().trim());
		}
	}
	
	public static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		num = Integer.parseInt(br.readLine());
		
		arrayString = new String[num][num];
		array = new int[num][num];
		check = new boolean[num][num];
		
		for(int i=0; i<num; i++) {
				arrayString[i] = br.readLine().split(" "); 
		}
		
		for(int i=0; i<num; i++) {
			for(int j=0; j<num; j++) {
				array[i][j] = Integer.parseInt(arrayString[i][j]); 
			}
		}
	}
	
	public static void solve() {
		for(int i=0; i<num; i++) {
			for(int j=0; j<num; j++) {
				if(!check[i][j]) {
					check[i][j] = true;
					if(array[i][j]==1) {
						search(i, j);
						answer.add(count);
						count = 0;
					}
				}
			}
		}
	}
	
	public static void search(int i, int j) {
		// 1을 만난 줄을 탐색(좌, 우)
//		array[i][j] = 0;
//		check[i][j] = true;
		
		int temp;
		
		// 오른쪽 탐색
		for(temp = j ; temp < num; temp++) {
			if(array[i][temp]==1) {
				System.out.println("오른쪽 탐색");
				System.out.println("i, temp : " + i + ", " + temp);
				count++;
				check[i][temp] = true;
			} else {
				break;
			}
		}
		System.out.println();
		
		// 왼쪽 탐색
		for(temp = j-1; temp>=0; temp--) {
			if(array[i][temp]==1) {
				System.out.println("왼쪽 탐색");
				System.out.println("i, temp : " + i + ", " + temp);
				count++;
				check[i][temp] = true;
			} else {
				break;
			}
		}
		System.out.println();
		
		// 한칸 내려가기
		if(i + 1 < num) {
			for(temp = j ; temp < num; temp++) {
				if(check[i][temp]) {
					if(array[i+1][temp]==1) {
						System.out.println("한칸 내려가기");
						System.out.println();
						search(i+1, temp);
						break;
					}
				} else {
					return;
				}
			}
		} else {
			// 배열 끝에 도달시 리턴
			return;
		}
	}
	
	public static void print() {
		for(int i=0; i<num; i++) {
			for(int j=0; j<num; j++) {
				System.out.print(array[i][j] + " "); 
			}
			System.out.println();
		}
	}
}
