import java.util.*;

class Solution {
    
    public int Answer;
    public char[] permedNum;
    public Set<Integer> numSet;
    
    public int solution(String numbers) {
        Answer = 0;
        
        char[] numArr = numbers.toCharArray();
        numSet = new HashSet<>();
        
        for(int i=1;i<=numArr.length;i++){
            permedNum = new char[i];
            permutation(0, 0, i, numArr);
        }
        
        return Answer;
    }
    
    private void permutation(int cnt, int flag, int r, char[] numArr) {
        if(cnt == r){
            String tmpStr = new String(permedNum);
            int tmpNum = Integer.parseInt(tmpStr);
            
            if(numSet.add(tmpNum) && isSosu(tmpNum)){
                Answer++;
            }
            
            return;
        }
        
        for(int i=0;i<numArr.length;i++){
            if((flag & 1<<i) != 0) continue;
            permedNum[cnt] = numArr[i];
            permutation(cnt+1, (flag|1<<i), r, numArr);
        }
    }
    
    private boolean isSosu(int n) {
        if(n == 0 || n == 1) return false;
        
        for(int i=2;i*i<=n;i++){
            if(n % i == 0){
                return false;
            }
        }
        
        return true;
    }
}