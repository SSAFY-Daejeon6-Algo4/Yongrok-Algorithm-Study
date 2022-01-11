class Solution {
    public int solution(int n) {
        int answer = n + 1;
        int oneNum = cntOneNum(n);
        
        while(true) {
            if(cntOneNum(answer) == oneNum){
                break;
            }
            answer++;
        }
        
        return answer;
    }
    
    private int cntOneNum(int n) {
        int cnt = 0;
        while(n > 0){
            if(n % 2 == 1){
                cnt++;
            }
            n /= 2;
        }
        return cnt;
    }
}