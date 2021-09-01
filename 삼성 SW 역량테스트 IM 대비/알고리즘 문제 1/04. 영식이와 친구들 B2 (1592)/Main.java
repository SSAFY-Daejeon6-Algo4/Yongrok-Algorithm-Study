import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		
		int answer = 0;
		int[] cnt = new int[n];
		int idx = 0;
		while(true) {
			cnt[idx]++;
			if(cnt[idx] == m) {
				break;
			}
			
			if(cnt[idx]%2 == 1) {
				idx = (idx+l)%n;
			}else {
				idx = (idx-l+n)%n;
			}
			answer++;
		}
		System.out.println(answer);
	}

}
