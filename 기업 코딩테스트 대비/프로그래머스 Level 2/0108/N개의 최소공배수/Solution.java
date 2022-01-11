class Solution {
    public int solution(int[] arr) {
        int answer = 0;
        
        for(int a: arr) {
            answer = Math.max(answer, a);
        }
        
        while(true) {
            boolean flag = true;
            for(int a: arr) {
                if(answer % a != 0) {
                    flag = false;
                }
            }
            if(flag) break;
            
            answer++;
        }
        
        return answer;
    }
}