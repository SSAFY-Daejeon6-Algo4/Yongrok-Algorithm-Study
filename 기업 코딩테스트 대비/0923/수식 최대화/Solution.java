import java.util.*;

class Solution {
    public long solution(String expression) {
        long answer = 0;
        ArrayList<Long> numList = new ArrayList<>();
        ArrayList<Character> opList = new ArrayList<>();
        
        int idx = 0;
        for(int i=0;i<expression.length();i++){
            char ch = expression.charAt(i);
            if(ch == '*' | ch == '+' | ch == '-'){
                opList.add(ch);
                numList.add(Long.parseLong(expression.substring(idx, i)));
                idx = i+1;
            }else if(i == expression.length()-1){
                numList.add(Long.parseLong(expression.substring(idx, i+1)));           
            }
        }
        
        String[] prior = {
            "*+-", "*-+",
            "+*-", "+-*", 
            "-*+", "-+*",
        };
        
        for(int i=0;i<6;i++){
            ArrayList<Long> tmpNum = new ArrayList<>(numList);
            ArrayList<Character> tmpOp = new ArrayList<>(opList);
            String pr = prior[i];
            
            for(int j=0;j<3;j++){
                for(int k=0;k<tmpOp.size();k++){
                    if(pr.charAt(j) == tmpOp.get(k)){
                        if(pr.charAt(j) == '*'){
                            tmpNum.set(k, tmpNum.get(k)*tmpNum.get(k+1));
                            tmpNum.remove(k+1);
                        }else if(pr.charAt(j) == '+'){
                            tmpNum.set(k, tmpNum.get(k)+tmpNum.get(k+1));
                            tmpNum.remove(k+1);
                        }else if(pr.charAt(j) == '-'){
                            tmpNum.set(k, tmpNum.get(k)-tmpNum.get(k+1));
                            tmpNum.remove(k+1);
                        }
                        tmpOp.remove(k--);
                    }
                }
            }
            
            answer = Math.max(answer, Math.abs(tmpNum.get(0)));
        }
        
        
        return answer;
    }
}