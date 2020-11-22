package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class StackAcrossBridgeTruck {
	public static void main(String[] args) {
		Solution6 solution = new Solution6();
		
		int bridge_length[] = {2, 100, 100};
		int weight[] = {10, 100, 100};
		int truck_weights[][] = {{7, 4, 5, 6},
				{10},
				{10,10,10,10,10,10,10,10,10,10}};
		
		
		solution.solution(bridge_length[0],
				weight[0],
				truck_weights[0]);
	}
}

class Solution6 {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> queTruck = new LinkedList<Integer>();
        Queue<Integer> queTime = new LinkedList<Integer>();
        
        for(int i : truck_weights) {
        	queTruck.offer(i);
        }
        answer++;
        queTime.offer(answer);
        int inBridge = queTruck.poll();
    	while(!queTruck.isEmpty()) {
    		System.out.println(queTruck.toString());
    		System.out.println(queTime.toString());
    		answer++;
    		
    		System.out.println(1);
    		if(queTruck.peek() + inBridge > weight) {
    			// 무게 초과
        		System.out.println(3);
    		} else {
    			// 초과 아닐때
    			System.out.println(4);
    			queTime.offer(answer);
    		}

    		if(queTime.peek() + bridge_length == answer) {
    			// 시간 다 됐을 때
        		System.out.println(2);
    			queTime.poll();
    			queTruck.poll();
    			System.out.println("answer : " + answer);
    			continue;
    		}

    		System.out.println("answer : " + answer);
    	}
        
        return answer;
    }
}