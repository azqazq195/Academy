package test2;

import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloSpring {
	public static void main(String[] args) {
		GenericXmlApplicationContext context = new GenericXmlApplicationContext("test2/bean.xml");
		
		Calc calc1 = (Calc) context.getBean("calcAdd");
		calc1.calculate();
		
		Calc calc2 = (Calc) context.getBean("calcMul");
		calc2.calculate();
		
		context.close();
	}
}
