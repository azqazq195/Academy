import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

public class Exam_HashSet {
	public static void main(String[] args) {
		HashSet<Integer> set1;
		set1 = new HashSet<Integer>();			// HashSet 생성
		set1 = new HashSet<>();					// new에서 타입 파라미터 생략 가능
		set1 = new HashSet<Integer>(set1);		// set1의 모든 값을 가진 HashSet 생성
		set1 = new HashSet<Integer>(10);		// 초기 용량(capacity)지정
		set1 = new HashSet<Integer>(10, 0.7f);	// 초기 (capacity, load factor)지정
		set1 = new HashSet<Integer>(Arrays.asList(1,2,3));	// 초기값 지정

		// HashSet 값 추가
		HashSet<Integer> set = new HashSet<Integer>();		// HashSet 생성
		set.add(1);			// 값 추가 제거
		set.add(2);
		set.add(3);
		set.add(3);			// 1, 2, 3(중복제거)
		System.out.println(set);
		System.out.println();
		
		// HashSet 값 삭제
		set = new HashSet<Integer>(Arrays.asList(1,2,3));	// HashSet 생성
		System.out.println(set);
		System.out.println();
		
		set.remove(1);		// 값 1 제거
		System.out.println(set);
		System.out.println();
		
		set.clear(); 		// 모든 값 제거
		System.out.println(set);
		System.out.println();
		
		// HashSet 크기 구하기
		set = new HashSet<Integer>(Arrays.asList(1,2,3));	// HashSet 생성
		System.out.println("size : " + set.size());
		System.out.println();
		
		// 값 출력
		System.out.println(set);
		System.out.println();
		
		Iterator<Integer> iter = set.iterator();			// iterator 사용
		while(iter.hasNext()) {								// 값이 있으면 true 없으면 false
			System.out.println(iter.next());
		}
		System.out.println();
		
		// HashSet 값 검색
		System.out.println(set.contains(1));
	}
}
