
public class Salary {
	String name;
	int salary;
	
	public Salary(String name, int salary) {
		super();
		this.name = name;
		this.salary = salary;
	}
	void viewInformation() {
		System.out.println("이름 : " + name);
		System.out.println("연봉 : " + salary);
	}	
}
