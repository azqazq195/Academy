import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
10 8
3
0 3
1 4
0 2
 */

public class b2628 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<Integer> heightList = new ArrayList<Integer>();
		List<Integer> widthList = new ArrayList<Integer>();
		int height, width;
		int k, v, n;
		int max = 0;
		
		String temp[] = br.readLine().split(" ");
		width = Integer.parseInt(temp[0]);
		height = Integer.parseInt(temp[1]);
		n = Integer.parseInt(br.readLine());
		
		for(int i=0; i<n; i++ ) {
			temp = br.readLine().split(" ");
			k = Integer.parseInt(temp[0]);
			v = Integer.parseInt(temp[1]);
			if(k==0) heightList.add(v);
			else widthList.add(v);
		}
		Collections.sort(heightList);
		Collections.sort(widthList);
		
		int heightCut[] = new int[heightList.size()+1];
		int widthCut[] = new int[widthList.size()+1];
		
		for(int i=0; i<heightCut.length; i++) {
			if(i==0) {
				heightCut[i] = heightList.get(i);
			}
			else if(i==heightCut.length-1) {
				heightCut[i] = height - heightList.get(i-1);
			}
			else {
				heightCut[i] = heightList.get(i) - heightList.get(i-1);
			}
		}
		
		for(int i=0; i<widthCut.length; i++) {
			if(i==0) {
				widthCut[i] = widthList.get(i);
			}
			else if(i==widthCut.length-1) {
				widthCut[i] = width - widthList.get(i-1);
			}
			else {
				widthCut[i] = widthList.get(i) - widthList.get(i-1);
			}
		}
		
		for(int i=0; i<heightCut.length; i++) {
			for(int j=0; j<widthCut.length; j++) {
				if(max < heightCut[i] * widthCut[j])
					max = heightCut[i] * widthCut[j];
			}
		}
		
		System.out.println(max);
	}
}
