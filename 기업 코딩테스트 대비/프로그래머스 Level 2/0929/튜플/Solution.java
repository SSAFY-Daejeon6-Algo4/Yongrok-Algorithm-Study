import java.util.*;

class Solution {
    public int[] solution(String s) {
        List<String[]> list = new LinkedList<>();
        
        StringBuilder tmp = null;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '{'){
                tmp = new StringBuilder();
            }else if(s.charAt(i) == '}'){
                list.add(tmp.toString().split(","));
                i++;
            }else{
                tmp.append(s.charAt(i));
            }
        }
        
        Collections.sort(list, (a,b)->(a.length - b.length));
        
        int[] answer = new int[list.size()];
        int ansIdx = 0;
        
        Set<Integer> set = new HashSet<>();
        
        for(String[] sa: list){
            for(String str: sa){
                int num = Integer.parseInt(str);
                if(set.add(num)){
                    answer[ansIdx++] = num;
                }
            }
        }
        
        return answer;
    }
}