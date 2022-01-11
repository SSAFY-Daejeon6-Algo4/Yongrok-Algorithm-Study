class Solution {
    
    public static int cnt;
    
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        
        int[][] map = new int[n][n];
        for(int i=0;i<wires.length;i++){
            map[wires[i][0]-1][wires[i][1]-1] = 1;
            map[wires[i][1]-1][wires[i][0]-1] = 1;
        }
        
        for(int[] wire: wires){
            int i = wire[0]-1;
            int j = wire[1]-1;
            
            boolean[] visited = new boolean[n];
            visited[j] = true; //현재 꺼 미리 세기
            visited[i] = true; //선을 끊어줌
            cnt = 1;
            dfs(j, n, map, visited);
            int a = cnt;
            int b = n - cnt;
            
            answer = Math.min(answer, Math.abs(a-b));
        }
        
        return answer;
    }
    
    private static void dfs(int a, int n, int[][] map, boolean[] visited){
        for(int i=0;i<n;i++){
            if(map[a][i] != 1) continue;
            if(visited[i]) continue;
            visited[i] = true;
            
            cnt++;
            dfs(i, n, map, visited);
        }
    }
}