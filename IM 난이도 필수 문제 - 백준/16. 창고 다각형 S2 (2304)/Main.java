import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int n = Integer.parseInt(in.readLine());
		
		int[][] pillar = new int[n][2];
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(in.readLine());
			int l = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			
			pillar[i][0] = l;
			pillar[i][1] = h;
		}
		
		Arrays.sort(pillar, (a,b)->(a[0] - b[0]));
		
		int answer = 0;
		
		Stack<Integer> stk = new Stack<>();
		
		for(int i=1;i<n;i++) {
			int pl = pillar[i-1][0];
			int ph = pillar[i-1][1];
			int cl = pillar[i][0];
			int ch = pillar[i][1];
			
			if(ph >= ch) {
				stk.push(i-1);
			}else {
				if(!stk.isEmpty()) {
					int max = 0;
					while(!stk.isEmpty()) {
						if(pillar[stk.peek()][1] > ch) {
							break;
						}
						max = stk.pop();
					}
					if(stk.isEmpty()) answer += pillar[max][1]*(cl - pillar[max][0]);
				}else {
					answer += ph*(cl - pl);
				}
			}
		}
		
		int curIdx = n-1;
		
		while(!stk.isEmpty()) {
			answer += pillar[curIdx][1]*(pillar[curIdx][0] - pillar[stk.peek()][0]);
			curIdx = stk.pop();
		}
		
		answer += pillar[curIdx][1];
		
		System.out.println(answer);
	}

}
