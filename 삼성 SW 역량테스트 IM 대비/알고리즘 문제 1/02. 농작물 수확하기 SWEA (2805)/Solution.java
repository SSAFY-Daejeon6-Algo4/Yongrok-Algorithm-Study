import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(in.readLine());
		
		for(int tc=1;tc<=T;tc++) {
			int n = Integer.parseInt(in.readLine());
			
			int[][] farm = new int[n][n];
			
			for(int i=0;i<n;i++) {
				char[] rL = in.readLine().toCharArray();
				for(int j=0;j<n;j++) {
					farm[i][j] = rL[j]-'0';
				}
			}
			
			int income = 0;
			
			for(int i=0;i<n/2;i++) {
				for(int j=n/2-i;j<n-n/2+i;j++) {
					income += farm[i][j];
				}
			}
			for(int i=n/2;i<n;i++) {
				for(int j=i-n/2;j<n-i+n/2;j++) {
					income += farm[i][j];
				}
			}
			
			sb.append("#"+tc+" "+income+"\n");
		}
		System.out.println(sb.toString());
	}

}
