import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int n = Integer.parseInt(in.readLine().trim());
		int m = Integer.parseInt(in.readLine().trim());
		
		boolean[] broken = new boolean[10];
		
		if(m != 0) {
			st = new StringTokenizer(in.readLine().trim());
			for(int i=0;i<m;i++) {
				int k = Integer.parseInt(st.nextToken());
				broken[k] = true;
			}
		}
		
		int pure = Math.abs(n - 100);
		int min = Math.min(Integer.MAX_VALUE, pure);
		
		for(int i=0;i<1000000;i++) {
			String cur = Integer.toString(i);
			
			boolean invalid = false;
			for(int j=0;j<cur.length();j++) {
				if(broken[cur.charAt(j)-'0']) {
					invalid = true;
					break;
				}
			}
			if(invalid) continue;
			
			min = Math.min(min, Math.abs(n - i) + cur.length());
		}
		
		System.out.println(min);
	}

}
