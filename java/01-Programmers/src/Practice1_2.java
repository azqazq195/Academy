package programmersPractice;

import java.util.HashMap;
import java.util.Map;

public class Practice1_2 {
	public static void main(String[] args) {
		String[] participant = {"mislav", "stanko", "mislav","ana"};
		String[] completion = {"stanko", "ana","mislav"};
		
		System.out.println(solution(participant, completion));
	}
	
	public static String solution(String[] participant, String[] completion) {
        Map<String, Integer> hm = new HashMap<>();
        for(String a : participant) hm.put(a, hm.getOrDefault(a, 0)+1);
        for(String a : completion) hm.put(a, hm.getOrDefault(a, 0)-1);
        for(String a : hm.keySet()){
            if(hm.get(a) != 0) return a;
        }

        return null;

    }
	
	
}

