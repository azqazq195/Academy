import java.util.Scanner;

public class Practice2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Test2[] op = new Test2[2];
		
		for(int i=0; i<op.length; i++) {
			op[i] = new Test2();
			op[i].input();
			op[i].setPorcess();  // 총액 저장
			int cnt = Sales.getCnt() + op[i].getQty();
			Sales.setCnt(cnt);
		}
		
		System.out.print("할인율 : ");
		Sales.setDiscount(sc.nextDouble());
		// 전체 출력
		System.out.println();
		System.out.println("[[판매가]]");
		for(int i=0; i<op.length; i++) {
			op[i].getDisplay();
		}
		
		System.out.println();
		System.out.println("판매건수 : " + Sales.getCnt());
	}
}






