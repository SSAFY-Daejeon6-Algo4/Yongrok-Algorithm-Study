class Solution {
    public int solution(int[] arr) {
        int answer = 0;
        
        int limit = 100_000_000;
        
        int[] dp = new int[limit];
        for(int a: arr) {
            for(int i=1;a*i<limit;i++){
                dp[a*i] += 1;
            }
        }
        
        for(int i=0;i<limit;i++) {
            if(dp[i] == arr.length) {
                answer = i;
                break;
            }
        }
        
        return answer;
    }
}