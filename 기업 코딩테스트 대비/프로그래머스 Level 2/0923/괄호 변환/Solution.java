import java.util.*;

class Solution {
    public String solution(String p) {
        String answer = "";
        
        if(p.equals("")) return ""; // 빈 문자열일때 빈 문자열 반환
        else if(isCorrect(p)) return p; // 이미 올바른 괄호 문자열이라면 그대로 반환
        
        answer = makeCorrect(p); // 올바른 괄호 문자열로 바꾸기
        
        return answer;
    }
    
    private static boolean isCorrect(String s){
        Stack<Character> stk = new Stack<>();
        
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '('){
                stk.push(s.charAt(i));
            }else if(s.charAt(i) == ')'){
                if(stk.isEmpty()) return false;
                stk.pop();
            }
        }
        
        return true;
    }
    
    private static String makeCorrect(String w){
        if(w.equals("")) return ""; // 빈 문자열인 경우
        
        String u = "";
        String v = "";
        StringBuilder ans = new StringBuilder(); // 최종 문자열
        
        // u, v 분리
        // 균형 잡힌 괄호 문자열 찾기
        int a = 0;
        int b = 0;
        for(int i=0;i<w.length();i++){
            if(w.charAt(i) == '(') a++;
            else if(w.charAt(i) == ')') b++;
            
            if(a == b){
                u = w.substring(0, i+1);
                v = w.substring(i+1);
                break;
            }
        }
        
        // 3, 4번 조건 내용
        // u가 올바른 괄호 문자열인지 아닌지
        if(isCorrect(u)){
            ans.append(u);
            ans.append(makeCorrect(v));
        }else{
            ans.append("(");
            ans.append(makeCorrect(v));
            ans.append(")");
            
            // 첫 번째와 마지막 문자 제거
            // 괄호방향 뒤집기
            StringBuilder tmp = new StringBuilder();
            
            for(int i=1;i<u.length()-1;i++){
                if(u.charAt(i) == '(') tmp.append(")");
                else if(u.charAt(i) == ')') tmp.append("(");
            }
            
            ans.append(tmp.toString());
        }
        
        return ans.toString();
    }
}