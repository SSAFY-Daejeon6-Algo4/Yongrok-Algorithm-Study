import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        Arrays.sort(people);
        
        int a = 0;
        int b = people.length - 1;
        
        while(a <= b){
            if(people[b] + people[a] <= limit){
                a++;
            }
            b--;
            answer++;
        }
        
        return answer;
    }
}