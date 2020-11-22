
public class Solution_2016년 {
	public static void main(String[] args) {
		int a = 5;
		int b = 24;
		
		System.out.println(solution(a, b));
	}
	
	public static String solution(int a, int b) {
        String dayString[] = {"THU", "FRI", "SAT" , "SUN", "MON", "TUE", "WED"};
        int months[] = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30 ,31};
        int days = 0;
        
        for(int i=0; i<a-1; i++) {
        	days += months[i];
        }
        days += b;
        
        
        return dayString[days % 7];
    }
}
