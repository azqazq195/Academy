
public class p213 {
	public static void main(String[] args) {
		int[][] v = {{1,4},{3,4},{3,10}};
		 int[] answer = new int[2];
	        
	       for(int i=0; i<3; i++){
	    	   int countX=0;
	           int countY=0;
	            
	           for(int j=0; j<3; j++){
	               if(v[i][0]==v[j][0]) countX++;
	               if(v[i][1]==v[j][1]) countY++;
	           }
	           if(countX==1) answer[0]=v[i][0];
	           if(countY==1) answer[1]=v[i][1];
	       }
	       
	       System.out.println(answer[0]);
	       System.out.println(answer[1]);
	}
}
