import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		st = new StringTokenizer(in.readLine());
		int c = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		
		int k = Integer.parseInt(in.readLine());
		
		if(k > r*c) {
			System.out.println(0);
			return;
		}
		
		int[][] seat = new int[c][r];
		
		int[][] deltas = {{0,1},{1,0},{0,-1},{-1,0}};
		int d = 0;
		
		int cnt = 0;
		
		int x = 0;
		int y = 0;
		
		seat[x][y] = ++cnt;
		
		while(cnt != k) {
			x += deltas[d][0];
			y += deltas[d][1];
			
			if(x < 0 || c <= x || y < 0 || r <= y || seat[x][y] != 0) {
				x -= deltas[d][0];
				y -= deltas[d][1];
				d = (d+1)%4;
				continue;
			}
			
			seat[x][y] = ++cnt;
		}
		
		sb.append(x+1).append(" ").append(y+1);
		
		System.out.println(sb.toString());
	}

}
