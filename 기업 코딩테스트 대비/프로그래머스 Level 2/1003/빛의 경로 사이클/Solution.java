import java.util.*;

class Solution {
    public int[] solution(String[] grid) {
        List<Integer> ansList = new ArrayList<>();
        
        int n = grid.length;
        int m = grid[0].length();
        
        char[][] space = new char[n+2][m+2];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                space[i][j] = grid[i-1].charAt(j-1);
            }
        }
        
        boolean[][][] visited = new boolean[n+2][m+2][4];
        
        int[][] deltas = {{0,1},{1,0},{0,-1},{-1,0}};
        
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                int x = i;
                int y = j;
                for(int d = 0;d<4;d++){
                    int cnt = 0;
                    while(true){
                        x += deltas[d][0];
                        y += deltas[d][1];
                        
                        if(space[x][y] == 'S'){
                            if(visited[x][y][d]) break;
                            visited[x][y][d] = true;
                        }else if(space[x][y] == 'L'){
                            if(visited[x][y][d]) break;
                            visited[x][y][d] = true;
                            d = (d+3)%4;
                        }else if(space[x][y] == 'R'){
                            if(visited[x][y][d]) break;
                            visited[x][y][d] = true;
                            d = (d+1)%4;
                        }else{
                            if(d == 0) y = 0;
                            else if(d == 1) x = 0;
                            else if(d == 2) y = m+1;
                            else if(d == 3) x = n+1;
                            
                            continue;
                        }
                        cnt++;
                    }
                    if(cnt != 0){
                        ansList.add(cnt);
                    }
                }
            }
        }
        
        int[] answer = new int[ansList.size()];
        int ansIdx = 0;
        for(int ans: ansList){
            answer[ansIdx++] = ans;
        }
        Arrays.sort(answer);
        return answer;
    }
}