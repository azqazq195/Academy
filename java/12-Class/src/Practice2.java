import java.util.Scanner;

class Gugudan {
	int start, end;
	void setGugudan(int s, int e) {  // void setGugudan(Gugudan this, int s, int e) 
		start = s;
		end = e;
	}
	void dispGugudan() {
		for(int x=start; x<=end; x++) {		// 단 : 2~9
			for(int y=1; y<=9; y++) {  	// 1~9
				System.out.printf("%d*%d=%2d ", x, y, x*y);
			}			
			System.out.println();
		}
	}
}
public class Practice2 {

	public static void main(String[] args) {
		Gugudan g1 = new Gugudan();
		Scanner sc = new Scanner(System.in);
		int s, e;
		
		System.out.print("시작단 : ");
		s = sc.nextInt();
		System.out.print("끝단 : ");
		e = sc.nextInt();

		g1.setGugudan(s, e);
		g1.dispGugudan();	
	}

}
