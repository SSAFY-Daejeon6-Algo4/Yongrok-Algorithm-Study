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
			int up = 0;
			int down = 0;
			
			int n = Integer.parseInt(in.readLine());
			
			st = new StringTokenizer(in.readLine());
			
			int prev = Integer.parseInt(st.nextToken());
			
			for(int i=1;i<n;i++) {
				int cur = Integer.parseInt(st.nextToken());
				
				if(prev < cur) {
					up = Math.max(up, cur-prev);
				}else if(prev > cur) {
					down = Math.max(down, prev-cur);
				}
				
				prev = cur;
			}
			
			sb.append("#").append(tc).append(" ");
			sb.append(up).append(" ").append(down).append("\n");
		}
		
		System.out.println(sb.toString());
	}

}
