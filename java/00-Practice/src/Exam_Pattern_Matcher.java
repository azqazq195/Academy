import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Exam_Pattern_Matcher {
	public static void main(String[] args) {
		String patternString = "^[0-9]*$";	// ���ڸ�
		String valString = "12345679";
		boolean regex = Pattern.matches(patternString, valString);
		System.out.println(regex);
		
        Pattern pattern = Pattern.compile("^[a-zA-Z]*$"); 	// �����ڸ�
        String val = "abcdef"; 								// ����ڿ�
        Matcher matcher = pattern.matcher(val);
        System.out.println(matcher.find());
        
        String name = "ȫ�浿";
        String tel = "010-1234-5678";
        String email = "test@naver.com";
        //��ȿ�� �˻�
        boolean name_check = Pattern.matches("^[��-�R]*$", name);
        boolean tel_check = Pattern.matches("^01(?:0|1|[6-9])-(?:\\d{3}|\\d{4})-\\d{4}$", tel);
        boolean email_check = Pattern.matches("\\w+@\\w+\\.\\w+(\\.\\w+)?", email);
        //���
        System.out.println("�̸� : " + name_check);
        System.out.println("��ȭ��ȣ : " + tel_check);
        System.out.println("�̸��� : " + email_check);
        
        System.out.println("�̸� : " + name.matches("^[��-�R]*$"));
	}
}
