import java.util.*;

class Solution {
    public int solution(String[][] relation) {
        int answer = 0;
        
        int m = relation[0].length;
        int n = relation.length;
        
        List<Integer> candidateKeyList = new ArrayList<>();
        
        for(int k=1;k<(1<<m);k++){
            Set<String> set = new HashSet<>();
            for(int i=0;i<n;i++){
                StringBuilder s = new StringBuilder();
                for(int j=0;j<m;j++){
                    if((k & (1<<j)) != 0){
                        s.append(" ").append(relation[i][j]);
                    }
                }
                set.add(s.toString());
            }
            
            boolean minimalityCheck = true;
            for(int i=0;i<candidateKeyList.size();i++){
                if((candidateKeyList.get(i) & k) == candidateKeyList.get(i)){
                    minimalityCheck = false;
                    break;
                }
            }
            
            if(set.size() == n && minimalityCheck == true){
                candidateKeyList.add(k);
                answer++;
            }
        }
        
        return answer;
    }
}