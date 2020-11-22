import java.util.ArrayList;
import java.util.List;

public class Exam2 {
	public static void main(String[] args) {
		// List : 순서가 있고, 데이터의 중복을 허용함
		// 배열과 비슷한 구조
		// 인덱스값으로 데이터 구분 : 인덱스는 0부터 시작함
		List<Integer> list = new ArrayList<Integer>();
		// 데이터 추가
		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);
		list.add(50);
		list.add(60);
		// 데이터의 개수
		System.out.println("데이터의 개수 : " + list.size());
		
		// 데이터 읽어오기 : 인덱스 사용
		System.out.println(list.get(0));
		System.out.println(list.get(2));
		System.out.println(list.get(4));
		
		// 중간에 삽입
		list.add(2, 100);  // add(위치값, 데이터);
		// 데이터의 개수
		System.out.println("데이터의 개수 : " + list.size());
				
		// 데이터 읽어오기 : 인덱스 사용
		System.out.println(list.get(0));
		System.out.println(list.get(2));
		System.out.println(list.get(4));
		
		// 데이터 수정
		list.set(3, 200); // set(위치값, 데이터);
		// 전체 데이터 확인
		for(int i=0; i<list.size(); i++) {
			System.out.print(list.get(i) + "  ");
		}
		System.out.println();  // 한줄 넘김
		
		// 데이터 삭제
		list.remove(3);   // 데이터 1개 삭제
		// 전체 데이터 확인
		for(int i=0; i<list.size(); i++) {
			System.out.print(list.get(i) + "  ");
		}
		System.out.println();  // 한줄 넘김
		
		list.clear();     // 데이터 전체 삭제
		System.out.println("데이터의 개수 : " + list.size());
	}
}
