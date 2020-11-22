import java.util.*;

public class Solution_K번째수 {
	public static void main(String[] args) {
	
		int[] array = {1, 5, 2, 6, 3, 7, 4};
		int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
		
		for(int a : solution(array, commands)) {
			System.out.println(a);
		}
	}
	
    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        List<Integer> list;
        for(int a=0; a<commands.length; a++) {
        	list = new ArrayList<>();
        	for(int i=commands[a][0]-1; i<commands[a][1]; i++) {
        		list.add(array[i]);
        	}
        	Collections.sort(list);
        	answer[a] = list.get(commands[a][2]-1);
        }
        
        return answer;
    }
}
