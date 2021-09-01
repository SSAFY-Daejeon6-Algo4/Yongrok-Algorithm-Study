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
			int winners = 0;
			int solvedProblems = 0;
			
			st = new StringTokenizer(in.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			for(int i=0;i<n;i++) {
				int sum = 0;
				st = new StringTokenizer(in.readLine());
				for(int j=0;j<m;j++) {
					int solve = Integer.parseInt(st.nextToken());
					if(solve == 1) {
						sum++;
					}
				}
				if(sum > solvedProblems) {
					winners = 1;
					solvedProblems = sum;
				}else if(sum == solvedProblems) {
					winners++;
				}
			}
			
			sb.append("#").append(tc).append(" ");
			sb.append(winners).append(" ").append(solvedProblems).append("\n");
		}
		System.out.println(sb.toString());
	}

}
