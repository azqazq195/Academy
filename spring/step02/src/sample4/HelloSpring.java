package sample4;

import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloSpring {
	public static void main(String[] args) {
		// bean 객체를 이용해서 결합도(= 의존성)를 낮춘 프로그램	
		
		// 1. 스프링 컨테이너 구동
		// => bean.xml에 설정한 <bean> 설정 정보를 읽어와 객체를 생성하고 초기화 한다.
		GenericXmlApplicationContext context = 
				new GenericXmlApplicationContext("sample4/bean.xml");
		
		// 2. bean 객체 얻기
		// => bean 객체를 검색하고, bean 객체를 리턴
		// context.getBean("아이디명")
		MessageBean bean = (MessageBean)context.getBean("messageBean");
		bean.sayHello();
		
		// 3. 스프링 컨테이너 종료
		context.close();
	}
}
