package anno6;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// bean.xml 역할을 하는 클래스
@Configuration
public class AppConfig {
	// <bean id="myService" class="anno6.UserServiceImpl"/>
	@Bean // 함수명이 id값
	public UserService myService() {
		return new UserServiceImpl();
	}
}
