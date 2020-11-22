package programmers;

public class SkillCheck_1_2 {
	public static void main(String[] args) {
		Solutions2 solution = new Solutions2();
		
		String dartResult = "1S*10T*2D*3T";
		
		solution.solution(dartResult);
	}
}

class Solutions2 {
	public int solution(String dartResult) {
		int answer = 0;
		String numString = "";
		int num = 0;
		int preNum = 0;
		int i = 0;
		
		while(!dartResult.equals("")) {
			if(dartResult.charAt(i)=='S') {
				preNum = num;
				numString = dartResult.substring(0,i);
				num = Integer.parseInt(numString);
				dartResult = dartResult.substring(i+1);
				i = 0;
			} else if(dartResult.charAt(i)=='D') {
				preNum = num;
				numString = dartResult.substring(0,i);
				num = Integer.parseInt(numString);
				num *= num;
				dartResult = dartResult.substring(i+1);
				i = 0;
			} else if(dartResult.charAt(i)=='T') {
				preNum = num;
				numString = dartResult.substring(0,i);
				num = Integer.parseInt(numString);
				num = num * num * num;
				dartResult = dartResult.substring(i+1);
				i = 0;
			}
			if(!dartResult.equals("")) {
				if(dartResult.charAt(0)=='*') {
					dartResult = dartResult.substring(1);
					preNum *= 2;
					num *= 2;
				} else if(dartResult.charAt(0)=='*') {
					dartResult = dartResult.substring(1);
					preNum *= -1;
					num *= -1;
				}
			}
			answer += preNum;
			System.out.println("dartResult : " + dartResult);
			i++;
		}
		answer += num;
				
		return answer;
	}
}