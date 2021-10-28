class Solution {
    public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();
        answer.append(number);
        
        int remainK = k;
        
        for(int i=0;i<k;i++){
            for(int j=0;j<answer.length()-1;j++){
                if(answer.charAt(j) < answer.charAt(j+1)){
                    answer.deleteCharAt(j);
                    remainK--;
                    break;
                }
            }
        }
        
        answer = answer.delete(answer.length()-remainK, answer.length());
        
        return answer.toString();
    }
}