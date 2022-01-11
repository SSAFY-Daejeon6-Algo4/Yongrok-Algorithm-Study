// 최초 정답 풀이에서의 리팩토링 버전!!
class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        
        for(int i=0;i<numbers.length;i++){
            // 양의 정수 numbers[i]에 대한 함수 f(numbers[i])값을 answer[i]에 대입
            answer[i] = f(numbers[i]);
        }
        
        return answer;
    }
    
    private long f(long num){
        // 첫번째 비트가 0이라면 해당 비트를 1로 바꿔준 값이 답이 된다. (1을 더해준 값과 같다)
        // ex) 000...0010101110 -> 000...0010101111 바로 다음 값이 답이 된다.
        if((num & 1) == 0) return num + 1;
        
        // 두번째 비트가 0인지 부터 확인한다.
        // target을 2배로 늘려가면서 & 연산으로 해당 비트가 0인지 확인해준다.
        // 2    -> 4    -> 8     -> 16     -> 32     ...
        // 10   -> 100  -> 1000  -> 10000  -> 100000 ...
        long target = 2;
        while(true){
            // 처음으로 num에서 0인 비트를 만났을 때 답을 도출 할 수 있다!
            if((num & target) == 0){
                break;
            }
            target *= 2; // 다음 비트를 확인하기 위해 2를 곱해준다.
        }

        // target의 비트를 1로 바꿔주고(target을 더해주기) target의 한칸 이전의 비트를 0으로 바꿔준다(target/2를 빼주기)
        // target 이전의 비트는 모두 1이였으므로 (처음 0을 만날 때까지 증가 중이였으므로) 항상 한칸 이전의 비트를 0으로 바꿔 줄 수 있다.
        // 따라서 최종 답은 (num + target - target/2)인데 이것은 (num + target/2)과 같다.
        return num + target/2;
    }
}