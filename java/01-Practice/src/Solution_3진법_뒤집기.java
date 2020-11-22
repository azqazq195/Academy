
public class Solution_3진법_뒤집기 {
	public static void main(String[] args) {
		System.out.println(solution(45));
	}
	
    public static int solution(int n) {
        int answer = 0;
        int quotient = n;
        int remainder = 0;
        
        String sb = Integer.toString(n, 3);
//        StringBuilder sb = new StringBuilder();
//        while(quotient/3 != 0) {
//        	remainder = quotient%3; 
//        	quotient = quotient/3;	 
//            
//        	sb.append(remainder);
//        }
//        sb.append(quotient);
//        sb.reverse();
        
        for(int i=0; i<sb.length(); i++) {
        	int num = 0;;
        	if(i==0) {
        		num = Character.getNumericValue(sb.charAt(i));
        		answer += num; 
        	} else {
        		num = Character.getNumericValue(sb.charAt(i));
        		answer += num * (int) Math.pow(3, i);
        	}
        	
        }
        return answer;
    }
}
