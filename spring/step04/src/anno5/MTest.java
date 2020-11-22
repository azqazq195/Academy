package anno5;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MTest {
	public static void main(String[] args) {
		GenericXmlApplicationContext context = new GenericXmlApplicationContext("anno5/bean.xml");
		
		MyMessage myMessage = (MyMessage) context.getBean("myMessage");
		System.out.println(myMessage.getMessage());
		System.out.println(myMessage);
		
		myMessage = (MyMessage) context.getBean("myMessage");
		System.out.println(myMessage.getMessage());
		System.out.println(myMessage);
		
		context.close();
	}
}
