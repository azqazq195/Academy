package score;
/* 인터페이스의 용도
 * 1. 상속받는 자식클래스에게 강제적으로 함수를 만들게 함
 * 2. 목차 역할
 */
public interface Score {
	public void input(ScoreVO vo);	// 입력
	public String print();			// 출력
	public String printTitle();		// 제목 출력
	public String searchHak(String hak);	// 검색 : 학번
	public String searchName(String name);	// 검색 : 이름
	public void descSortTot();		// 정렬 : 총점 내림차순
	public void ascSortHak();		// 정렬 : 학번 오름차순
	public String saveFile();		// 파일 저장
	public String loadFile();		// 파일 읽기
}
