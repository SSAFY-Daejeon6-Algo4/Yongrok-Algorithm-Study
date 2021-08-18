import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		int T = Integer.parseInt(in.readLine());
		
		char[] hole = {'A','B','C','A','C','C','C','C','C','C','C','C','C','C','A','A','A','A','C','C','C','C','C','C','C','C'};
		
		for(int tc=1;tc<=T;tc++) {
			st = new StringTokenizer(in.readLine());
			String str1 = st.nextToken();
			String str2 = st.nextToken();
			
			StringBuilder sb1 = new StringBuilder();
			StringBuilder sb2 = new StringBuilder();
			for(int i=0;i<str1.length();i++) {
				sb1.append(hole[str1.charAt(i)-'A']);
			}
			for(int i=0;i<str2.length();i++) {
				sb2.append(hole[str2.charAt(i)-'A']);
			}
			str1 = sb1.toString();
			str2 = sb2.toString();
			
			String answer = "SAME";
			if(!str1.equals(str2)) {
				answer = "DIFF";
			}
			
			sb.append("#").append(tc).append(" ").append(answer).append("\n");
		}
		System.out.println(sb.toString());
	}

}
