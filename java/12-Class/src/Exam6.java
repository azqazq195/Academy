import java.util.Scanner;

class Score {
	int num;
	String name;
	int kor, eng, mat, tot, avg;
	Scanner sc = new Scanner(System.in);
	
	void set() {  //void set(Score this)
		System.out.println(this);
		System.out.print("학번 : ");
		this.num = sc.nextInt();
		System.out.print("이름 : ");
		this.name = sc.next();
		System.out.print("국어 : ");
		this.kor = sc.nextInt();
		System.out.print("영어 : ");
		this.eng = sc.nextInt();
		System.out.print("수학 : ");
		this.mat = sc.nextInt();
		this.tot = this.kor + this.eng + this.mat;
		this.avg = this.tot / 3;
	}
	void print_title() {  // void print_title(Score this)
		System.out.println(this);
		System.out.println("*** 성적 출력 ***");
		System.out.println("학번\t이름\t국어\t영어\t수학\t총점\t평균\n");  // \t : tab 키문자
	}
	void print() {  // void print(Score this)
		System.out.println(this);
		System.out.printf("%d\t%s\t%d\t%d\t%d\t%d\t%d\n", 
				this.num, this.name, this.kor, this.eng, this.mat, this.tot, this.avg);
	}
}
public class Exam6 {
	public static void main(String[] args) {
		Score n = new Score();
		Score m = new Score();
		System.out.println("n = " + n);
		System.out.println("m = " + m);
		
		n.set();			// n.set(n)
		m.set();			// m.set(m)
		n.print_title();	// n.print_title(n)
		n.print();			// n.print(n)
		m.print();			// m.print(m)
	}
}







