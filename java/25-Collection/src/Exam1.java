import java.util.HashMap;
import java.util.Map;

public class Exam1 {
	public static void main(String[] args) {
		// <값의 이름, 값의 종류>  <= 제너릭, 반드시 클래스 이름을 사용
		// => 키값의 중복을 허용하지 않음
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		// 데이터 추가 : 데이터 저장, 수정 => put 메소드 사용
		// 기존에 키가 없으면, 새로 저장
		// 기존에 키가 있으면, 데이터 수정 저장
		map.put("aaa", 111);
		map.put("bbb", 222);
		map.put("aaa", 444);
		map.put("ccc", 333);
		map.put("ccc", null);  // 객체를 저장하는 것이므로, 저장할 데이터가 없을 때는 null을 사용함
		
		// 저장된 데이터 개수 얻기
		System.out.println("Map size : " + map.size());
		
		// 데이터 확인 
		System.out.println(map.get("aaa"));
		System.out.println(map.get("bbb"));
		System.out.println(map.get("ccc"));
		
		// 데이터 삭제
		map.remove("aaa");  // 키값으로 데이터 1개 삭제
		System.out.println("Map size : " + map.size());
		System.out.println(map.get("aaa"));
		System.out.println(map.get("bbb"));
		System.out.println(map.get("ccc"));
		
		map.clear(); 		// 모든 데이터 삭제
		System.out.println("Map size : " + map.size());
	}
}








