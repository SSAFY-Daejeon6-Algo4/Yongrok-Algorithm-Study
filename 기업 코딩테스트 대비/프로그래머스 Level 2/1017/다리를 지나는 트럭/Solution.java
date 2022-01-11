import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        
        Queue<Integer> bridge = new LinkedList<>();
        for(int i=0;i<bridge_length;i++){
            bridge.offer(0);
        }
        
        int doneCnt = 0;
        int twIdx = 0;
        int curWeight = 0;
        while(doneCnt < truck_weights.length){
            int doneTruck = bridge.poll();
            if(doneTruck > 0){
                doneCnt++;
                curWeight -= doneTruck;
            }
            
            if(twIdx < truck_weights.length && curWeight + truck_weights[twIdx] <= weight){
                int curTruck = truck_weights[twIdx];
                curWeight += curTruck;
                bridge.offer(curTruck);
                twIdx++;
            }else{
                bridge.offer(0);
            }

            answer++;
        }
        
        return answer;
    }
}