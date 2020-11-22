
public class Exam1 {
	public static void main(String[] args) {
		String a = "20";
		String b = "3.14";
		int num_a = Integer.parseInt(a);
		double num_b = Double.parseDouble(b);
		
		int v1 = num_a + 500;
		double v2 = num_b + 500;
		
		System.out.println(a+500);
		System.out.println(b+500);
		System.out.println(v1);
		System.out.println(v2);
		
		Integer i = new Integer(123);
		
		int v3 = i + 300;
		System.out.println(v3);
	}
}
