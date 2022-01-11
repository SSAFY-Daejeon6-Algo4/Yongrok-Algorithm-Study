import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        
        while(!s.equals("1")){
            
            int xlen = 0;
            char[] cs = s.toCharArray();
            for(int i=0;i<cs.length;i++){
                if(cs[i] == '1'){
                    xlen++;
                }
            }

            answer[1] += (s.length() - xlen); // 제거된 0의 개수
            
            s = dec2bin(xlen);
            
            answer[0] += 1; // 이진 변환의 횟수
        }
        
        return answer;
    }
    
    public String dec2bin(int num){
        StringBuilder rst = new StringBuilder();
        while(num > 0){
            rst.append(num%2);
            num /= 2;
        }
        return rst.reverse().toString();
    }
}