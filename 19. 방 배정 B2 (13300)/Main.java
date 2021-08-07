import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[] male = new int[7];
		int[] female = new int[7];
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(in.readLine());
			int s = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			if(s == 0) {
				male[y]++;
			}else {
				female[y]++;
			}
		}
		
		int answer = 0;
		
		for(int i=1;i<=6;i++) {
			int m = male[i];
			int f = female[i];
			
			if(m > 0) {
				answer += (m-1)/k + 1;
			}
			
			if(f > 0) {
				answer += (f-1)/k + 1;
			}
		}
		
		System.out.println(answer);
	}

}
