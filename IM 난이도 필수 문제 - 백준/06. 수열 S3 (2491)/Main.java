import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int n = Integer.parseInt(in.readLine());
		
		int[] arr = new int[n];
		
		st = new StringTokenizer(in.readLine());
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int max = 0;
		int increaseCnt = 1;
		int decreaseCnt = 1;
		
		for(int i=1;i<n;i++) {
			int prev = arr[i-1];
			int cur = arr[i];
			
			if(prev < cur) {
				max = Math.max(max, decreaseCnt);
				increaseCnt++;
				decreaseCnt = 1;
			}else if(prev > cur) {
				max = Math.max(max, increaseCnt);
				decreaseCnt++;
				increaseCnt = 1;
			}else {
				increaseCnt++;
				decreaseCnt++;
			}
		}
		
		max = Math.max(max, increaseCnt);
		max = Math.max(max, decreaseCnt);
		
		System.out.println(max);
	}

}
