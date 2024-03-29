import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Exam_Pattern_Matcher {
	public static void main(String[] args) {
		String patternString = "^[0-9]*$";	// 숫자만
		String valString = "12345679";
		boolean regex = Pattern.matches(patternString, valString);
		System.out.println(regex);
		
        Pattern pattern = Pattern.compile("^[a-zA-Z]*$"); 	// 영문자만
        String val = "abcdef"; 								// 대상문자열
        Matcher matcher = pattern.matcher(val);
        System.out.println(matcher.find());
        
        String name = "홍길동";
        String tel = "010-1234-5678";
        String email = "test@naver.com";
        //유효성 검사
        boolean name_check = Pattern.matches("^[가-힣]*$", name);
        boolean tel_check = Pattern.matches("^01(?:0|1|[6-9])-(?:\\d{3}|\\d{4})-\\d{4}$", tel);
        boolean email_check = Pattern.matches("\\w+@\\w+\\.\\w+(\\.\\w+)?", email);
        //출력
        System.out.println("이름 : " + name_check);
        System.out.println("전화번호 : " + tel_check);
        System.out.println("이메일 : " + email_check);
        
        System.out.println("이름 : " + name.matches("^[가-힣]*$"));
	}
}
