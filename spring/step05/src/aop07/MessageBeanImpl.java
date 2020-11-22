package aop07;

public class MessageBeanImpl implements MessageBean{
	private String name;
	
	@Override
	public void sayHello() {
		/*
		try {
			Thread.sleep(3000);  // 3초동안 프로그램 중지시킴
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		*/
		int y=0;
		for(int i=0; i<100000000; i++) {
			y += i;
		}
		System.out.println("Hello, " + name + "!!");
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
