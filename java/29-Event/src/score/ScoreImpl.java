package score;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class ScoreImpl implements Score{
	List<ScoreVO> list = new ArrayList<ScoreVO>();	
	Scanner sc = new Scanner(System.in);
	
	@Override
	public void input(ScoreVO vo) {  // 입력		
		list.add(vo);
	}
	@Override
	public String print() {  // 출력
		String result = printTitle() + "\n";
		
		for(int i=0; i<list.size(); i++) {
			ScoreVO vo = list.get(i);
			result += vo.toString() + "\n";
		}		
		return result;
	}
	@Override
	public String printTitle() {  // 제목 출력
		String str = String.format("%5s %7s %4s %4s %4s %4s %4s", 
									"학번", "이름", "국어", "영어", "수학", "총점", "평균");
		return str;
	}
	@Override
	public String searchHak(String hak) {  // 검색 : 학번		
		Iterator<ScoreVO> iterator = list.iterator();
		String result = printTitle() + "\n";
		while(iterator.hasNext()) {
			ScoreVO vo = iterator.next();
			if(vo.getHak().equals(hak)) {				
				result += vo.toString() + "\n";
			}
		}
		return result;
	}
	@Override
	public String searchName(String name) {  // 검색 : 이름		
		String result = printTitle() + "\n";
		for(int i=0; i<list.size(); i++) {
			ScoreVO vo = list.get(i);
			if(vo.getName().equals(name)) {				
				result += vo.toString() + "\n";
			}
		}
		return result;
	}
	@Override
	public void descSortTot() {  // 정렬 : 총점 내림차순
		// 정렬 기준 설정
		Comparator<ScoreVO> comparator = new Comparator<ScoreVO>() {
			@Override
			public int compare(ScoreVO o1, ScoreVO o2) {
				return o1.getTot() < o2.getTot() ? 1 : -1;
			}			
		};
		// 정렬
		Collections.sort(list, comparator);
		print();
	}
	@Override
	public void ascSortHak() {  // 정렬 : 학번 오름차순
		// 정렬 기준 설정
		Comparator<ScoreVO> comparator = new Comparator<ScoreVO>() {
			@Override
			public int compare(ScoreVO o1, ScoreVO o2) {
				// String 클래스는 Comparable<String>을 상속받았기 때문에
				// compareTo() 메소드가 구현되어 있음
				return o1.getHak().compareTo(o2.getHak());
			}			
		};
		// 정렬
		Collections.sort(list, comparator);
		print();
	}
	@Override
	public String saveFile() { // 파일 저장
		String fileName = "score.txt";
		ObjectInOut objectInOut = new ObjectInOut();
		boolean result = objectInOut.write(fileName, list);
		String str_result = "";
		if(result) {
			str_result = "파일 저장 성공";
		} else {
			str_result = "파일 저장 실패";
		}
		return str_result;
	}
	@Override
	public String loadFile() {  // 파일 읽기 : 기존 리스트에 저장된 데이터를 파일에 저장된 데이터로 바꾸기 작업
		String fileName = "score.txt";
		ObjectInOut objectInOut = new ObjectInOut();
		List list_result = objectInOut.read(fileName);
		String result = "";
		if(list_result != null) {
			result = "파일 읽기 성공";
			list = list_result;
		} else {
			result = "파일 읽기 실패";
		}
		//System.out.println("size = " + list.size());  // test 용
		return result;
	}
	
}






