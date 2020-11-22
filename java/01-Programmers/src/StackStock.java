package programmers;

public class StackStock {
	public static void main(String[] args) {
		Solution4 solution = new Solution4();
		
		int prices[] = {1,2,3,2,3};
		int prices1[] = {1,2,3,2,1,4,4,5,3,2,1};
		
		System.out.println(solution.solution(prices1));
	}
}

class Solution4 {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        for(int i = 0; i < prices.length; i++) {
        	if(i == prices.length-1) break;
        	for(int j = i+1; j < prices.length; j++) {
    			answer[i]++;
    			if(prices[i] > prices[j]) break;
        	}
        }
        return answer;
    }
}