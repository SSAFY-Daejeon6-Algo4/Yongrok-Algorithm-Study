import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int answer = -1;
        
        int n = maps.length;
        int m = maps[0].length;
        
        int[][] deltas = {{0,1},{1,0},{0,-1},{-1,0}};
        
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0, 0, 1});
        
        while(!q.isEmpty()){
            int x = q.peek()[0];
            int y = q.peek()[1];
            int cnt = q.peek()[2];
            q.poll();
            
            if(x == n-1 && y == m-1){
                answer = cnt;
                break;
            }
            
            for(int d=0;d<4;d++){
                int nx = x + deltas[d][0];
                int ny = y + deltas[d][1];
                
                if(nx < 0 || n <= nx || ny < 0 || m <= ny) continue;
                if(maps[nx][ny] == 0) continue;
                maps[nx][ny] = 0;
                
                q.offer(new int[]{nx, ny, cnt+1});
            }
        }
        
        return answer;
    }
}