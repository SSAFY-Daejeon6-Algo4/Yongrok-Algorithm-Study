import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        StringBuilder answer = new StringBuilder();
        
        String[] numstr = new String[numbers.length];
        for(int i=0;i<numbers.length;i++){
            String str = Integer.toString(numbers[i]);
            numstr[i] = str;
        }
        
        Arrays.sort(numstr, (a, b) -> (b+a).compareTo(a+b));
        
        for(int i=0;i<numstr.length;i++){
            answer.append(numstr[i]);
        }
        
        // 가장 큰 수를 구했을 때 맨 앞자리가 0 이면 답은 0 !
        // numbers에 0만 있을 경우 그럴 수 있음 !
        // ex) {0, 0, 0, 0} -> "0000" -> "0"
        if(answer.substring(0, 1).equals("0")) return "0";
        
        return answer.toString();
    }
}