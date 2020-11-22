package test01;

public class GoodsVO {
	private String code;   //-- 책 코드
	private String name;   //-- 책 이름
	private int price;     //-- 책 가격
    private String maker;  //-- 출판사
    
	@Override
	public String toString() {
		return "GoodsVO [code=" + code + ", name=" + name + ", price=" + price + ", maker=" + maker + "]";
	}

	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getMaker() {
		return maker;
	}
	public void setMaker(String maker) {
		this.maker = maker;
	}    
}
