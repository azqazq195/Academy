import java.util.*;

public class Solution_나누어_떨어지는_숫자_배열 {
	public static void main(String[] args) {
		int[] arr = {5, 9, 7, 10};
		int divisor = 5;
		
		for(int i : solution(arr, divisor)) System.out.println(i);
	}
	
	public static int[] solution(int[] arr, int divisor) {
        List<Integer> list = new ArrayList<Integer>();
        for(int i : arr) {
        	if(i%divisor==0) list.add(i);
        }
        Collections.sort(list);
        if(list.size() == 0) list.add(-1);
        int[] answer = new int[list.size()];
        
        for(int i=0; i<answer.length; i++) {
        	answer[i] = list.get(i).intValue();
        }
        
        return answer;
    }
}
