package programmers;

public class ArrayKstNum {
	public static void main(String[] args) {
		Solution8 solution = new Solution8();
		
		int array[] = {1,5,2,6,3,7,4}; 
		int commands[][] = {{2,5,3},{4,4,1},{1,7,3}};
		System.out.println(solution.solution(array, commands));
	}
}

class Solution8 {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = {};
        
        for(int i=0; i<commands.length; i++) {
        	int num[] = new int[commands[i][1] - commands[i][0] + 1];
        	int x=0;
        	for(int j=commands[i][0] -1 ; j<commands[i][1]; j++) {
        		num[x] = array[j];
        		x++;
        	}
        	for(int j : num) {
        		System.out.println(j);
        	}
        	System.out.println();
        }
        
        return answer;
    }
}

class Solution9 {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = {};
        return answer;
    }
}