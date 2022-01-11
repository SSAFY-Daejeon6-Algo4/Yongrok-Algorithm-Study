import java.util.*;

class Solution{
    public int solution(String s){
        int answer = 0;
        
        Stack<Character> stk = new Stack<>();
        stk.add(s.charAt(0));
        
        for(int i=1;i<s.length();i++){
            if(!stk.isEmpty() && stk.peek() == s.charAt(i)){
                stk.pop();
            }else{
                stk.add(s.charAt(i));
            }
        }
        
        if(stk.isEmpty()) answer = 1;
        
        return answer;
    }
}
