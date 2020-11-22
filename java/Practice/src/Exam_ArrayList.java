import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class Exam_ArrayList {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list = new ArrayList<Integer>();                                 //타입설정 int타입만 사용가능
		list = new ArrayList<>();                                       //new에서 타입 파라미터 생략가능
		list = new ArrayList<Integer>(10);                              //초기 용량(capacity)지정
		list = new ArrayList<Integer>(Arrays.asList(1,2,3));           //생성시 값추가
		
		
		list = new ArrayList<Integer>();
		list.add(3);                        					//값 추가
		list.add(null);                     					//null값도 add가능
		list.add(1,10);                     					//index 1뒤에 10 삽입

		
		list = new ArrayList<Integer>(Arrays.asList(1,2,3));
		list.remove(1);                            				//index 1 제거
		list.clear();                              				//모든 값 제거
		
		list = new ArrayList<Integer>(Arrays.asList(1,2,3));
		System.out.println("size");
		System.out.println(list.size());                		//list 크기 : 3
		
		
		list = new ArrayList<Integer>(Arrays.asList(1,2,3));
		System.out.println("0번째 인덱스");
		System.out.println(list.get(0));               			//0번째 index 출력
				
		System.out.println("for");
		for(Integer i : list) {                        			//for문을 통한 전체출력
		    System.out.println(i);
		}

		System.out.println("Iterator");
		Iterator<Integer> iter = list.iterator();               //Iterator 선언 
		while(iter.hasNext()){                         			//다음값이 있는지 체크
		    System.out.println(iter.next());           			//값 출력
		}
		
		System.out.println("검색");
		list = new ArrayList<Integer>(Arrays.asList(1,2,3));
		System.out.println(list.contains(1));                         //list에 1이 있는지 검색 : true
		System.out.println(list.indexOf(1));                          //1이 있는 index반환 없으면 -1
		
	}
}
