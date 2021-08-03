import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int[][] board = new int[5][5];
		for(int i=0;i<5;i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for(int j=0;j<5;j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[] numbers = new int[25];
		for(int i=0;i<5;i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for(int j=0;j<5;j++) {
				int num = Integer.parseInt(st.nextToken());
				numbers[i*5+j] = num;
			}
		}
		
		int[][] deltas = {
			{1,0},{-1,0},{0,1},{0,-1},
			{1,1},{-1,-1},{1,-1},{-1,1},
		};
		
		int bingoCount = 0;
		int answer = 0;
		
		out : for(int k=0;k<25;k++) {
			int num = numbers[k];
			in : for(int i=0;i<5;i++) {
				for(int j=0;j<5;j++) {
					if(num == board[i][j]) {
						board[i][j] = 0;
						int[] bingo = new int[8];
						for(int d=0;d<8;d++) {
							for(int b=1;b<5;b++) {
								int x = i + deltas[d][0]*b;
								int y = j + deltas[d][1]*b;
								
								if(x < 0 || 5 <= x || y < 0 || 5 <= y) break;
								if(board[x][y] == 0) {
									bingo[d]++;
								}
							}
							if(d%2 == 1) {
								if(bingo[d-1] + bingo[d] == 4) {
									bingoCount++;
									if(bingoCount == 3) {
										answer = k+1;
										break out;
									}
								}
							}
						}
						break in;
					}
				}
			}
		}
		
		System.out.println(answer);
	}

}
