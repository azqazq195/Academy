import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class b10818 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int count = Integer.parseInt(str);
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int min = Integer.parseInt(st.nextToken());
		int max = min;
		int number;
		
		for(int i=1;i<count;i++) {
			number=Integer.parseInt(st.nextToken());
			if(max<number) max = number;
			if(min>number) min = number;
		}
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(min + " " + max);
		bw.flush();
		bw.close();
		
	}
}
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
//		
//		int num[] = new int[n];
//		
//		num[0] = sc.nextInt();
//		
//		int min = num[0];
//		int max = num[0];
//		
//		for(int i=1;i<num.length;i++) {
//			num[i]=sc.nextInt();
//			if(max<num[i]) max = num[i];
//			if(min>num[i]) min = num[i];
//		}
//		
//		System.out.println(min +" "+max);
//		
//		
//		
//		
//	}
	
