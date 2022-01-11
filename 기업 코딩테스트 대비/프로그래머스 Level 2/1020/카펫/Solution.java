class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int h = 3;
        int w = brown/2 - (h-1) + 1;
        
        while(h <= w){
            if(yellow == (h-2)*(w-2)){
                answer[0] = w;
                answer[1] = h;
                break;
            }
            
            h++;
            w--;
        }
        
        return answer;
    }
}