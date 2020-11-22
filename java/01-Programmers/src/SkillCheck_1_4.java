package programmers;

import java.util.ArrayList;

public class SkillCheck_1_4 {
	public static void main(String[] args) {
		Solutions4 solution = new Solutions4();
		
		int answers1[] = {1,2,3,4,5};
		int answers2[] = {1,3,2,4,2};
		
		solution.solution(answers1);
		
	}
}

class Solutions4 {
    public int[] solution(int[] answers) {
        int[] answer = {};
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        int count[] = new int[3];
        
        int max = 0;
        
        int answer1[] = {1,2,3,4,5};
        int answer2[] = {2,1,2,3,2,4,2,5};
        int answer3[] = {3,3,1,1,2,2,4,4,5,5};
        
        for(int i=0; i<answers.length; i++) {
        	if(answers[i] == answer1[i%5]) count[0]++;
        	if(answers[i] == answer2[i%8]) count[1]++;
        	if(answers[i] == answer3[i%10]) count[2]++;
        }
        
        for(int i=0; i<3; i++) {
        	if(max<count[i]) max = count[i];
        }
        
        for(int i=0; i<3; i++) {
        	if(max == count[i]) list.add(i+1);
        }
        
        answer = new int[list.size()];
        
        for(int i=0; i<list.size(); i++) {
        	answer[i] = list.get(i);
        }
        return answer;
    }
}