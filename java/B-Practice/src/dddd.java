import java.util.regex.Pattern;

public class dddd {
	public static void main(String[] args) {
		String str = "RGRBB";
		
		System.out.println(Pattern.matches("^[RGB]*$", str));
	}
}
