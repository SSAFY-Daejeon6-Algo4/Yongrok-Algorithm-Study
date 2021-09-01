import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		int T = Integer.parseInt(in.readLine());
		
		for(int tc=1;tc<=T;tc++) {
			int n = Integer.parseInt(in.readLine());
			
			int[] prices = new int[n];
			
			st = new StringTokenizer(in.readLine());
			for(int i=0;i<n;i++) {
				prices[i] = Integer.parseInt(st.nextToken());
			}
			
			long income = 0;
			
			int max = n-1;
			for(int i=n-2;i>=0;--i) {
				if(prices[i] <= prices[max]) {
					income += prices[max] - prices[i];
				}else {
					max = i;
				}
			}
			
			sb.append("#").append(tc).append(" ").append(income).append("\n");
		}
		
		System.out.println(sb.toString());
	}

}
