import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		int l = Integer.parseInt(in.readLine());
		int n = Integer.parseInt(in.readLine());
		
		int greedy = 0;
		int lucky = 0;
		
		int[] cake = new int[l];
		
		int maxG = 0;
		int maxL = 0;
		
		for(int i=1;i<=n;i++) {
			st = new StringTokenizer(in.readLine());
			int p = Integer.parseInt(st.nextToken())-1;
			int k = Integer.parseInt(st.nextToken())-1;
			
			if(maxG < k-p+1) {
				maxG = k-p+1;
				greedy = i;
			}
			
			int sum = 0;
			for(int j=p;j<=k;j++) {
				if(cake[j] != 0) continue;
				cake[j] = i;
				sum++;
			}
			
			if(maxL < sum) {
				maxL = sum;
				lucky = i;
			}
		}
		
		sb.append(greedy).append("\n").append(lucky).append("\n");
		
		System.out.println(sb.toString());
	}

}
