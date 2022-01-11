import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        int n = citations.length;
        
        Arrays.sort(citations);
        
        int idx = 0;
        
        end: for(int h=0;h<=n;h++){
            if(n-idx >= h && idx <= h){
                answer = h;
            }else{
                break;
            }
            
            if(citations[idx] == h){
                while(citations[idx] == h){
                    idx++;
                    if(idx >= n) break end;
                }
            }
            
        }
        
        // for(int h=1;h<=1000;h++){
        //     int cnt = 0;
        //     for(int c: citations){
        //         if(h <= c) cnt++;
        //     }
        //     if(h <= cnt){
        //         answer = h;
        //     }
        // }
        
        return answer;
    }
}