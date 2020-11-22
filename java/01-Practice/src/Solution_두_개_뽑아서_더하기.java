import java.util.HashSet;
import java.util.Set;

public class Solution_두_개_뽑아서_더하기 {
	public static void main(String[] args) {
		int[] numbers = {2, 1, 3, 4, 1};
		int[] numbers1 = {5, 0, 2, 7};
		
		for(int a : solution(numbers)) {
			System.out.println(a);
		}
	}
	
    public static int[] solution(int[] numbers) {
    	int answer[] = {};
        Set<Integer> set = new HashSet<Integer>();
        for(int i=0; i<numbers.length; i++) {
        	for(int j=i+1; j<numbers.length; j++) {
        		set.add(numbers[i] + numbers[j]);
        	}
        }
        answer = set.stream().sorted().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}
