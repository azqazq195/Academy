package sample8;

public class Engineer{
	private String dept;
	private Emp emp;
	
	public Engineer() {
	}	
	public Engineer(String dept, Emp emp) {
		super();
		this.dept = dept;
		this.emp = emp;
	}

	@Override
	public String toString() {
		return "Engineer [dept=" + dept + ", " + emp.toString() + "]";
	}
	
	public Emp getEmp() {
		return emp;
	}
	public void setEmp(Emp emp) {
		this.emp = emp;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}	
}
