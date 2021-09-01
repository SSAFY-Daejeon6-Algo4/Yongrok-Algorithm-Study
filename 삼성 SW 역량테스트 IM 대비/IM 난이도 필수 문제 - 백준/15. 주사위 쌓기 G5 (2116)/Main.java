import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private static int calDiceSideMax(int down, int top, int[] dice) {
		int max = 0;
		
		for(int i=0;i<6;i++) {
			if(i == down || i == top) continue;
			max = Math.max(max, dice[i]);
		}
		
		return max;
	}
	
	private static int[] calMaxAndTop(int down, int[] dice) {
		int max = 0;
		int top = 0;
		for(int i=0;i<6;i++) {
			if(down == dice[i]) {
				if(i == 0) {
					top = dice[5];
					max = calDiceSideMax(0, 5, dice);
				}else if(i == 1) {
					top = dice[3];
					max = calDiceSideMax(1, 3, dice);
				}else if(i == 2) {
					top = dice[4];
					max = calDiceSideMax(2, 4, dice);
				}else if(i == 3) {
					top = dice[1];
					max = calDiceSideMax(3, 1, dice);
				}else if(i == 4) {
					top = dice[2];
					max = calDiceSideMax(4, 2, dice);
				}else if(i == 5) {
					top = dice[0];
					max = calDiceSideMax(5, 0, dice);
				}
			}
		}
		
		return new int[] {max,top};
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int n = Integer.parseInt(in.readLine());
		
		int[][] dices = new int[n][6];
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(in.readLine());
			for(int j=0;j<6;j++) {
				dices[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// a f 0 5
		// b d 1 3
		// c e 2 4
		
		int answer = 0;
		
		for(int i=0;i<6;i++) {
			int top = dices[0][i];

			int[] maxAndTop = new int[2];
			maxAndTop = calMaxAndTop(top, dices[0]);
			
			int sum = maxAndTop[0];

			for(int j=1;j<n;j++) {
				int[] mt = new int[2];
				mt = calMaxAndTop(top, dices[j]);
				sum += mt[0];
				top = mt[1];
			}
			
			answer = Math.max(answer, sum);
		}
		
		System.out.println(answer);
	}

}
