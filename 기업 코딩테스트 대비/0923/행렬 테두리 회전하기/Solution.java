class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        
        int[][] matrix = new int[rows][columns];
        int cnt = 1;
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                matrix[i][j] = cnt++;
            }
        }
        
        int[][] deltas = {{0,1},{1,0},{0,-1},{-1,0}};
        
        for(int tc=0;tc<queries.length;tc++){
            int x1 = queries[tc][0]-1;
            int y1 = queries[tc][1]-1;
            int x2 = queries[tc][2]-1;
            int y2 = queries[tc][3]-1;
            
            int d = 0;
            int prev = matrix[x1][y1];
            
            int min = prev;
            
            int x = x1;
            int y = y1;
            
            while(d < 4){
                x += deltas[d][0];
                y += deltas[d][1];
                
                if(x < x1 || x2 < x || y < y1 || y2 < y) {
                    x -= deltas[d][0];
                    y -= deltas[d][1];
                    d++;
                    continue;
                }
                
                int cur = matrix[x][y];
                min = Math.min(min, cur);
                matrix[x][y] = prev;
                
                prev = cur;
            }
            
            answer[tc] = min;
        }
        
        return answer;
    }
}