import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		if(n < 1 || 100 < n || m < 1 || 3 < m) {
			sb.append("INPUT ERROR!\n");
			m = 0;
		}
		
		switch(m) {
		case 1:
			for(int i=0;i<n;i++) {
				for(int j=0;j<i+1;j++) {
					sb.append("*");
				}
				sb.append("\n");
			}
			break;
		case 2:
			for(int i=0;i<n;i++) {
				for(int j=i;j<n;j++) {
					sb.append("*");
				}
				sb.append("\n");
			}
			break;
		case 3:
			for(int i=0;i<n;i++) {
				for(int j=i;j<n-1;j++) {
					sb.append(" ");
				}
				for(int j=0;j<2*i+1;j++) {
					sb.append("*");
				}
				sb.append("\n");
			}
			break;
		}
		
		System.out.println(sb.toString());
	}

}
