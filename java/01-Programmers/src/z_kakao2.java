package programmers;

public class z_kakao2 {
	public static void main(String[] args) {
		Solution12 solution = new Solution12();
		
		String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
		int[] course = {2,3,4};
		
		System.out.println(solution.solution(orders, course));
	}
}

class Solution12 {
    public String[] solution(String[] orders, int[] course) {
        String[] answer = {};
        
        int count[] = new int[26];
        
        
        for(int i=0; i<orders.length; i++) {
        	for(int j=0; j<orders[i].length(); j++) {
        		count[orders[i].charAt(j)-65]++;
        	}
        }
        
        for(int i : count) {
        	System.out.println(i);
        }
        
        return answer;
    }
}