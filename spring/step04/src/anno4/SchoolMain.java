package anno4;

import org.springframework.context.support.GenericXmlApplicationContext;

public class SchoolMain {
	public static void main(String[] args) {
		GenericXmlApplicationContext context = new GenericXmlApplicationContext("anno4/bean.xml");
		
		School school = (School) context.getBean("school");
		System.out.println(school.toString());
		
		context.close();
	}
}
