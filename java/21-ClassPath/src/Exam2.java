import study.java.bbs.Article;

public class Exam2 {
	public static void main(String[] args) {
		Article.setCategory("자유게시판");
		
		Article a1 = new Article(1, "첫번째 글 제목입니다.", "2020-01-01");
		Article a2 = new Article(2, "두번째 글 제목입니다.", "2020-02-01");
		Article a3 = new Article(3, "세번째 글 제목입니다.", "2020-03-01");
		
		System.out.println(a1.toString());
		System.out.println(a2.toString());
		System.out.println(a3.toString());
		
		Article.setCategory("공지사항");
		System.out.println(a1.toString());
		System.out.println(a2.toString());
		System.out.println(a3.toString());
	}
}
