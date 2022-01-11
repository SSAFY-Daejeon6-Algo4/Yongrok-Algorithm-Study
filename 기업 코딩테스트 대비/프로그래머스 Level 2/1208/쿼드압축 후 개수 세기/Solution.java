class Solution {
    
    int[] answer;
    
    public int[] solution(int[][] arr) {
        answer = new int[2];
        quad(0, 0, arr.length, arr);
        return answer;
    }
    
    public void quad(int x, int y, int n, int[][] arr){
        int init = arr[x][y];
        
        boolean isZipped = true;
        for(int i=x;i<x+n;i++){
            for(int j=y;j<y+n;j++){
                if(init != arr[i][j]){
                    isZipped = false;
                    break;
                }
            }
        }
        
        if(isZipped){
            answer[init]++;
            return;
        }
        
        for(int i=0;i<2;i++){
            for(int j=0;j<2;j++){
                quad(x+i*n/2, y+j*n/2, n/2, arr);
            }
        }
    }
}