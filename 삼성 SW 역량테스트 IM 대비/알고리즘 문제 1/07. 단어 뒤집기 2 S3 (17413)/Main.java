import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String s = in.readLine();
		
		boolean isTag = false;
		StringBuilder tmp = new StringBuilder();
		for(int i=0;i<s.length();i++) {
			char c = s.charAt(i);
			if(c == '<' || c == '>' || c == ' ') {
				if(isTag) {
					sb.append(tmp.toString());
				}else {
					sb.append(tmp.reverse().toString());
				}
				
				tmp = new StringBuilder();
				
				sb.append(c);
				
				if(c == '<') {
					isTag = true;
				}else if(c == '>') {
					isTag = false;
				}
			}else {
				tmp.append(c);
			}
		}
		sb.append(tmp.reverse().toString());
		
		System.out.println(sb.toString());
	}

}
