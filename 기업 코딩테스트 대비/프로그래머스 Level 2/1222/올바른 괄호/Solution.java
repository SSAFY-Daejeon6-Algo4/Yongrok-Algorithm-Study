import java.util.*;

class Solution {
    boolean solution(String s) {
        char[] carr = s.toCharArray();
        Stack<Character> stk = new Stack<>();
        for(int i=0;i<carr.length;i++){
            if(carr[i] == ')'){
                if(stk.isEmpty()) {
                    return false;
                }
                stk.pop();
                continue;
            }
            stk.push('(');
        }
        
        if(!stk.isEmpty()) { 
            return false;
        }
        
        return true;
    }
}