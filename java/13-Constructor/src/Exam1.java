class Book {
	String subject, content;
	
	// 생성자 : 객체가 생성된 직후, 자동으로 호출되는 특수 함수
	// 리턴 자료형을 사용하면 안된다.
	Book() {
		System.out.println("생성자 실행됨...");
		subject = "Java 입문";
		content = "Java는 어쩌고 저쩌구...";
	}
	void read() {
		System.out.println("read() 실행됨...");
		System.out.println(subject);
		System.out.println(content);
	}
}
public class Exam1 {
	public static void main(String[] args) {
		Book book = new Book();
		book.read();
		//book.Book(); //Error, 사용자가 따로 호출할 수 없다.
	}
	
}
