
public class Department extends Salary{
	String department;
	
	public Department(String name, int salary, String department) {
		super(name, salary);
		this.department = department;
	}
	@Override 
	void viewInformation() {
		super.viewInformation();
		System.out.println("부서 : " + department);
	}
}
