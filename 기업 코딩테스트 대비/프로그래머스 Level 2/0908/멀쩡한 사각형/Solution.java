class Solution {
    public long solution(int w, int h) {
        long answer = (long)w * h;
        
        int a = w;
        int b = h;
        
        while(b > 0){
            int r = b%a;
            b = a;
            a = r;
        }
        
        int useless = w + h - b;
        
        return answer - useless;
    }
}
