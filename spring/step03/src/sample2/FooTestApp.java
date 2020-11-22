package sample2;

import org.springframework.context.support.GenericXmlApplicationContext;

public class FooTestApp {
	public static void main(String[] args) {
		// 1. 스프링 컨테이너 구동
		GenericXmlApplicationContext context = 
				new GenericXmlApplicationContext("sample2/bean.xml");
		
		// 2. 스프링 컨데이터 종료
		context.close();
	}
}
