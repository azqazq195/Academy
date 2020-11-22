import java.util.Scanner;

public class Practice1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 선언 : 변수 만들기
		double width=0, height=0, area=0;
		
		// 입력 : 변수에 데이터 저장하기
		System.out.println("-- 입력 --");
		System.out.println("*** 삼각형의 넓이 구하기 ***");
		System.out.print("밑변 : ");
		width = sc.nextDouble();
		System.out.print("높이 : ");
		height = sc.nextDouble();
		// 연산 : 저장된 데이터 가공하기
		area = width * height / 2;
		// 출력 : 결과값 확인하기
		System.out.println("--출력--");
		System.out.println("넓이 : " + area);
	}
}



