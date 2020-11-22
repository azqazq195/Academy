package sample7;

import org.springframework.context.support.GenericXmlApplicationContext;

public class EmpMain {
	public static void main(String[] args) {
		GenericXmlApplicationContext context = new GenericXmlApplicationContext("sample7/bean.xml");
		
		Emp emp1 = (Emp) context.getBean("developer");
		System.out.println(emp1.toString());
		
		Emp emp2 = (Emp) context.getBean("engineer");
		System.out.println(emp2.toString());
		
		context.close();
	}
}
