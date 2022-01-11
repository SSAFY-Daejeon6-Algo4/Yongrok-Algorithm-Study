import org.junit.Assert;
import org.junit.jupiter.api.Test;

class Solution {
    public int solution(String s) {
        int answer = s.length();
        
        for(int i=1;i<s.length()/2+1;i++){
            // i개 단위로 잘라서 압축
            int zipLen = s.length();
            int cnt = 1;
            for(int j=i;j<=s.length()-i;j+=i){
                String prev = s.substring(j-i, j);
                String cur = s.substring(j, j+i);
                
                if(prev.equals(cur)){
                    // 이전 문자 단위와 같으면
                    zipLen -= i;
                    cnt++;
                }else if(cnt > 1){
                    // 이전 문자 단위와 다르고
                    // 압축중이었으면
                    zipLen += Integer.toString(cnt).length();
                    cnt = 1;
                }
            }
            
            // 압축중이었으면 계산했던 cnt값 반영
            if(cnt > 1) zipLen += Integer.toString(cnt).length();
            
            answer = Math.min(answer, zipLen);
        }
        
        return answer;
    }
    
    @Test
    public void 테스트_1() {
    	// given
    	int answer = 7;
    	
    	// when
    	String input = "aabbaccc";
    	int myAnswer = solution(input);
    	
    	// then
    	Assert.assertEquals(answer, myAnswer);
    }
    
    @Test
    public void 테스트_2() {
    	// given
    	int answer = 9;
    	
    	// when
    	String input = "ababcdcdababcdcd";
    	int myAnswer = solution(input);
    	
    	// then
    	Assert.assertEquals(answer, myAnswer);
    }
    
    @Test
    public void 테스트_3() {
    	// given
    	int answer = 8;
    	
    	// when
    	String input = "abcabcdede";
    	int myAnswer = solution(input);
    	
    	// then
    	Assert.assertEquals(answer, myAnswer);
    }
    
    @Test
    public void 테스트_4() {
    	// given
    	int answer = 14;
    	
    	// when
    	String input = "abcabcabcabcdededededede";
    	int myAnswer = solution(input);
    	
    	// then
    	Assert.assertEquals(answer, myAnswer);
    }
    
    @Test
    public void 테스트_5() {
    	// given
    	int answer = 17;
    	
    	// when
    	String input = "xababcdcdababcdcd";
    	int myAnswer = solution(input);
    	
    	// then
    	Assert.assertEquals(answer, myAnswer);
    }
    
    @Test
    public void 통합_테스트() {
    	테스트_1();
    	테스트_2();
    	테스트_3();
    	테스트_4();
    	테스트_5();
    }
    
    @Test
    public void 통합_테스트_한번에_입력() {
    	Assert.assertEquals(7, solution("aabbaccc"));
        Assert.assertEquals(9, solution("ababcdcdababcdcd"));
        Assert.assertEquals(8, solution("abcabcdede"));
        Assert.assertEquals(14, solution("abcabcabcabcdededededede"));
        Assert.assertEquals(17, solution("xababcdcdababcdcd"));
    }
}
