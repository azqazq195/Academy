package programmers;

public class SkillCheck_1_3 {
	public static void main(String[] args) {
		Solutions3 solution = new Solutions3();
		
		String phone_number = "027778888";
		
		solution.solution(phone_number);
		
	}
}

class Solutions3 {
    public String solution(String phone_number) {
        String answer = "";
        
        for(int i=0; i<phone_number.length()-4; i++) {
        	answer += "*";
        }
        answer += phone_number.substring(phone_number.length()-4, phone_number.length());
        return answer;
    }
}