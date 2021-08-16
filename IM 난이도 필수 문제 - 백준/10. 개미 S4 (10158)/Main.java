import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		st = new StringTokenizer(in.readLine());
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(in.readLine());
		int p = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());
		
		int t = Integer.parseInt(in.readLine());
		
		int x = (p+t)%w;
		int y = (q+t)%h;
		
		if(((p+t)/w)%2 == 1) {
			x = w - x;
		}
		
		if(((q+t)/h)%2 == 1) {
			y = h - y;
		}
		
		sb.append(x).append(" ").append(y);
		System.out.println(sb.toString());
	}

}
