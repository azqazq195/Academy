
public class Exam1 {
	public static void main(String[] args) {
		/** 배열의 생성 방법 **/
		// 1. 방법1 : 배열의 선언과 변수 만들기를 따로 하기
		int[] hong;
		hong = new int[3];
		hong[0] = 75;
		hong[1] = 82;
		hong[2] = 95;
		// 2. 방법2 : 배열의 선언과 변수 만들기를 같이 하기
		int[] kim = new int[3];
		kim[0] = 88;
		kim[1] = 64;
		kim[2] = 70;
		// 3. 방법3 : 배열의 선언과 변수 만들기를 같이 하기 + 데이터 저장
		//int[] lee = new int[] {100, 95, 90};  // 정식
		 int[] lee = {100, 95, 90};         // 약식
		
		// 각각 배열에 저장된 데이터의 합구하기
		int sum1=0, sum2=0, sum3=0;
		sum1 = hong[0] + hong[1] + hong[2];
		System.out.println("sum1 = " + sum1);
		
		sum1=0;
		for(int i=0; i<3; i++) {
			sum1 += hong[i];
			sum2 += kim[i];
			sum3 += lee[i];
		}
		
		System.out.println("sum1 = " + sum1);
		System.out.println("sum2 = " + sum2);
		System.out.println("sum3 = " + sum3);
		// 평균 구하기
		System.out.println("홍길동 = " + sum1 / 3);
		System.out.println("홍길동 = " + sum1 / hong.length);
		System.out.println("김철수 = " + sum2 / kim.length);
		System.out.println("이영희 = " + sum3 / lee.length);
	}
}








