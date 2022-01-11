class Solution {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;

        int[][] map = new int[N][N];
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(i == j) continue;
                map[i][j] = Integer.MAX_VALUE/2;
            }
        }
        
        for(int i=0;i<road.length;i++){
            int a = road[i][0]-1;
            int b = road[i][1]-1;
            int c = road[i][2];
            
            map[a][b] = Math.min(map[a][b], c);
            map[b][a] = Math.min(map[b][a], c);
        }
        
        for(int k=0;k<N;k++){
            for(int j=0;j<N;j++){
                map[0][j] = Math.min(map[0][j], map[0][k] + map[k][j]);
            }
        }
        
        for(int i=0;i<N;i++){
            if(map[0][i] <= K) answer++;
        }
        
        return answer;
    }
}