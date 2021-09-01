import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(in.readLine());
		
		int[][] snail = new int[n][n];
		
		int[][] deltas = {{0,1},{1,0},{0,-1},{-1,0}};
		int d = 0;
		
		int cnt = 0;
		int x = 0;
		int y = 0;
		snail[x][y] = ++cnt;
		
		while(cnt < n*n) {
			x += deltas[d][0];
			y += deltas[d][1];
			
			if(x < 0 || n <= x || y < 0 || n <= y || snail[x][y] != 0) {
				x -= deltas[d][0];
				y -= deltas[d][1];
				d = (d+1)%4;
				continue;
			}
			
			snail[x][y] = ++cnt;
		}
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				sb.append(snail[i][j]).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}

}
