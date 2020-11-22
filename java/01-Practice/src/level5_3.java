class Solution53{
	  public void solution(int[][] rectangles) {
	        boolean board[][]= new boolean[1000][1000];
	        int answer=0;
	        
	        for(int a=0;a<rectangles.length;a++) {
	        	for(int y=rectangles[a][1];y<rectangles[a][3];y++) {
	        		for(int x=rectangles[a][0];x<rectangles[a][2];x++) {
	        			board[y][x]=true;
	        		}
	        	}
	        }

	        
	        
	        for(int y=0;y<board.length;y++) {
	        	for(int x=0;x<board[y].length;x++) {
	        		System.out.printf("%5s ",board[y][x]);
	        	}
	        	System.out.println();
	        }
	        
	        for(int y=0;y<10;y++) {
	        	for(int x=0;x<10;x++) {
	        		if(board[y][x])answer++;
	        	}
	        }
	        System.out.println(answer);
	    }   
}
public class level5_3 {
	public static void main(String[] args) {
		int rectangles[][]= {{1,1,6,5},{2,0,4,2},{2,4,5,7},{4,3,8,6},{7,5,9,7}};
		Solution53 so = new Solution53();
		
		so.solution(rectangles);
		
	}
}
