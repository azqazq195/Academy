package sample1;

public class MessageBeanImpl implements MessageBean{
	private String fruit;
	private int cost;
	
	public MessageBeanImpl() {	
		System.out.println("MessageBeanImpl() 호출");
	}	
	public MessageBeanImpl(String fruit) {
		super();
		System.out.println("MessageBeanImpl(String fruit) 호출");
		this.fruit = fruit;
	}
	public MessageBeanImpl(String fruit, int cost) {
		super();
		System.out.println("MessageBeanImpl(String fruit, int cost) 호출");
		this.fruit = fruit;
		this.cost = cost;
	}
	
	@Override
	public void sayHello() {
		System.out.println(fruit + "\t" + cost);
	}
	@Override
	public void sayHello(String a, int b) {
		System.out.println(a + "\t" + b);
	}

	public String getFruit() {
		return fruit;
	}
	public void setFruit(String fruit) {
		System.out.println("setFruit(String fruit) 호출");
		this.fruit = fruit;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		System.out.println("setCost(int cost) 호출");
		this.cost = cost;
	}
}









