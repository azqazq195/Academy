
public class Solution_가운데_글자_가져오기 {
	public static void main(String[] args) {
		String str = "abcde";
		String str1 = "qwer";
		solution(str1);
	}
	
    public static String solution(String s) {
        String answer = "";
        int length = s.length();
        
        if(length % 2 == 0) {
        	answer = answer + s.charAt((length/2-1)) + s.charAt((length/2));
        } else {
        	answer += s.charAt(length/2);
        }
        System.out.println(answer);
        return answer;
    }
}
