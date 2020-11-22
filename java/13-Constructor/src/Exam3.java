// 같은 파일 안에서 클래스를 여러개 만들 경우, 
// public을 붙일수있는 클래스는 파일이름과 똑같은 클래스만 가능하다.
class Student {
	private String name;
	private int age;
	// getter : 변수이름 앞에 get을 붙여서 만든 함수
	//  => 멤버 변수값을 리턴 => 변수에 저장된 데이터 확인용
	// setter : 변수이름 앞에 set을 붙여서 만든 함수
	//  => 멤버 변수에 값 대입 => 변수에 데이터 저장용
	public Student() {
	}
	public Student(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}	
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}
public class Exam3 {
	public static void main(String[] args) {
		Student student = new Student();
		student.setName("홍길동");
		student.setAge(25);
		
		System.out.println(student.getName());
		System.out.println(student.getAge());
	}
}
