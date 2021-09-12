import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> ans = new LinkedList<>();
        
        int day = 0;
        int idx = 0;
        int cnt = 0;
        
        while(idx < progresses.length){
            if(progresses[idx] + speeds[idx]*day < 100){
                day++;
                if(cnt != 0){
                    ans.add(cnt);
                    cnt = 0;
                }
                continue;
            }
            
            cnt++;
            idx++;
        }
        
        if(cnt != 0){
            ans.add(cnt);
            cnt = 0;
        }
        
        int[] answer = new int[ans.size()];
        for(int i=0;i<ans.size();i++){
            answer[i] = ans.get(i);
        }
        return answer;
    }
}
