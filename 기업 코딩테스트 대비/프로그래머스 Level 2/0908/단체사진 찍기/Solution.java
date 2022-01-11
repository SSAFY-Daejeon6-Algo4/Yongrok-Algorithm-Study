class Solution {
    public int solution(int n, String[] data) {
        int answer = 0;
        
        int[] kakaoFriends = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
        
        do{
            boolean isgood = true;
            
            for(int i=0;i<n;i++){
                char a = data[i].charAt(0);
                char b = data[i].charAt(2);
                char c = data[i].charAt(3);
                char d = data[i].charAt(4);
                
                int aPos = 0;
                int bPos = 0;

                for(int j=0;j<8;j++){
                    if(kakaoFriends[j] == a){
                        aPos = j;
                    }
                    if(kakaoFriends[j] == b){
                        bPos = j;
                    }
                }

                int gap = Math.abs(aPos-bPos) - 1;

                switch(c){
                    case '=':
                        if(gap != (d-'0')) isgood = false;
                        break;
                    case '<':
                        if(gap >= (d-'0')) isgood = false;
                        break;
                    case '>':
                        if(gap <= (d-'0')) isgood = false;
                        break;
                }
                
                if(!isgood) break;
            }
            
            if(isgood) answer++;
        }while(nextPermutation(kakaoFriends));
        
        return answer;
    }
    
    private static boolean nextPermutation(int[] arr){
        
        int N = arr.length;
        
        int i = N-1;
        while(i>0 && arr[i-1] >= arr[i]) --i;
        
        if(i==0) return false;
        
        int j = N-1;
        while(arr[i-1] >= arr[j]) --j;
        
        swap(arr, i-1, j);
        
        int k = N-1;
        while(i<k){
            swap(arr, i++, k--);
        }
        
        return true;
    }
    
    private static void swap(int[] arr, int a, int b){
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}
