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
			int[][] sudoku = new int[9][9];
			
			for(int i=0;i<9;i++) {
				st = new StringTokenizer(in.readLine());
				for(int j=0;j<9;j++) {
					sudoku[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int answer = 1;
			
			out: for(int i=0;i<9;i++) {
				boolean[] checked = new boolean[9];
				for(int j=0;j<9;j++) {
					int num = sudoku[i][j]-1;
					if(checked[num]) {
						answer = 0;
						break out;
					}
					checked[num] = true;
				}
			}
			
			out: for(int j=0;j<9;j++) {
				boolean[] checked = new boolean[9];
				for(int i=0;i<9;i++) {
					int num = sudoku[i][j]-1;
					if(checked[num]) {
						answer = 0;
						break out;
					}
					checked[num] = true;
				}
			}
			
			out: for(int x=0;x<3;x++) {
				for(int y=0;y<3;y++) {
					boolean[] checked = new boolean[9];
					for(int i=3*x;i<3*x + 3;i++) {
						for(int j=3*y;j<3*y + 3;j++) {
							int num = sudoku[i][j]-1;
							if(checked[num]) {
								answer = 0;
								break out;
							}
							checked[num] = true;
						}
					}
				}
			}
			
			sb.append("#").append(tc).append(" ").append(answer).append("\n");
		}
		
		System.out.println(sb.toString());
	}

}
