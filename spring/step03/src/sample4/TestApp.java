package sample4;

import org.springframework.context.support.GenericXmlApplicationContext;

public class TestApp {
	public static void main(String[] args) {
		// 1. 스프링 컨테이너 구동
		GenericXmlApplicationContext context = 
				new GenericXmlApplicationContext("sample4/bean.xml");
		// 2. bean 객체 얻기
		AbstractTest test = (AbstractTest) context.getBean("test");
		System.out.println("오늘은 " + test.dayInfo());
		// 3. 스프링 컨테이너 종료
		context.close();
	}
}
