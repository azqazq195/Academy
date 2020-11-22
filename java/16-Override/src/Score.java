
public class Score {
	String name;
	int kor, eng, mat;
	int tot;
	double avg;
	
	public Score(String name, int kor, int eng, int mat) {
		super();   // Object 클래스의 생성자 호출
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
	}
	public int calc_tot() {
		tot = kor + eng + mat;
		return tot;
	}
	public double calc_avg() {
		avg = (double)tot / 3;
		return avg;
	}
	public void output_result() {
		System.out.println("이름: " + name + ", 총점: " + calc_tot()
						+ ", 평균: " + calc_avg());
	}
}











