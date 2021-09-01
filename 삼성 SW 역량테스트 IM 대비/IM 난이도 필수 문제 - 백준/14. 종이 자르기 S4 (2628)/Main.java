import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(in.readLine());
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		
		int[] x = new int[h+1];
		int[] y = new int[w+1];
		
		int n = Integer.parseInt(in.readLine());
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(in.readLine());
			int cutDir = Integer.parseInt(st.nextToken());
			int cutNum = Integer.parseInt(st.nextToken());
			
			if(cutDir == 0) {
				x[cutNum] = 1;
			}else {
				y[cutNum] = 1;
			}
		}
		
		x[0] = 1;
		y[0] = 1;
		x[h] = 1;
		y[w] = 1;
		
		int cnt = 1;
		
		int maxX = 0;
		for(int i=0;i<=h;i++) {
			if(x[i] == 1) {
				maxX = Math.max(maxX, cnt);
				cnt = 1;
			}else {
				cnt++;
			}
		}
		
		cnt = 1;
		
		int maxY = 0;
		for(int i=0;i<=w;i++) {
			if(y[i] == 1) {
				maxY = Math.max(maxY, cnt);
				cnt = 1;
			}else {
				cnt++;
			}
		}
		System.out.println(maxX*maxY);
	}

}
