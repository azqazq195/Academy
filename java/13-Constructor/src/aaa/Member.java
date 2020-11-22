package aaa;
// 파일안에서 public을 붙일수 있는 클래스는 파일과 이름이 똑같은 클래스만 가능
public class Member {
	private String name;
	private int age;
	
	public Member(String name, int age) { // 생성자
		this.name = name;
		this.age = age;
	}
	public String getName() {			// getter
		return name;		
	}
	public void setName(String name) {  // setter
		this.name = name;
	}
	public int getAge() {				// getter
		return age;
	}
	public void setAge(int age) {		// setter
		this.age = age;
	}
}
