import java.util.*;

class Solution {
    public int solution(String dirs) {
        int answer = 0;
        
        int[][] deltas = {{0,1},{1,0},{0,-1},{-1,0}};
        
        int x = 0;
        int y = 0;
        
        Set<String> set = new HashSet<>();
        
        for(char dir: dirs.toCharArray()){
            int d = 3;
            if(dir == 'D'){
                d = 1;
            }else if(dir == 'R'){
                d = 0;
            }else if(dir == 'L'){
                d = 2;
            }
            
            int nx = x + deltas[d][0];
            int ny = y + deltas[d][1];
            
            if(nx < -5 || 5 < nx || ny < -5 || 5 < ny) continue;
            
            if(set.add("" + x + y + nx + ny)){
                answer++;
            }
            set.add("" + nx + ny + x + y);
            
            x = nx;
            y = ny;
        }
        
        return answer;
    }
}