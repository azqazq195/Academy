import java.util.LinkedList;
import java.util.Queue;

public class Solution_같은_숫자는_싫어 {
	public static void main(String[] args) {
		int arr[] = {1,1,3,3,0,1,1};
		int arr1[] = {4,4,4,3,3};
		for(int i : solution(arr1)) System.out.println(i);
	}
	
    public static int[] solution(int []arr) {
      	Queue<Integer> que = new LinkedList<Integer>();
      	
      	int count = 1;
      	int temp = 0;
      	que.offer(arr[0]);
      	temp = arr[0];
      	while(count<arr.length) {
      		if(arr[count] == temp) {
      			count++;
      			continue;
      		} else {
      			temp = arr[count];
      			que.offer(temp);
      			count++;
      		}
      	}
      	
      	int[] answer = new int[que.size()];
      	count = 0;
      	while(!que.isEmpty()) {
      		answer[count] = que.poll();
      		count++;
      	}
        return answer;
    }
	
}
