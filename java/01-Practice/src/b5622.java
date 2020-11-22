import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b5622 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char num[] = br.readLine().toCharArray();
		
		int count = 0;
		int sum = 0;
		
		while(count<num.length) {
			switch(num[count]) {
			case 'A':
			case 'B':
			case 'C': sum += 3; break;
			case 'D':
			case 'E':
			case 'F': sum += 4; break;
			case 'G':
			case 'H':
			case 'I': sum += 5; break;
			case 'J':
			case 'K':
			case 'L': sum += 6; break;
			case 'M':
			case 'N':
			case 'O': sum += 7; break;
			case 'P':
			case 'Q':
			case 'R':
			case 'S': sum += 8; break;
			case 'T':
			case 'U':
			case 'V': sum += 9; break;
			case 'W':
			case 'X':
			case 'Y':
			case 'Z': sum += 10; break;
			}
			count++;
		}
		
		System.out.println(sum);
	}
}
