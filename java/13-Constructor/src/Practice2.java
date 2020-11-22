class Address {
	private String name, phone, addr;
	
	public Address() {}
	public Address(String name, String phone, String addr) {
		this.name = name;
		this.phone = phone;
		this.addr = addr;
	}
	public void showAddress() {
		System.out.println("이름 : " + name);
		System.out.println("전화 : " + phone);
		System.out.println("주소 : " + addr);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
}
public class Practice2 {
	public static void main(String[] args) {
		Address a1;
		a1 = new Address("홍길동", "010-1234-5678", "서울시 강남구 역삼동");
		a1.showAddress();
	}
}







