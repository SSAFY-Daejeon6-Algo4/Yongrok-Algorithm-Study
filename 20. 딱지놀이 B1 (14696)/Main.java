import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		int n = Integer.parseInt(in.readLine());
		
		Round : for(int r=0;r<n;r++) {
			st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken());
			int[] A = new int[5];
			for(int i=0;i<a;i++) {
				int ttakji = Integer.parseInt(st.nextToken());
				A[ttakji]++;
			}
			
			st = new StringTokenizer(in.readLine());
			int b = Integer.parseInt(st.nextToken());
			int[] B = new int[5];
			for(int i=0;i<b;i++) {
				int ttakji = Integer.parseInt(st.nextToken());
				B[ttakji]++;
			}
			
			for(int i=4;i>=1;--i) {
				if(A[i] != B[i]) {
					if(A[i] > B[i]) sb.append("A\n");
					else sb.append("B\n");
					continue Round;
				}
			}
			
			sb.append("D\n");
		}
		System.out.println(sb.toString());
	}

}
