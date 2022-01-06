class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        
        boolean isFirst = true;
        for(int i=0;i<s.length();i++){
            if(s.substring(i, i+1).equals(" ")){
                answer.append(" ");
                isFirst = true;
                continue;
            }
            
            if(isFirst) {
                answer.append(s.substring(i, i+1).toUpperCase());
                isFirst = false;
                continue;
            }
            
            answer.append(s.substring(i, i+1).toLowerCase());
        }
        
        return answer.toString();
    }
}