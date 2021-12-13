import java.util.*;

class SolutionOld {
    public int solution(int [][]board) {
        int n = board.length;
        int m = board[0].length;
        int answer = Math.min(n, m);
        
        while(answer > 0){
            boolean isFind = false;
            out: for(int i=0;i<=n-answer;i++){
                for(int j=0;j<=m-answer;j++){
                    if(checkSquare(i, j, answer, board)) {
                        isFind = true;
                        break out;
                    }
                }
            }
            if(isFind) break;
            
            answer--;
        }

        return answer*answer;
    }
    
    private boolean checkSquare(int x, int y, int n, int[][] board) {
        for(int i=x;i<x+n;i++){
            for(int j=y;j<y+n;j++){
                if(board[i][j] == 0){
                    return false;
                }
            }
        }
        return true;
    }
}