import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
3 10 50 60 100 100 200 300
45 50 600 600 400 450 500 543
11 120 120 230 50 40 60 440
35 56 67 90 67 80 500 600
 */


public class b2527_2 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<4; i++) {
			// 버퍼는 스트링으로 입력됨
			// br.readLine() 한줄을 입력받음
			// br.readLine().split(" ");
			// 한줄을 입력받아서 띄어쓰기 기준으로 잘라서 저장
			// s[] 배열 한칸에 숫자 하나씩 저장하는데 스트링 형식
			String s[] = br.readLine().split(" ");
			sb.append(square(s)+"\n");
		}
		System.out.println(sb);
	}
	
	public static String square(String s[]) {
		String answer = "";
		int x1,y1,p1,q1;
		int x2,y2,p2,q2;
		
		x1 = Integer.parseInt(s[0]);
		y1 = Integer.parseInt(s[1]);
		p1 = Integer.parseInt(s[2]);
		q1 = Integer.parseInt(s[3]);
		
		x2 = Integer.parseInt(s[4]);
		y2 = Integer.parseInt(s[5]);
		p2 = Integer.parseInt(s[6]);
		q2 = Integer.parseInt(s[7]);
		
		// 직사각형	a
		// 선분		b
		// 점		c
		// 없음		d
		
		if(p2 < x1) answer = "d";
		else if(p1 < x2) answer = "d";
		else if(q1 < y2) answer = "d";
		else if(q2 < y1) answer = "d";
		
		else if(x1 == p2 && q1 == y2) answer = "c";
		else if(p1 == x2 && q1 == y2) answer = "c";
		else if(p1 == x2 && y1 == q2) answer = "c";
		else if(x1 == p2 && y1 == q2) answer = "c";
		
		else if(q1 == y2 && (x1 < p2 && x2 < p1)) answer = "b";
		else if(p1 == x2 && (y1 < q2 && y2 < q1)) answer = "b";
		else if(y1 == q2 && (x1 < p2 && x2 < p1)) answer = "b";
		else if(x1 == p2 && (y1 < q2 && y2 < q1)) answer = "b";
		
		else answer = "a";
		
		return answer;
	}
}
