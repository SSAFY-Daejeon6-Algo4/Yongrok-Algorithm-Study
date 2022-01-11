import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        for(int i=0;i<s.length();i++){
            
            Stack<Character> stk = new Stack<>();
            for(int j=0;j<s.length();j++){
                int start = (i+j)%s.length();
                char cur = s.charAt(start);
                
                if(!stk.isEmpty() && cur == ')'){
                    if(stk.peek() == '('){
                        stk.pop();
                    }
                }else if(!stk.isEmpty() && cur == ']'){
                    if(stk.peek() == '['){
                        stk.pop();
                    }
                }else if(!stk.isEmpty() && cur == '}'){
                    if(stk.peek() == '{'){
                        stk.pop();
                    }
                }else{
                    stk.push(cur);
                }
            }
            
            if(stk.isEmpty()) answer++;
        }
        
        return answer;
    }
}