package programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import static java.util.stream.Collectors.*;

public class HashFakeFace {
	public static void main(String[] args) {
		Solution2 solution = new Solution2();
		
		String clothes1[][] = {{"yellow_hat", "headgear"},
				{"blue_sunglasses", "eyewear"}, 
				{"green_turban", "headgear"}};
		String clothes2[][] = {{"crow_mask", "face"},
				{"blue_sunglasses", "face"}, 
				{"smoky_makeup", "face"}};
		
		System.out.println(solution.solution(clothes2));
	}
}

class Solution2 {
	public int solution(String[][] clothes) {
        int answer = 1;

        Map<String, Integer> clothesMap = new HashMap<>();
        for(int i = 0; i < clothes.length; i++) {
        	clothesMap.put(clothes[i][1], clothesMap.getOrDefault(clothes[i][1], 0) + 1);
        }
        for(int var : clothesMap.values()) {
        	answer *= (var+1);
        }
        return answer-1;
    }
}
