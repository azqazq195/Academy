class Living {
	void live() {System.out.println("살아있다.");}
	void breath() {System.out.println("Living : 산소로 호흡한다.");}
	void walk() {System.out.println("Living : 네발로 걷는다.");}
}
class Animal extends Living {
	void breath() {System.out.println("산소로 호흡한다.");}
	void move() {System.out.println("움직인다.");}
}
class Mammalia extends Animal {
	void bringingUp() {System.out.println("젖으로 새끼를 양육한다.");}
	void walk() {System.out.println("네발로 걷는다.");}
}
public class Exam1 {
	public static void main(String[] args) {
		// 2. 부모 클래스 기준
		// 전제조건이 충족되어야 사용할 수 있다.
		// => 사용하려고 하는 자식 클래스의 함수가 부모클래스에 존재해야함
		Living r1 = new Living();
		Living r2 = new Animal();
		Living r3 = new Mammalia();
		r2.breath();
		r3.walk();
		r1.live();
		r2.live();
		r3.live();
		System.out.println("-----------------");
		// 1. 자식 클래스 기준
		Mammalia mammalia = new Mammalia();
		mammalia.live();
		mammalia.breath();
		mammalia.move();
		mammalia.bringingUp();
		mammalia.walk();
	}
}
