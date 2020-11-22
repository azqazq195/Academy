package anno6;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

public class UserServiceTest {
	public static void main(String[] args) {
		// @Configuration을 사용했을 경우에는, 스프링 컨테이너를 구동하는 클래스가 달라진다.
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("anno6");
		context.refresh();
		
		UserServiceImpl user = context.getBean(UserServiceImpl.class);
		user.show();
		
		context.close();
	}
}
