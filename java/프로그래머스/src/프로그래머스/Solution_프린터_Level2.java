package 프로그래머스;

import java.util.*;

public class Solution_프린터_Level2 {
	public static void main(String[] args) {
		int priorities[] = {2, 1, 3, 2};
		int location = 2;
		
		int priorities1[] = {1, 1, 9, 1, 1, 1};
		int location1 = 0;
		
		solution(priorities1, location1);
	}
	
	public static int solution(int[] priorities, int location) {
        int answer = 0;
        int length = priorities.length;
        
        List<Integer> print = new ArrayList<Integer>();
        List<Integer> index = new ArrayList<Integer>();
        List<Integer> max = new ArrayList<Integer>();
        
        for(int i=0; i<length; i++) {
        	print.add(priorities[i]);
        	max.add(priorities[i]);
        	index.add(i);
        }
        Collections.sort(max, Collections.reverseOrder());
        while(true) {
        	if(print.get(0) < max.get(0)) {
        		print.add(print.get(0));
        		index.add(index.get(0));
        		print.remove(0);
        		index.remove(0);
        	}
        	else if(print.get(0) == max.get(0)) {
        		answer++;
        		if(index.get(0) == location) break;
        		print.remove(0);
        		max.remove(0);
        		index.remove(0);
        	}
        }
        return answer;
    }
}
