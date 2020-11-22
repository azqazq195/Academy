package programmers;

public class SkillCheck_1_1 {
	public static void main(String[] args) {
		Solutions1 solution = new Solutions1();
		
		int x = -4;
		int n = 2;
		
		solution.solution(x, n);
		
	}
}

class Solutions1 {
    public long[] solution(int x, int n) {
        long[] answer = new long[n];
        
        int num = x;
        for(int i=0; i<n; i++) {
        	answer[i] = x;
        	x +=num;
        }
        
        for(long l : answer) {
        	System.out.println(l);
        }
        
        return answer;
    }
}