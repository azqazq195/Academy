import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
6 4
4 1
12
8

 */
public class b10158 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int width, height;
		int x, y;
		int remindX, remindY;
		int k;
		int moveX = 1;
		int moveY = 1;
		
		String s1[] = br.readLine().split(" ");
		String s2[] = br.readLine().split(" ");
	
		width = Integer.parseInt(s1[0]);
		height = Integer.parseInt(s1[1]);
		
		x = Integer.parseInt(s2[0]);
		y = Integer.parseInt(s2[1]);
		
		k = Integer.parseInt(br.readLine());
		
//		while(true) {
//			if(k==0) break;
//			
//			if(x == width || x == 0)
//				moveX *= -1;
//			if(y == height || y == 0)
//				moveY *= -1;
//			
//			x += moveX;
//			y += moveY;
//			
//			k--;
//		}
		
		remindX = k % (width * 2);
		remindY = k % (height * 2);
	
		while(true) {
			if(remindX==0) break;
			if(x == width || x == 0)
				moveX *= -1;
			x += moveX;
			remindX--;
		}
		
		while(true) {
			if(remindY==0) break;
			if(y == height || y == 0)
				moveY *= -1;
			y += moveY;
			remindY--;
		}
		System.out.println(x + " " + y);
	}
}
