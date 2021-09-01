import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int[][] paper = new int[100][100];
		
		for(int s=0;s<4;s++) {
			st = new StringTokenizer(in.readLine());
			int x_bot = Integer.parseInt(st.nextToken());
			int y_bot = Integer.parseInt(st.nextToken());
			int x_top = Integer.parseInt(st.nextToken());
			int y_top = Integer.parseInt(st.nextToken());
			
			for(int i=x_bot;i<x_top;i++) {
				for(int j=y_bot;j<y_top;j++) {
					paper[i][j] = 1;
				}
			}
		}
		
		int cnt = 0;

		for(int i=0;i<100;i++) {
			for(int j=0;j<100;j++) {
				if(paper[i][j] == 1) cnt++;
			}
		}
		
		System.out.println(cnt);
	}

}
