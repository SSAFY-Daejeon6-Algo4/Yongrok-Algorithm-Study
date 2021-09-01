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
			st = new StringTokenizer(in.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			int[][] board = new int[n][n];
			board[n/2-1][n/2-1] = 2;
			board[n/2-1][n/2] = 1;
			board[n/2][n/2-1] = 1;
			board[n/2][n/2] = 2;
			
			for(int turn=1;turn<=m;turn++) {
				st = new StringTokenizer(in.readLine());
				int x = Integer.parseInt(st.nextToken())-1;
				int y = Integer.parseInt(st.nextToken())-1;
				int stone = Integer.parseInt(st.nextToken());
				
				board[x][y] = stone;
				
				int[][] deltas = {
					{0,1},{1,0},{0,-1},{-1,0},
					{1,1},{1,-1},{-1,-1},{-1,1}
				};
				
				for(int d=0;d<8;d++) {
					int nx = x + deltas[d][0];
					int ny = y + deltas[d][1];

					if(nx < 0 || n <= nx || ny < 0 || n <= ny) continue;
					if(board[nx][ny] == 0 || board[nx][ny] == stone) continue;
					
					boolean correctDir = false;

					for(int i=0;i<n;i++) {
						int tx = nx + deltas[d][0]*i;
						int ty = ny + deltas[d][1]*i;
						
						if(tx < 0 || n <= tx || ty < 0 || n <= ty) break;
						if(board[tx][ty] == 0) break;
						
						if(board[tx][ty] == stone) {
							correctDir = true;
							break;
						}
					}
					
					while(correctDir) {
						board[nx][ny] = stone;
						
						nx += deltas[d][0];
						ny += deltas[d][1];
						
						if(board[nx][ny] == stone) break;
					}
				}
			}
			
			int black = 0;
			int white = 0;
			
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					if(board[i][j] == 1) {
						black++;
					}else if(board[i][j] == 2) {
						white++;
					}
				}
			}
			
			sb.append("#").append(tc).append(" ");
			sb.append(black).append(" ").append(white).append("\n");
		}
		System.out.println(sb.toString());
	}

}
