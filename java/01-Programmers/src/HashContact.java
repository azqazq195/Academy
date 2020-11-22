package programmers;

public class HashContact {
	public static void main(String[] args) {
		Solution1 solution = new Solution1();
		
		String phone_book1[] = {"119", "97674223", "1195524421"};
		String phone_book2[] = {"123", "456", "789"};
		String phone_book3[] = {"12", "123", "1235", "567", "88"};
		String phone_book4[] = {"12", "123", "1235", "567", "88","23"};
		

		System.out.println(solution.solution(phone_book4));
	}
}

class Solution1 {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        for(int i=0; i<phone_book.length; i++){
            for(int j=0; j<phone_book.length; j++){
                if(i==j) continue;
                if(phone_book[j].startsWith(phone_book[i])) return false;
            }   
        }
        return answer;
    }
}