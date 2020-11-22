import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class b2581 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int a = Integer.parseInt(br.readLine());
		int b = Integer.parseInt(br.readLine());
		
		List<Integer> list = new ArrayList<Integer>();
		
		first:for(int i=a; i<=b;i++) {
			for(int j=1; j<=i;j++) {
				if(i==1) continue first;
				if(i%j==0 && i!=j && j!=1) continue first;
			}
			list.add(i);
		}
		
		if(list.size()==0) {
			System.out.println(-1);
		} else {
			int sum = 0;
			for(int i=0; i<list.size(); i++)
				sum += list.get(i);
			System.out.println(sum);
			System.out.println(list.get(0));
		}
	}
}
