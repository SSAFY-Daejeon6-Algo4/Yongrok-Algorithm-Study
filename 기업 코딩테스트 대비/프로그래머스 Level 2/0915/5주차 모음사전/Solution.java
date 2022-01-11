import java.util.*;

class Solution {
    public int solution(String word) {
        int answer = 1;
        
        Map<String, String> wordMap = new HashMap<>();
        wordMap.put("0", "");
        wordMap.put("1", "A");
        wordMap.put("2", "E");
        wordMap.put("3", "I");
        wordMap.put("4", "O");
        wordMap.put("5", "U");
        
        Set<String> dict = new TreeSet<>();
        
        for(int i=1;i<6*6*6*6*6;i++){
            String str = Integer.toString(i, 6);
            
            StringBuilder tmp = new StringBuilder();
            for(int j=0;j<str.length();j++){
                tmp.append(wordMap.get(str.substring(j,j+1)));
            }

            dict.add(tmp.toString());
        }
        
        for(String s: dict){
            if(word.equals(s)){
                break;
            }
            answer++;
        }
        
        return answer;
    }
}
