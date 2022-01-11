// 시간초과 버전... ㅠ
class SolutionOld {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        
        for(int i=0;i<numbers.length;i++){
            // 양의 정수 numbers[i]에 대한 함수 f(numbers[i])값을 answer[i]에 대입
            answer[i] = f(numbers[i]);
        }
        
        return answer;
    }
    
    private long f(long num){
        long target = num;
        // target값을 1씩 증가시켜 주면서
        // num과의 XOR연산을 통해 다른 비트를 check에 1로 표시하게 만들고
        // check의 1인 비트의 개수를 세서 2이하라면 break
        // 그 때의 target값을 출력!
        // BUT ~
        // 하지만 이 방법은 target을 하나씩 증가하면서 10^15까지 하나하나 비교하기 때문에 시간초과!!
        while(true){
            target++;
            long check = target ^ num;
            
            int cnt = 0;
            while(check > 0){
                if(check%2 == 1) cnt++;
                check /= 2;
            }
            if(cnt <= 2) break;
        }
        return target;
    }
}