package programmers;

import java.util.ArrayList;
import java.util.Stack;

public class StackFunctionDevelopment {
	public static void main(String[] args) {
		Solution5 solution = new Solution5();
		
		// 2, 1
		int progresses[] = {93,30,55};
		int speeds[] = {1,30,5};
		
		// 1, 3, 2
		int progresses1[] = {95, 90, 99, 99, 80, 99};
		int speeds1[] = {1, 1, 1, 1, 1, 1};
		
		int progresses2[] = {93, 98, 93, 98, 30, 30};
		int speeds2[] = {1, 1, 1, 1, 3, 4};
		
		solution.solution(progresses2, speeds2);
	}
}

class Solution5 {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] div = new int[progresses.length];
        Stack<Integer> answerStack = new Stack<Integer>();
        ArrayList<Integer> answerList = new ArrayList<Integer>();
        int answerNum = 0;
        
        for(int i=0; i<div.length; i++) {
        	div[i] = (int) Math.ceil((100-progresses[i])/(double)speeds[i]);
        }
        
        for(int i=0; i<div.length; i++) {
        	if(answerStack.empty()) {
        		answerStack.push(div[i]);
        		answerNum++;
        	} else {
        		if(answerStack.peek() >= div[i]) {
        			answerNum++;
        		} else {
        			answerList.add(answerNum);
        			answerStack.pop();
        			answerNum=0;
        			answerStack.push(div[i]);
        			answerNum++;
        		}
        	}
        }
        answerList.add(answerNum);
        
        int[] answer = new int[answerList.size()];
        for(int i = 0; i < answer.length; i++) {
        	answer[i] = answerList.get(i);
        }
        
        for(int i : answer) {
        	System.out.print(i + " ");
        }
        
        return answer;
    }
}