
public class Exam5 {
	public static void main(String[] args) {
		Article article = new Article();
		article.setSeq(1);
		article.setSubject("게시물");
		article.setContent("내일은 웃으리");
		article.setWriter("홍길동");
		article.setHit(0);
		article.setRegDate("2020-06-24");
		
		System.out.println(article.getSeq());
		System.out.println(article.getSubject());
		System.out.println(article.getContent());
		System.out.println(article.getWriter());
		System.out.println(article.getHit());
		System.out.println(article.getRegDate());
		System.out.println("------------------");
		
		Article article2 = new Article(2, "내일은", "웃으리..","이영희", 0, "2020-06-24");
		System.out.println(article2.getSeq());
		System.out.println(article2.getSubject());
		System.out.println(article2.getContent());
		System.out.println(article2.getWriter());
		System.out.println(article2.getHit());
		System.out.println(article2.getRegDate());
		
	}
}
