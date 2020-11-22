
public class Exam {
	public static void main(String[] args) {
		String pattern1 = "^[0-9]*$";                   // 숫자만
		String pattern2 = ".*[\\d].*";                  // 숫자가 포함되어 있나.
		String val = "ABCD333";                      // 대상문자열
		
		System.out.println(val.matches(pattern1));
		System.out.println(val.matches(pattern2));
	}
}
