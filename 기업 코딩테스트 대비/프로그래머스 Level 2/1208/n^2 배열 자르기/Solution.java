class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int)(right-left)+1];
        int ansIdx = 0;
        
        long startX = left/n;
        long startY = left%n;
        
        long cnt = left-startY;
        out: for(int i=(int)startX;i<n;i++){
            for(int j=0;j<n;j++){
                if(cnt >= left){
                    answer[ansIdx++] = (i > j) ? (i+1) : (j+1);
                }
                
                if(cnt == right){
                    break out;
                }
                
                cnt++;
            }
        }
        
        return answer;
    }
}