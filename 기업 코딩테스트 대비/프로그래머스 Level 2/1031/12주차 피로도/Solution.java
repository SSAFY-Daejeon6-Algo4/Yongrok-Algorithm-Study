class Solution {
    
    public int[] idx;
    public int Answer;
    
    public int solution(int k, int[][] dungeons) {
        int n = dungeons.length; // 던전의 개수 (1이상 8이하 이므로 모든 순열을 구해보면 되겠다)
        
        Answer = 0; // 최대 던전 수 초기값 0
        idx = new int[n]; // 던전을 탐험할 순서를 저장할 배열
        perm(0, 0, n, dungeons, k); // 던전을 탐험할 모든 순서를 탐색해보자
        
        return Answer;
    }
    
    private void perm(int cnt, int flag, int n, int[][] dungeons, int k){
        if(cnt == n){
            int clear = 0; // 현재 순서에서의 유저가 탐험할수 있는 던전 개수
            int cur = k; // 유저의 현재 피로도
            for(int i=0;i<n;i++){
                int[] dungeon = dungeons[idx[i]]; // 해당 던전의 순서

                 // 유저의 현재 피로도 보다 던전의 최소 필요 피로도가 크다면 탐험 종료!!
                if(dungeon[0] > cur){
                    break;
                }

                // 피로도 소모
                cur -= dungeon[1];

                // 던전 클리어 횟수 +1
                clear += 1;
            }

            // 유저가 탐험할수 있는 최대 던전 수 갱신
            Answer = Math.max(Answer, clear);
            return;
        }
        for(int i=0;i<n;i++){
            // 이미 탐험 순서에 넣었는지 비트마스킹 확인
            if((flag & 1<<i) != 0) continue;
            
            // 현재 순서의 idx값 넣기
            idx[cnt] = i;

            // 현재 순서를 비트마스킹 해주고 다음 순서 체크
            perm(cnt+1, flag | 1<<i, n, dungeons, k);
        }
    }
}