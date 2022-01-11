class Solution {
    public int solution(String name) {
        int answer = 0;
        
        int updown = 0;
        int leftright = 0;
        
        // 위, 아래
        for(int i=0;i<name.length();i++){
            int up = name.charAt(i) - 'A';
            if(up < 13){
                updown = updown + up;
            }else{
                updown = updown + 26 - up;
            }
        }
        
        // 왼쪽으로만, 오른쪽으로만
        int right = 0;
        for(int i=1;i<name.length();i++){
            if(name.charAt(i) != 'A') right = i;
        }
        int left = 0;
        for(int i=name.length()-1;i>0;i--){
            if(name.charAt(i) != 'A') left = name.length()-i;
        }
        if(left > right) leftright = right;
        else leftright = left;
        
        // 다른 경우들 비교
        // 오른쪽 갔다가 왼쪽으로 가는 경우
        int other = 0;
        for(int i=1;i<name.length();i++){
            if(name.charAt(i) != 'A'){
                for(int j=name.length()-1;j>i;j--){
                    if(name.charAt(j) != 'A'){
                        other = name.length()-j;
                    }
                }
                other = other + i*2;
                if(leftright > other){
                    leftright = other;
                }
            }
        }
        
        // 왼쪽 갔다가 오른쪽으로 가는 경우
        other = 0;
        for(int i=name.length()-1;i>0;i--){
            if(name.charAt(i) != 'A'){
                for(int j=1;j<i;j++){
                    if(name.charAt(j) != 'A'){
                        other = j;
                    }
                }
                other = other + (name.length()-i)*2;
                if(leftright > other){
                    leftright = other;
                }
            }
        }
        
        answer = updown + leftright;
        
        return answer;
    }
}