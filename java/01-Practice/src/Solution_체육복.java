
public class Solution_체육복 {
	public static void main(String[] args) {
		int n = 5;
		// 1, 2, 3, 4, 5
		int lost[] = {2, 4};
		// 1, 0, 3, 0, 5
		// int reserve[] = {1, 3, 5};
		int reserve[] = {3};
		
		// solution(n, lost, reserve); 
		System.out.println(solution(n, lost, reserve));
		
	}
	
    public static int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        
        int student[] = new int[n];
        
        // 전체 순회
        for(int i=0; i<n; i++) {
        	student[i]++;
        }
        // lost 적용
        for(int i=0; i<lost.length; i++) {
        	student[lost[i]-1]--;
        }
        // reserve 적용
        for(int i=0; i<reserve.length; i++) {
        	student[reserve[i]-1]++;
        }
        
        // 분배
        for(int i=0; i<n; i++) {
        	if(student[i] == 0) student = share(student, i);
        }
        
        for(int i : student) if(i>0) answer++;
        
        return answer;
    }
    
    public static int[] share(int[] student, int i) {
    	
    	if(i != 0) {
    		if(student[i-1] == 2) {
    			student[i-1]--;
    			student[i]++;
    			return student;
    		}
    	}
    	
    	if(i != student.length-1) {
    		if(student[i+1] == 2) {
    			student[i+1]--;
    			student[i]++;
    			return student;
    		}
    	}
    	
    	return student;
    }
}
