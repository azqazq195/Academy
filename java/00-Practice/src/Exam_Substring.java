
public class Exam_Substring {
	public static void main(String[] args) {
		String s= "012345";
		
		System.out.println(s);
		System.out.println(s.substring(0,2));
		System.out.println(s.substring(0,s.length()-2));
		System.out.println(s.substring(s.length()-2,s.length()));
		System.out.println(s);
	}
}
