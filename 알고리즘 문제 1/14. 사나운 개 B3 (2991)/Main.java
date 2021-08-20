import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		st = new StringTokenizer(in.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(in.readLine());
		int p = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		
		int[] pmn = new int[] {p, m, n};
		for(int scaredPerson: pmn) {
			int dogAttack = 0;
			if((scaredPerson-1)%(a+b)+1 - a <= 0) dogAttack++;
			if((scaredPerson-1)%(c+d)+1 - c <= 0) dogAttack++;
			sb.append(dogAttack).append("\n");
		}
		
		System.out.println(sb.toString());
	}

}
