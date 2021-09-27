class Solution {
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        
        int[][] deltas1 = {{0,1},{1,0},{0,-1},{-1,0}};
        int[][] deltas2 = {{0,2},{2,0},{0,-2},{-2,0}};
        int[][] deltas3 = {{1,1},{1,-1},{-1,-1},{-1,1}};
        
        NextPlace: for(int tc=0;tc<places.length;tc++){
            char[][] place = new char[5][5];
            for(int i=0;i<5;i++){
                place[i] = places[tc][i].toCharArray();
            }
            
            for(int i=0;i<5;i++){
                for(int j=0;j<5;j++){
                    if(place[i][j] != 'P') continue;
                    
                    // 맨해튼 거리가 1일때
                    for(int d=0;d<4;d++){
                        int x = i + deltas1[d][0];
                        int y = j + deltas1[d][1];
                        
                        if(x < 0 || 5 <= x || y < 0 || 5 <= y) continue;
                        if(place[x][y] != 'P') continue;
                        
                        continue NextPlace;
                    }
                    
                    // 맨해튼 거리가 2일때 직선
                    for(int d=0;d<4;d++){
                        int x = i + deltas2[d][0];
                        int y = j + deltas2[d][1];
                        
                        if(x < 0 || 5 <= x || y < 0 || 5 <= y) continue;
                        if(place[x][y] != 'P') continue;
                        
                        // 응시자 사이에 파티션이 있을 경우
                        if(place[x-deltas2[d][0]/2][y-deltas2[d][1]/2] == 'X') continue;
                        
                        continue NextPlace;
                    }
                    
                    // 맨해튼 거리가 2일때 대각선
                    for(int d=0;d<4;d++){
                        int x = i + deltas3[d][0];
                        int y = j + deltas3[d][1];
                        
                        if(x < 0 || 5 <= x || y < 0 || 5 <= y) continue;
                        if(place[x][y] != 'P') continue;
                        
                        // 응시자 사이에 파티션이 모두 있을 경우
                        if(place[i][y] == 'X' && place[x][j] == 'X') continue;
                        
                        continue NextPlace;
                    }
                }
            }
            
            answer[tc] = 1;
        }
        
        return answer;
    }
}