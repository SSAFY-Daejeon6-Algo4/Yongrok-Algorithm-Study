import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		int T = Integer.parseInt(in.readLine());
		
		for(int tc=1;tc<=T;tc++) {
			int answer = 0;
			int speed = 0;
			
			int n = Integer.parseInt(in.readLine());
			
			for(int sec=1;sec<=n;sec++) {
				st = new StringTokenizer(in.readLine());
				int command = Integer.parseInt(st.nextToken());
				int num = 0;
				
				switch(command) {
				case 0:
					break;
				case 1:
					num = Integer.parseInt(st.nextToken());
					speed += num;
					break;
				case 2:
					num = Integer.parseInt(st.nextToken());
					speed -= num;
					if(speed < 0) speed = 0;
					break;
				}
				
				answer += speed;
			}
			
			sb.append("#").append(tc).append(" ").append(answer).append("\n");
		}
		
		System.out.println(sb.toString());
	}

}
