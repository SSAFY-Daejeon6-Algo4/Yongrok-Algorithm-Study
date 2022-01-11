class Solution {
    
    public static int Sum;
    
    private static void dfs(int x, int y, int area, int m, int n, int[][] picture, boolean[][] visited){
        if(x < 0 || m <= x || y < 0 || n <= y) return;
        if(picture[x][y] != area) return;
        if(visited[x][y]) return;
        visited[x][y] = true;
        
        Sum++;
        
        dfs(x, y+1, area, m, n, picture, visited);
        dfs(x+1, y, area, m, n, picture, visited);
        dfs(x, y-1, area, m, n, picture, visited);
        dfs(x-1, y, area, m, n, picture, visited);
    }
    
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        boolean visited[][] = new boolean[m][n];
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(visited[i][j]) continue;
                if(picture[i][j] == 0) continue;
                
                numberOfArea++;
                
                Sum = 0;
                dfs(i, j, picture[i][j], m, n, picture, visited);
                maxSizeOfOneArea = Math.max(maxSizeOfOneArea, Sum);
            }
        }
        
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
}
