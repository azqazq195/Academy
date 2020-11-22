
public class Army extends Unit{

	public Army(String name) {
		super(name);
	}

	@Override
	public void attack() {
		System.out.println(getName() + " >> 육상공격");
	}
	@Override
	public void move() {
		System.out.println(getName() + " >> 육상이동");
	}
}
