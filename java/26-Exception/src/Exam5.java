
public class Exam5 {
	public static void main(String[] args) {
		String[] src = {"가", "2", "aaa", "ccc"};
		// src의 데이터를 숫자로 변환해서 저장할 배열
		int[] arr = new int[3];
		try {
			for(int i=0; i<src.length; i++) {
				arr[i] = Integer.parseInt(src[i]);
				System.out.println(arr[i]);
			}
		} catch(NumberFormatException e) {
			// 사용자를 위한 에러메시지
			System.out.println("입력값에 오류가 있습니다.");
			// 개발자를 위한 에러메시지
			//e.printStackTrace();
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("데이터가 너무 많습니다.");
			//e.printStackTrace();
		} catch(Exception e) {
			System.out.println("알 수 없는 예외가 발생했습니다.");
			//e.printStackTrace();
		} finally {
			// 이 블록은 예외의 발생 여부에 상관없이 무조건 실행된다.
			System.out.println("데이터 변환 종료");
		}
		
		System.out.println("--- 프로그램을 종료합니다. ---");
	}
}




