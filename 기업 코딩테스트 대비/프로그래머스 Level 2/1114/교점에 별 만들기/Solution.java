import java.util.*;

class Solution {
    public String[] solution(int[][] line) {
        ArrayList<int[]> starList = new ArrayList<>();
        
        for(int i=0;i<line.length-1;i++){
            for(int j=i+1;j<line.length;j++){
                int ai = line[i][0];
                int bi = line[i][1];
                int ci = line[i][2];
                int aj = line[j][0];
                int bj = line[j][1];
                int cj = line[j][2];
                
                if(ai == 0 && bj == 0){
                    int x = -cj/aj;
                    if(x*aj != -cj) continue;
                    int y = -ci/bi;
                    if(y*bi != -ci) continue;
                    
                    starList.add(new int[]{x,y});
                }else if(bi == 0 && aj == 0){
                    int x = -ci/ai;
                    if(x*ai != -ci) continue;
                    int y = -cj/bj;
                    if(y*bj != -cj) continue;
                    
                    starList.add(new int[]{x,y});
                }else if(ai != 0 && aj != 0){
                    int bk = bi * aj;
                    int ck = ci * aj;
                    int bl = bj * ai;
                    int cl = cj * ai;
                    
                    if((bk - bl) == 0) continue;
                    int y = -(ck - cl)/(bk - bl);
                    if(y*(bk-bl) != -(ck-cl)) continue;

                    int x = -(bi*y + ci)/ai;
                    if(x*ai != -(bi*y + ci)) continue;

                    starList.add(new int[]{x,y});
                }else if(bi != 0 && bj != 0){
                    int ak = ai * bj;
                    int ck = ci * bj;
                    int al = aj * bi;
                    int cl = cj * bi;

                    if((ak - al) == 0) continue;
                    int x = -(ck - cl)/(ak - al);
                    if(x*(ak-al) != -(ck-cl)) continue;

                    int y = -(ai*x + ci)/bi;
                    if(y*bi != -(ai*x + ci)) continue;

                    starList.add(new int[]{x,y});
                }
            }
        }
        
        int minX = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int minY = minX;
        int maxY = maxX;
        
        for(int[] star: starList){
            minX = Math.min(minX, star[0]);
            maxX = Math.max(maxX, star[0]);
            minY = Math.min(minY, star[1]);
            maxY = Math.max(maxY, star[1]);
        }
        
        char[][] ans = new char[maxY-minY+1][maxX-minX+1];
        for(int i=0;i<=maxY-minY;i++){
            for(int j=0;j<=maxX-minX;j++){
                ans[i][j] = '.';
            }
        }
        
        for(int[] star: starList){
            ans[star[1]-minY][star[0]-minX] = '*';
        }
        
        String[] answer = new String[maxY-minY+1];
        for(int i=0;i<=maxY-minY;i++){
            StringBuilder tmp = new StringBuilder();
            for(int j=0;j<=maxX-minX;j++){
                tmp.append(ans[i][j]);
            }
            answer[maxY-minY-i] = tmp.toString();
        }
        
        return answer;
    }
}