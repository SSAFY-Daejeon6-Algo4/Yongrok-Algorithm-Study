import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(in.readLine());
		
		for(int tc=1;tc<=T;tc++) {
			int answer = 0;
			
			char[] laserAndStickState = in.readLine().toCharArray();
			
			Stack<Character> stk = new Stack<>();
			
			boolean laser = false;
			
			for(int i=0;i<laserAndStickState.length;i++) {
				char cur = laserAndStickState[i];
				
				if(cur == '(') {
					laser = true;
					stk.add(cur);
				}else if(cur == ')') {
					if(laser) {
						stk.pop();
						answer += stk.size();
						laser = false;
					}else {
						stk.pop();
						answer += 1;
					}
				}
			}
			
			sb.append("#").append(tc).append(" ").append(answer).append("\n");
		}
		System.out.println(sb.toString());
	}

}
