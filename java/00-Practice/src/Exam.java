
public class Exam {
	public static void main(String[] args) {
		String pattern1 = "^[0-9]*$";                   // ���ڸ�
		String pattern2 = ".*[\\d].*";                  // ���ڰ� ���ԵǾ� �ֳ�.
		String val = "ABCD333";                      // ����ڿ�
		
		System.out.println(val.matches(pattern1));
		System.out.println(val.matches(pattern2));
	}
}
