class Solution {
    public String solution(int n) {
        StringBuilder answer = new StringBuilder();
        
        int[] worldOf124 = {4, 1, 2};
        
        while(n > 0){
            answer.append(worldOf124[n%3]);
            
            if(n%3 == 0) n--;
            
            n /= 3;
        }
        
        return answer.reverse().toString();
    }
}
