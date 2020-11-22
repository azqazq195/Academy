package study.java.bbs;

public class Article {
	private static int count = 0;  // 전체 게시물의 수를 표현하기 위한 변수
	private static String category;// 게시물의 분류를 구별하기 위한 변수
	
	private int num; 		// 글번호
	private String title;	// 글제목
	private String regDate;	// 작성일시
	
	public Article(int num, String title, String regDate) {
		super();
		this.num = num;
		this.title = title;
		this.regDate = regDate;
		Article.count++;  // 객체가 생성될 때마다, count 개수를 증가시킴
	}	

	@Override
	public String toString() {
		return "글 분류=" + Article.category + ", 전체 글 수=" + count 
			 + ", Article [num=" + num + ", title=" + title + ", regDate=" + regDate + "]";
	}

	public static int getCount() {
		return count;
	}

	public static void setCount(int count) {
		Article.count = count;
	}

	public static String getCategory() {
		return category;
	}

	public static void setCategory(String category) {
		Article.category = category;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}	
}
