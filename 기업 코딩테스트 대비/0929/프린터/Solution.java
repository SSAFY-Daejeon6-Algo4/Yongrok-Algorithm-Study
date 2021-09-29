import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        Queue<Integer> q = new LinkedList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->(b-a));
        
        for(int i=0;i<priorities.length;i++){
            q.offer(i);
            pq.offer(priorities[i]);
        }
        while(answer < priorities.length){
            if(priorities[q.peek()] == pq.peek()){
                pq.poll();
                answer++;
                if(q.peek() == location) break;
            }
            q.offer(q.peek());
            q.poll();
        }
        
        return answer;
    }
}