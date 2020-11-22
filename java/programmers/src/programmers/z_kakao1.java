package programmers;

public class z_kakao1 {
	public static void main(String[] args) {
		Solution11 solution = new Solution11();
		
		String new_id = "abcdefghijklmn.p";
		
		System.out.println(solution.solution(new_id));
	}
}

class Solution11 {
    public String solution(String new_id) {
        String answer = new_id;
        // 1단계
        answer = answer.toLowerCase();
        
        // 2단계
        answer =answer.replaceAll("[^0-9a-z[-][.][_]]", "");
        
        // 3단계
        answer = answer.replaceAll("[.]{2,}", ".");

        // 4단계
        if(answer.charAt(0)=='.') {
        	answer = answer.substring(1,answer.length());
        }
        if(answer.length()!=0) {
        	if(answer.charAt(answer.length()-1)=='.') {
        		answer = answer.substring(0,answer.length()-1);
        	}
        }
        
        // 5단계
        if(answer.equals("")) {
        	answer += "a";
        }
        // 6단계
        if(answer.length() >= 16) {
        	answer = answer.substring(0, 15);
        	if(answer.charAt(answer.length() - 1)=='.') {
        		answer = answer.substring(0, 14);
        	}
        }
        
        // 7단계
        if(answer.length()<=2) {
        	for(int i=answer.length(); i<3; i++) {
        		answer += answer.charAt(answer.length() - 1);
        	}
        }
        return answer;
    }
}