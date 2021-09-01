import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(in.readLine());
		
		if(n < 1 || 100 < n || n%2 == 0) {
			System.out.println("INPUT ERROR!\n");
			return;
		}
		
		for(int i=0;i<n/2;i++) {
			for(int j=0;j<i;j++) {
				sb.append(" ");
			}
			for(int j=0;j<2*i+1;j++) {
				sb.append("*");
			}
			sb.append("\n");
		}
		for(int i=n/2;i<n;i++) {
			for(int j=0;j<n-i-1;j++) {
				sb.append(" ");
			}
			for(int j=0;j<n - 2*(i-n/2);j++) {
				sb.append("*");
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}

}
