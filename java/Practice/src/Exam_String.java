
public class Exam_String {
	public static void main(String[] args) {
		String str = "Hello welcome to the this place 22";
		
		System.out.println("--- indexOf ---");
		System.out.println(str.indexOf("welcome"));		// 문자열 검색
		System.out.println(str.indexOf("t")); 			// 문자 검색
		System.out.println(str.indexOf("welcome", 10));	// 문자열을 10번째 index 부터 검색
		System.out.println(str.indexOf("t", 10));		// 문자를  10번째 index 부터 검색
		
		if(str.indexOf("welcome") != -1) {
			System.out.println("문자가 포함되어 있습니다.");
		} else {
			System.out.println("문자가 포함되어 있지 않습니다.");
		}
		System.out.println();
		//		6
		//		14
		//		-1
		//		14
		//		문자가 포함되어 있습니다.
		
		System.out.println("--- contains ---");
		if(str.contains("welcome")) {
			System.out.println("문자가 포함되어 있습니다.");
		} else {
			System.out.println("문자가 포함되어 있지 않습니다.");
		}
		System.out.println();
		
		System.out.println("--- matches ---");
		if(str.matches(".*welcome.*")) {
			System.out.println("문자가 포함되어 있습니다.");
		} else {
			System.out.println("문자가 포함되어 있지 않습니다.");
		}
		
		if(str.matches(".*[a-zA-Z].*")) {
			System.out.println("영문자가 포함되어 있습니다.");
		} else {
			System.out.println("영문자가 포함되어 있지 않습니다.");
		}
		
		if(str.matches(".*[0-9].*")) {
			System.out.println("숫자가 포함되어 있습니다.");
		} else {
			System.out.println("숫자가 포함되어 있지 않습니다.");
		}
		
		
	}
}
