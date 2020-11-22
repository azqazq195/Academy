
public class Exam6 {
	public static void main(String[] args) {
		//Calc calc = new Calc();
		Calc calc = Calc.getInstance();
		calc.plus(5, 7);
		calc.minus(5, 7);
		System.out.println("------------");
		
		Calc.getInstance().plus(5, 7);
		Calc.getInstance().minus(5, 7);
	}
}
