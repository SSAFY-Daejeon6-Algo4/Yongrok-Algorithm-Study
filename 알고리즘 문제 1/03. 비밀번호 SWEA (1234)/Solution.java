import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		for(int tc=1;tc<=10;tc++) {
			st = new StringTokenizer(in.readLine());
			int n = Integer.parseInt(st.nextToken());
			char[] password = st.nextToken().toCharArray();
			
			List<Character> pw = new ArrayList<>();
			for(int i=0;i<n;i++) {
				pw.add(password[i]);
			}
			
			for(int i=1;i<pw.size();i++) {
				if(pw.get(i-1) == pw.get(i)) {
					while(true) {
						if(i-1 < 0 || pw.size() <= i) break;
						if(pw.get(i-1) != pw.get(i)) break;
						pw.remove(i-1);
						pw.remove(i-1);
						i--;
					}
				}
			}

			StringBuilder answer = new StringBuilder();
			
			for(int i=0;i<pw.size();i++) {
				answer.append(pw.get(i));
			}
			
			sb.append("#").append(tc).append(" ").append(answer.toString()).append("\n");
		}
		System.out.println(sb.toString());
	}

}
