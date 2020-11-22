public class Score2 extends Score {
	int mus, com;
	
	public Score2(String name, int kor, int eng, int mat, int mus, int com) {
		super(name, kor, eng, mat);  // 부모클래스 생성자 호출
		this.mus = mus;
		this.com = com;
	}
	@Override // 부모클래스에 이 함수가 있는 지 검사를 함.
	public int calc_tot() {
		tot = super.calc_tot() + mus + com;  // super.calc_tot() : 부모 클래스의 calc_tot() 함수 호출
		return tot;
	}
	@Override
	public double calc_avg() {
		avg = (double)tot / 5;
		return avg;
	}
	@Override
	public void output_result() {
		System.out.println("이름: " + name + ", 총점: " + calc_tot()
						+ ", 평균: " + calc_avg());
	}
}















