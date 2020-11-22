package anno1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/*
 	<bean id="car" class="anno1.Car">			=> @Component
 		<property name="tire" ref="test">		=> @Autowired
 	</bean>
 */
@Component
public class Car {
	// <property name="tire" ref="test"> 와 같은 설정
	// 굳이 getter와 setter를 안만들어 됨 => 스프링 컨테이너가 내부적으로 만들어서 사용함
	@Autowired
	private Tire tire;
	
	public Car() {
		System.out.println("Car() 호출");
	}
	public Car(Tire tire) {
		super();
		this.tire = tire;
		System.out.println("Car(Tire tire) 호출");
	}
	public void drive() {
		System.out.println(tire.getBrand() + "로 만들어진 국산 자동차");
	}
	
	public Tire getTire() {
		return tire;
	}
	public void setTire(Tire tire) {
		System.out.println("setTire(Tire tire) 호출");
		this.tire = tire;
	}	
}
