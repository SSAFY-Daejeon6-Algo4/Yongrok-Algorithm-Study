// 최초 정답 풀이
class Solution2 {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        
        for(int i=0;i<numbers.length;i++){
            // 양의 정수 numbers[i]에 대한 함수 f(numbers[i])값을 answer[i]에 대입
            answer[i] = f(numbers[i]);
        }
        
        return answer;
    }
    
    private long f(long num){
        // 비트마스킹 활용
        // long은 64비트 이므로 64개의 비트를 확인 하기위한 for문
        for(int i=0;i<64;i++){
            // 작은 비트부터 비교하면서 처음 0인 비트를 만날 때까지 탐색!!
            // 현재 확인하는 비트가 0이라면 답을 도출할 수 있다!!
            if((num & (long)1<<i) == 0){
                if(i == 0){ // 첫번째 비트가 0이라면 해당 비트를 1로 바꿔준 값이 답이 된다.
                    return num + ((long)1<<i);
                }else{ // 나머지 경우에서는 해당 비트를 1로 바꿔주고 한칸 뒤의 비트를 0으로 바꿔준 값이 답이 된다.
                    // ((long)1<<i) - ((long)1<<(i-1)) == ((long)1<<(i-1))
                    return num + ((long)1<<(i-1));
                }
            }
        }
        return 1000000000000000L;
    }
}