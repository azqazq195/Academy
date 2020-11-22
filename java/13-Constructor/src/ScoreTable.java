// 1명의 점수를 관리하는 클래스
public class ScoreTable {
	String name;  	// 이름
	int num;		// 정답수
	int score;		// 점수 = 정답수 * 배점 (20)
	
	public ScoreTable() {	
		name="";
		num = score = 0;
	}
	public ScoreTable(String name, int num) {
		this.name = name;
		this.num = num;
	}
	public void calcScore() {
		score = num * 20;
	}
	public void printView() {
		System.out.println(name + "\t" + score);
	}
}
