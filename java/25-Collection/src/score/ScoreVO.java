package score;
// java beans : 데이터를 저장하는 여러 변수를 묶어서 관리하는 클래스
// 클래스 이름 뒤에 ~DTO, ~VO를 붙여서 많이 사용함
// DTO : Data Transfer Object
// VO : Value Object
public class ScoreVO {
	private String hak;		// 학번
	private String name;	// 이름
	private int kor;		// 국어
	private int eng;		// 영어
	private int mat;		// 수학
	private int tot;		// 총점
	private double avg;		// 평균
	
	// 모든 변수값 출력용
	public String toString() {
		if(hak==null || name==null) {
			return null;
		}
		String str = String.format("%5s %7s %4d %4d %4d %4d %4.1f", 
									hak, name, kor, eng, mat, tot, avg);
		return str;
	}
	
	public String getHak() {
		return hak;
	}
	public void setHak(String hak) {
		this.hak = hak;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMat() {
		return mat;
	}
	public void setMat(int mat) {
		this.mat = mat;
	}
	public int getTot() {
		return tot;
	}
	public void setTot(int tot) {
		this.tot = tot;
	}
	public double getAvg() {
		return avg;
	}
	public void setAvg(double avg) {
		this.avg = avg;
	}	
}
