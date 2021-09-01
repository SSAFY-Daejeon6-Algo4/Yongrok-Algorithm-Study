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
		
		if(n < 1 || 100 < n || n%2 == 0 || m < 1 || 4 < m) {
			sb.append("INPUT ERROR!\n");
			m = 0;
		}
		
		switch(m) {
		case 1:
			for(int i=0;i<n/2;i++) {
				for(int j=0;j<i+1;j++) {
					sb.append("*");
				}
				sb.append("\n");
			}
			for(int i=n/2;i<n;i++) {
				for(int j=0;j<n-i;j++) {
					sb.append("*");
				}
				sb.append("\n");
			}
			break;
		case 2:
			for(int i=0;i<n/2;i++) {
				for(int j=n/2;j<n-1-i;j++) {
					sb.append(" ");
				}
				for(int j=0;j<i+1;j++) {
					sb.append("*");
				}
				sb.append("\n");
			}
			for(int i=n/2;i<n;i++) {
				for(int j=n/2;j<i;j++) {
					sb.append(" ");
				}
				for(int j=0;j<n-i;j++) {
					sb.append("*");
				}
				sb.append("\n");
			}
			break;
		case 3:
			for(int i=0;i<n/2;i++) {
				for(int j=0;j<i;j++) {
					sb.append(" ");
				}
				for(int j=0;j<n-2*i;j++) {
					sb.append("*");
				}
				sb.append("\n");
			}
			for(int i=n/2;i<n;i++) {
				for(int j=0;j<n-i-1;j++) {
					sb.append(" ");
				}
				for(int j=0;j<2*(i-n/2)+1;j++) {
					sb.append("*");
				}
				sb.append("\n");
			}
			break;
		case 4:
			for(int i=0;i<n/2;i++) {
				for(int j=0;j<i;j++) {
					sb.append(" ");
				}
				for(int j=n/2;j<n-i;j++) {
					sb.append("*");
				}
				sb.append("\n");
			}
			for(int i=n/2;i<n;i++) {
				for(int j=0;j<n/2;j++) {
					sb.append(" ");
				}
				for(int j=n/2;j<i+1;j++) {
					sb.append("*");
				}
				sb.append("\n");
			}
			break;
		}
		
		System.out.println(sb.toString());
	}

}
