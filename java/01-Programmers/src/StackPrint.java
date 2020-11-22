package programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class StackPrint {
	public static void main(String[] args) {
		Solution7 solution = new Solution7();
		
		int priorities[] = {2, 1, 3, 2};
		int location = 2;
		
		int priorities1[] = {1,1,9,1,1,1};
		int location1 = 0;
		
		solution.solution(priorities1, location1);
		
	}
}

class Solution7 {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        
        for(int priority:priorities) pq.offer(priority);
        
        while(!pq.isEmpty()) {
        	for(int i = 0; i< priorities.length; i++) {
        		if(pq.peek() == priorities[i]) {
        			pq.poll();
        			answer++;
        			if(location == i) {
        				pq.clear();
        				break;
        			}
        		}
        	}
        }
        System.out.println(answer);
        return answer;
    }
}