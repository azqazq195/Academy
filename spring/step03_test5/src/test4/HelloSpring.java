package test4;

import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloSpring {
	public static void main(String[] args) {
		// 1. spring 컨테이너 구동
		GenericXmlApplicationContext context = new GenericXmlApplicationContext("test4/bean.xml");
		
		// 2. bean 객체 얻기
		Sungjuk sungjuk = (Sungjuk) context.getBean("sungjuk");
		sungjuk.calcTot();
		sungjuk.calcAvg();		
		sungjuk.display();
		
		sungjuk.modify();
		sungjuk.display();
		
		// 3. spring 컨테이너 종료
		context.close();
	}
}
