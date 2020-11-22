import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class Exam_LinkedList {
	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<Integer>();   //타입 미설정 Object로 선언된다.
		list = new LinkedList<Integer>();                       //타입설정 int타입만 사용가능
		list = new LinkedList<>();                              //new에서 타입 파라미터 생략가능
		list = new LinkedList<Integer>(Arrays.asList(1,2));     //생성시 값추가
		
		list = new LinkedList<Integer>();
		list.add(3);											//데이터 추가
		list.addFirst(1);										//가장 앞에 데이터 추가
		list.addLast(2);										//가장 뒤에 데이터 추가
		list.add(1, 10);										//index 1뒤에 데이터 10 추가
		System.out.println(list.toString());
		
		list = new LinkedList<Integer>(Arrays.asList(1,2,3,4,5));
		list.removeFirst();            							//가장 앞의 데이터 제거
		list.removeLast();              						//가장 뒤의 데이터 제거
		list.remove();                  						//생략시 0번째 index제거
		list.remove(1);                 						//index 1 제거
		list.clear();                   						//모든 값 제거
		System.out.println(list.toString());
		
		System.out.println();
		System.out.println("size");
		list = new LinkedList<Integer>(Arrays.asList(1,2,3));
		System.out.println(list.size()); //list 크기 : 3
				
		System.out.println();
		list = new LinkedList<Integer>(Arrays.asList(1,2,3));
		System.out.println(list.get(0));              //0번째 index 출력
		System.out.println("for");
		for(Integer i : list) {                       //for문을 통한 전체출력
		    System.out.println(i);
		}
		System.out.println("Iterator");
		Iterator<Integer> iter = list.iterator();     //Iterator 선언 
		while(iter.hasNext()){                        //다음값이 있는지 체크
		    System.out.println(iter.next());          //값 출력
		}
		
		System.out.println();
		System.out.println("검색");
		list = new LinkedList<Integer>(Arrays.asList(1,2,3));
		System.out.println(list.contains(1));             //list에 1이 있는지 검색 : true
		System.out.println(list.indexOf(1));    
	}
}
