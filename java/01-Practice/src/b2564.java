import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
10 5
3
1 4
3 2
2 8
2 3

10 5
1
1 9
4 1

5 10
1
3 2
4 9

5 10
1
3 2
1 4

5 10
1
3 2
2 4

6 6
1
3 3
4 3
 */
public class b2564 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String sizeString[] = br.readLine().split(" ");
		int x = Integer.parseInt(sizeString[0]);
		int y = Integer.parseInt(sizeString[1]);
		int temp = 0;
		
		int num = Integer.parseInt(br.readLine());
		
		int position[] = new int[num];
		int length[] = new int[num];
		
		for(int i=0; i<num; i++) {
			String s[] = br.readLine().split(" ");
			position[i] = Integer.parseInt(s[0]);
			length[i] = Integer.parseInt(s[1]);
		}
		
		String a[] = br.readLine().split(" ");
		int donguenPosition = Integer.parseInt(a[0]);
		int donguenLength = Integer.parseInt(a[1]);
		
		// 위치 조정
		if(donguenPosition==1) {
			donguenPosition=2;
			donguenLength=x-donguenLength;
			for(int i=0; i<num; i++) {
				if(position[i]==1) {
					position[i]=2;
					length[i] = x - length[i];
				}
				else if(position[i]==2) {
					position[i]=1;
					length[i] = x - length[i];
				}
				else if(position[i]==3) {
					position[i]=4;
					length[i] = y - length[i];
				}
				else if(position[i]==4) {
					position[i]=3;
					length[i] = y - length[i];
				}
			}
		}
		else if(donguenPosition==3) {
			temp = x;
			x = y;
			y = temp;
			donguenPosition=2;
			
			for(int i=0; i<num; i++) {
				if(position[i]==1) {
					position[i]=3;
					length[i] = y - length[i];
				}
				else if(position[i]==2) {
					position[i]=4;
					length[i] = y - length[i];
				}
				else if(position[i]==3) {
					position[i]=2;
				}
				else if(position[i]==4) {
					position[i]=1;
				}
			}
		}
		else if(donguenPosition==4) {
			temp = x;
			x = y;
			y = temp;
			donguenPosition=2;
			donguenLength=x-donguenLength;
			
			for(int i=0; i<num; i++) {
				if(position[i]==1) {
					position[i]=4;
				}
				else if(position[i]==2) {
					position[i]=3;
				}
				else if(position[i]==3) {
					position[i]=1;
					length[i] = x - length[i];
				}
				else if(position[i]==4) {
					position[i]=2;
					length[i] = x - length[i];
				}
			}
		}
		
		// 계산
		int sum = 0;
		for(int i=0; i<num; i++) {
			int answer = 0;
			if(position[i]==1) {
				answer = length[i] + donguenLength <= (x - length[i]) + (x - donguenLength) ?
						length[i] + donguenLength : (x - length[i]) + (x - donguenLength);
				answer = y + answer;
			}
			else if(position[i]==2) {
				answer = Math.abs(length[i] - donguenLength);
			}
			else if(position[i]==3) {
				answer = (y - length[i]) + donguenLength;
			}
			else if(position[i]==4) {
				answer = (y - length[i]) + (x - donguenLength);
			}
			sum += answer;
		}
		
		System.out.println(sum);
	}
}
