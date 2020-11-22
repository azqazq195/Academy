package sample8;

import org.springframework.context.support.GenericXmlApplicationContext;

public class EmpMain {
	public static void main(String[] args) {
		GenericXmlApplicationContext context = new GenericXmlApplicationContext("sample8/bean.xml");
		
		Developer developer = (Developer) context.getBean("developer");
		System.out.println(developer.toString());
		
		Engineer engineer = (Engineer) context.getBean("engineer");
		System.out.println(engineer.toString());
		
		context.close();
	}
}
