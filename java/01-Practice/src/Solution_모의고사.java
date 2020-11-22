import java.util.*;

public class Solution_모의고사 {
	public static void main(String[] args) {
		int answers[] = {1, 2, 3, 4, 5};
		int answers1[] = {1, 3, 2, 4, 2};
		
		for(int i : solution(answers1)) {
			System.out.println(i);
		}
		
	}
	
	public static int[] solution(int[] answer) {
        int[] a = {1, 2, 3, 4, 5};
        int[] b = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] c = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int score1 = 0;
        int score2 = 0;
        int score3 = 0;
        
        for(int i=0; i<answer.length; i++) {
            if(answer[i] == a[i%5]) score1++;
            if(answer[i] == b[i%8]) score2++;
            if(answer[i] == c[i%10]) score3++;
        }
        int maxScore = Math.max(score1, Math.max(score2, score3));
        ArrayList<Integer> list = new ArrayList<>();
        if(maxScore == score1) {list.add(1);}
        if(maxScore == score2) {list.add(2);}
        if(maxScore == score3) {list.add(3);}
        
        return list.stream().mapToInt(i->i.intValue()).toArray();
    }
}
