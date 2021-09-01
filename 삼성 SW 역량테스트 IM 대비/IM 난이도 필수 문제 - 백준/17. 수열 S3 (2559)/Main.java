import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[] tempa = new int[n];
		st = new StringTokenizer(in.readLine());
		for(int i=0;i<n;i++) {
			tempa[i] = Integer.parseInt(st.nextToken());
		}
		
		int max = Integer.MIN_VALUE;
		
		for(int i=0;i<=n-k;i++) {
			int sum = 0;
			for(int j=i;j<i+k;j++) {
				sum += tempa[j];
			}
			max = Math.max(max, sum);
		}
		
		System.out.println(max);
	}

}
