package programmers;

import java.util.HashMap;
import java.util.TreeMap;

public class HashBestAlbum {
	public static void main(String[] args) {
		Solution3 solution = new Solution3();
		
		String genres[] = {"classic", "pop", "classic", "classic", "pop"};
		int plays [] = {500, 600, 150, 800, 2500};
		
		System.out.println(solution.solution(genres,plays));
	}
}

class Solution3 {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        
        HashMap<Integer, String> genresMap = new HashMap();
        HashMap<Integer, Integer> playsMap = new HashMap();
        
        TreeMap<Integer, String> genresPlays = new TreeMap();
        
        for(int i=0; i<genres.length; i++) {
        	genresMap.put(i, genres[i]);
        	playsMap.put(i, plays[i]);
        	
        	if(genresPlays.containsValue(genres[i])) {
        		int play = getKey(genresPlays, genres[i]);
        		genresPlays.remove(getKey(genresPlays, genres[i]));
        		genresPlays.put(play + plays[i],genres[i]);
        	} else {
        		genresPlays.put(plays[i], genres[i]);
        	}
        }
        genresPlays.put(2000, "ballad");
        System.out.println(genresMap);
        System.out.println(playsMap);
        System.out.println();
        System.out.println(genresPlays);
        System.out.println(genresPlays.lastEntry());
        System.out.println(genresPlays.size()); 
        
        return answer;
    }
    
    public <K, V> K getKey(TreeMap<K, V> map, V value) {
        for (K key : map.keySet()) {
            if (value.equals(map.get(key))) {
                return key;
            }
        }
        return null;
    }
}