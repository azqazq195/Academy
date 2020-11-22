package book2.bean;

public class book2DTO {
	private String code;     	 //도서코드
	private String title;        //도서명
	private String author;       //저자
	private String publisher;    //출판사
	private int price;           //가격
	private String publiDate;    //출판일
	
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getPubliDate() {
		return publiDate;
	}
	public void setPubliDate(String publiDate) {
		this.publiDate = publiDate;
	}

	
}
