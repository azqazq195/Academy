class Article1 {
	int seq;
	String subject, writer;
	
	Article1() {
		System.out.println("생성자 호출1....");
	}
	
	Article1(int seq, String subject, String writer) {
		System.out.println("생성자 호출2....");
		this.seq = seq;
		this.subject = subject;
		this.writer = writer;
	}
	void print() {
		System.out.println(seq);
		System.out.println(subject);
		System.out.println(writer);
	}
}
public class Exam2 {
	public static void main(String[] args) {
		Article1 article1 = new Article1(1, "자바연습입니다.", "자바학생");
		article1.print();
		Article1 article2 = new Article1(2, "자바는 객체지향 언어입니다.", "자바강사");
		article2.print();
		Article1 article3 = new Article1();
	}
}




