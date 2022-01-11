class Solution {
    public int[] solution(int n) {
        int[] answer = new int[n*(n+1)/2];
        
        int[][] deltas = {{1,0},{0,1},{-1,-1}};
        int d = 0;
        
        int[][] snail = new int[n][n];
        int cnt = 1;
        int x = 0;
        int y = 0;
        snail[x][y] = cnt++;
        while(cnt <= n*(n+1)/2){
            int nx = x + deltas[d][0];
            int ny = y + deltas[d][1];
            
            if(nx < 0 || n <= nx || ny < 0 || n <= ny) {
                d = (d+1)%3;
                continue;
            }
            if(snail[nx][ny] != 0){
                d = (d+1)%3;
                continue;
            }
            
            snail[nx][ny] = cnt++;
            
            x = nx;
            y = ny;
        }
        
        int ansIdx = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<i+1;j++){
                answer[ansIdx++] = snail[i][j];
            }
        }
        
        return answer;
    }
}