import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        boolean[] checked = new boolean[26];
        for(int i=0;i<skill.length();i++){
            checked[skill.charAt(i) - 'A'] = true;
        }
        
        for(int i=0;i<skill_trees.length;i++){
            String skill_tree = skill_trees[i];
            
            StringBuilder tmp = new StringBuilder();
            for(int j=0;j<skill_tree.length();j++){
                if(checked[skill_tree.charAt(j) - 'A']){
                    tmp.append(skill_tree.charAt(j));
                }
            }
            
            boolean isCorrect = true;
            for(int j=0;j<tmp.toString().length();j++){
                if(tmp.toString().charAt(j) != skill.charAt(j)){
                    isCorrect = false;
                    break;
                }
            }
            
            if(isCorrect){
                answer++;
            }
        }
        
        return answer;
    }
}