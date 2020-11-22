import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Exam3 {
	public static void main(String[] args) {
		// Set : 순서가 없고, 데이터의 중복을 허용안함
		Set<String> set = new HashSet<String>();
		// 데이터 저장
		set.add("호랑이");
		set.add("사자");
		set.add("호랑이");
		set.add("기린");
		set.add("코끼리");
		// 데이터 개수 확인
		System.out.println("데이터 개수 : " + set.size());
		// 데이터 확인
		Iterator<String> iterator = set.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		// 삭제
		set.remove("호랑이");  // 데이터 1개 삭제
		// 데이터 개수 확인
		System.out.println("데이터 개수 : " + set.size());
		// 데이터 확인
		iterator = set.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		
		set.clear(); 		// 모든 데이터 삭제
		System.out.println("데이터 개수 : " + set.size());
	}
}












