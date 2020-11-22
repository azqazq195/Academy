import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class Exam_HashMap {
	public static void main(String[] args) {
		HashMap<String, String> map1;
		map1 = new HashMap<String, String>();		// HashMap 생성
		map1 = new HashMap<>();						// new에서 타입 파라미터 생략 가능
		map1 = new HashMap<>(map1);					// map1의 모든 값을 가진 HashMap 생성
		map1 = new HashMap<>(10);					// 초기 용량(capacity) 지정
		map1 = new HashMap<>(10, 0.7f);				// 초기 capacity, load factor 지정
		map1 = new HashMap<String, String>(){{		// 초기값 지정
			put("a","b");
		}};
		System.out.println(map1);
		
		// HashMap 값 추가
		HashMap<Integer, String> map = new HashMap<>();	// new에서 타입 파라미터 생략 가능
		map.put(1, "사과");	// 값 추가
		map.put(2, "바나나");
		map.put(3, "포도");
		System.out.println(map);
		System.out.println();
		
		// HashMap 값 삭제
		map = new HashMap<Integer, String>(){{			//초기값 지정
		    put(1,"사과");
		    put(2,"바나나");
		    put(3,"포도");
		}};
		System.out.println(map);
		map.remove(1); 	//key값 1 제거
		System.out.println(map);
		map.clear(); 	//모든 값 제거
		System.out.println(map);
		System.out.println();
		
		// 값 출력
		map = new HashMap<Integer, String>(){{			//초기값 지정
		    put(1,"사과");
		    put(2,"바나나");
		    put(3,"포도");
		}};
		System.out.println(map);			// 전체 출력
		System.out.println(map.get(1));		// key값 1의 value 얻기
		
		// enrtySet() 활용
		for(Entry<Integer, String> entry : map.entrySet()) {
			System.out.println("[key] : " + entry.getKey()
			+ " [Value] : " + entry.getValue()
			);
		}
		
		// keySet() 활용
		for(Integer i : map.keySet()) {
			System.out.println("[key] : " + i
			+ " [Value] : " + map.get(i)
			);
		}
		System.out.println();
		
		// Iterator 사용
		map = new HashMap<Integer, String>(){{			//초기값 지정
		    put(1,"사과");
		    put(2,"바나나");
		    put(3,"포도");
		}};
		
		// entrySet().iterator()
		Iterator<Entry<Integer, String>> entries = map.entrySet().iterator();
		while(entries.hasNext()) {
			Map.Entry<Integer, String> entry = entries.next();
			System.out.println("[key] : " + entry.getKey()
			+ " [Value] : " + entry.getValue()
			);
		}
		
		// keySet().iterator()
		Iterator<Integer> keys = map.keySet().iterator();
		while(keys.hasNext()){
		    int key = keys.next();
		    System.out.println("[Key]:" + key + " [Value]:" +  map.get(key));
		}
	}
}
