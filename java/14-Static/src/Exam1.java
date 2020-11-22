public class Exam1 {
	public static void main(String[] args) {
		System.out.println("--- 2010년 ---");
		Bank hong = new Bank("홍길동", 10000, 2.5);
		hong.print_account();
		
		System.out.println("--- 2015년 ---");
		Bank kim = new Bank("김철수", 20000, 3.5);
		hong.print_account();
		kim.print_account();
		
		System.out.println("--- 2020년 ---");
		Bank lee = new Bank("이영희", 30000, 4.5);
		hong.print_account();
		kim.print_account();
		lee.print_account();
	}
}
