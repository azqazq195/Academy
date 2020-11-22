package study.java.model;
// 주소록 데이터를 묶어서 관리하기 위한 java beans
public class People {	
	private String name, phone;

	public People() {
		super();
	}
	public People(String name, String phone) {
		super();
		this.name = name;
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "People [name=" + name + ", phone=" + phone + "]";
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
}
