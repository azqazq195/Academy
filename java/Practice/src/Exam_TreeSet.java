import java.util.Arrays;
import java.util.Iterator;
import java.util.TreeSet;

public class Exam_TreeSet {
	public static void main(String[] args) {
		TreeSet<Integer> set1;
		set1 = new TreeSet<Integer>();						// TreeSet 생성
		set1 = new TreeSet<>();								// new에서 타입 파라미터 생략 가능
		set1 = new TreeSet<Integer>(set1);					// set1의 모든 값을 가진 TreeSet 생성
		set1 = new TreeSet<Integer>(Arrays.asList(1,2,3));	// 초기값 지정
		
		// TreeSet 값 추가
		System.out.println("TreeSet 값 추가");
		TreeSet<Integer> set = new TreeSet<Integer>();		// TreeSet 생성
		set.add(7);											// 값 추가
		set.add(4);
		set.add(9);
		set.add(1);
		set.add(5);
		System.out.println(set);
		System.out.println();
		
		// TreeSet 값 삭제
		System.out.println("TreeSet 값 삭제");
		set = new TreeSet<Integer>(Arrays.asList(7,4,9,1,5));
		set.remove(4);	// 값 제거
		System.out.println(set);
		set.clear();	// 모든 값 제거
		System.out.println(set);
		System.out.println();
		
		// TreeSet 크기 구하기
		System.out.println("TreeSet 크기 구하기");
		set = new TreeSet<Integer>(Arrays.asList(7,4,9,1,5));
		System.out.println("size : " + set.size());
		System.out.println();
		
		// TreeSet 값 출력
		set = new TreeSet<Integer>(Arrays.asList(7,4,9,1,5));
		System.out.println("All : " + set);							// 전체 출력
		System.out.println("최솟값 : " + set.first());				// 최소값 출력
		System.out.println("최댓값 : " + set.last());					// 최대값 출력
		System.out.println();
		System.out.println("젤큰수 : " + set.last());					// 최대값 출력
		System.out.println("두번째 큰수 : " + set.lower(set.last()));
		// 입력값보다 큰 데이터 중 최솟값 출력, 없으면 null
		System.out.println("3보다 큰 수 : " + set.higher(3));
		// 입력값보다 작은 데이터 중 최댓값 출력, 없으면 null
		System.out.println("3보다 작은 수 : " + set.lower(3));
		set.add(20);
		set.add(-1);
		System.out.println();
		
		Iterator<Integer> iter = set.descendingIterator();			// Iterator 사용
		while(iter.hasNext()) {										// 값이 있으면 true 없으면 false
			System.out.println(iter.next());
		}
	}
}
