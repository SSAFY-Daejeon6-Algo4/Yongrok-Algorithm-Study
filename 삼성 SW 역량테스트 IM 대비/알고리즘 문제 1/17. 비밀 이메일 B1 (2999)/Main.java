import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String msg = in.readLine();
		
		int r = 1;
		int c = msg.length();
		
		int idx = 2;
		while(idx < msg.length()) {
			if(msg.length()%idx == 0) {
				if(idx <= msg.length()/idx) {
					r = idx;
					c = msg.length()/idx;
				}else {
					break;
				}
			}
			idx++;
		}
		
		int msgIdx = 0;
		char[][] table = new char[r][c];
		for(int i=0;i<c;i++) {
			for(int j=0;j<r;j++) {
				table[j][i] = msg.charAt(msgIdx++);
			}
		}
		
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				sb.append(table[i][j]);
			}
		}
		
		System.out.println(sb.toString());
	}

}
