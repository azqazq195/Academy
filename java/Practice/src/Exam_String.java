
public class Exam_String {
	public static void main(String[] args) {
		String str = "Hello welcome to the this place 22";
		
		System.out.println("--- indexOf ---");
		System.out.println(str.indexOf("welcome"));		// ���ڿ� �˻�
		System.out.println(str.indexOf("t")); 			// ���� �˻�
		System.out.println(str.indexOf("welcome", 10));	// ���ڿ��� 10��° index ���� �˻�
		System.out.println(str.indexOf("t", 10));		// ���ڸ�  10��° index ���� �˻�
		
		if(str.indexOf("welcome") != -1) {
			System.out.println("���ڰ� ���ԵǾ� �ֽ��ϴ�.");
		} else {
			System.out.println("���ڰ� ���ԵǾ� ���� �ʽ��ϴ�.");
		}
		System.out.println();
		//		6
		//		14
		//		-1
		//		14
		//		���ڰ� ���ԵǾ� �ֽ��ϴ�.
		
		System.out.println("--- contains ---");
		if(str.contains("welcome")) {
			System.out.println("���ڰ� ���ԵǾ� �ֽ��ϴ�.");
		} else {
			System.out.println("���ڰ� ���ԵǾ� ���� �ʽ��ϴ�.");
		}
		System.out.println();
		
		System.out.println("--- matches ---");
		if(str.matches(".*welcome.*")) {
			System.out.println("���ڰ� ���ԵǾ� �ֽ��ϴ�.");
		} else {
			System.out.println("���ڰ� ���ԵǾ� ���� �ʽ��ϴ�.");
		}
		
		if(str.matches(".*[a-zA-Z].*")) {
			System.out.println("�����ڰ� ���ԵǾ� �ֽ��ϴ�.");
		} else {
			System.out.println("�����ڰ� ���ԵǾ� ���� �ʽ��ϴ�.");
		}
		
		if(str.matches(".*[0-9].*")) {
			System.out.println("���ڰ� ���ԵǾ� �ֽ��ϴ�.");
		} else {
			System.out.println("���ڰ� ���ԵǾ� ���� �ʽ��ϴ�.");
		}
		
		
	}
}
