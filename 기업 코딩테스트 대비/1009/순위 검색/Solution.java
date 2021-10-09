import java.util.*;

// TODO: 효율성 고려 필요!

class Solution {
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        int ansIdx = 0;
        
        StringTokenizer st = null;
        
        for(String qu: query){
            int cnt = 0;
            
            qu = qu.replace("and ", "");
            st = new StringTokenizer(qu);
            char qa = st.nextToken().charAt(0);
            char qb = st.nextToken().charAt(0);
            char qc = st.nextToken().charAt(0);
            char qd = st.nextToken().charAt(0);
            int qe = Integer.parseInt(st.nextToken());
            
            for(String inf: info){
                st = new StringTokenizer(inf);
                char a = st.nextToken().charAt(0);
                char b = st.nextToken().charAt(0);
                char c = st.nextToken().charAt(0);
                char d = st.nextToken().charAt(0);
                int e = Integer.parseInt(st.nextToken());
                
                if(qe > e) continue;
                if(qa != '-' && qa != a) continue;
                if(qb != '-' && qb != b) continue;
                if(qc != '-' && qc != c) continue;
                if(qd != '-' && qd != d) continue;
                
                cnt++;
            }
            
            answer[ansIdx++] = cnt;
        }
        
        return answer;
    }
}