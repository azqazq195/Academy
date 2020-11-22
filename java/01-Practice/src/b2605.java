import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

/*
5
0 1 1 3 2
 */
public class b2605 {
	static Stack<Integer> st = new Stack<Integer>();
	static Stack<Integer> subSt = new Stack<Integer>();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = 1;
		br.readLine();
		String s[] = br.readLine().split(" ");
		
		for(int i=0; i<s.length; i++) {
			if(n==1) {
				st.push(n);
			}
			else {
				run(s[i], n);
				
			}
			n++;
		}
		String answer = "";
		while(st.empty()==false){
			answer = st.pop() + " " + answer;
		}
		System.out.println(answer.trim());
	}
	public static void run(String s, int n) {
		// s[] 만큼 반복
		int num = Integer.parseInt(s);
		for(int i=0; i<num; i++) {
			subSt.push(st.pop());
		}
		
		st.push(n);
		
		// qu크기만큼 반복
		for(int i=0; i<num; i++) {
			st.push(subSt.pop());
		}
	}
}
