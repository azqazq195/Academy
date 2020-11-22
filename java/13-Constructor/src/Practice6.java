
public class Practice6 {
	public static void main(String[] args) {
		// 일반 객체 사용
		ScoreTable s1, s2, s3;
		s1 = new ScoreTable("홍길동", 5);
		s2 = new ScoreTable("김철수", 3);
		s3 = new ScoreTable("이영희", 4);
		s1.calcScore();
		s2.calcScore();
		s3.calcScore();
		System.out.println("이름" + "\t" + "점수");
		System.out.println("------------------");
		s1.printView();
		s2.printView();
		s3.printView();
		
		System.out.println("------------------");
		System.out.println();
		
		// 객체 배열 사용
		ScoreTable[] s = new ScoreTable[3];
		s[0] = new ScoreTable("홍길동", 5);
		s[1] = new ScoreTable("김철수", 3);
		s[2] = new ScoreTable("이영희", 4);
		
		System.out.println("이름" + "\t" + "점수");
		System.out.println("------------------");
		for(int i=0; i<s.length; i++) {
			s[i].calcScore();
			s[i].printView();
		}		
	}
}
