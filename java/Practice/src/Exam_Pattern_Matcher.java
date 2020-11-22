import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Exam_Pattern_Matcher {
	public static void main(String[] args) {
		String patternString = "^[0-9]*$";	// ¼ıÀÚ¸¸
		String valString = "12345679";
		boolean regex = Pattern.matches(patternString, valString);
		System.out.println(regex);
		
        Pattern pattern = Pattern.compile("^[a-zA-Z]*$"); 	// ¿µ¹®ÀÚ¸¸
        String val = "abcdef"; 								// ´ë»ó¹®ÀÚ¿­
        Matcher matcher = pattern.matcher(val);
        System.out.println(matcher.find());
        
        String name = "È«±æµ¿";
        String tel = "010-1234-5678";
        String email = "test@naver.com";
        //À¯È¿¼º °Ë»ç
        boolean name_check = Pattern.matches("^[°¡-ÆR]*$", name);
        boolean tel_check = Pattern.matches("^01(?:0|1|[6-9])-(?:\\d{3}|\\d{4})-\\d{4}$", tel);
        boolean email_check = Pattern.matches("\\w+@\\w+\\.\\w+(\\.\\w+)?", email);
        //Ãâ·Â
        System.out.println("ÀÌ¸§ : " + name_check);
        System.out.println("ÀüÈ­¹øÈ£ : " + tel_check);
        System.out.println("ÀÌ¸ŞÀÏ : " + email_check);
        
        System.out.println("ÀÌ¸§ : " + name.matches("^[°¡-ÆR]*$"));
	}
}
