import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        
        for(int i=0; i<citations.length; i++) {
            int h = Math.min(citations[i], citations.length - i);
            answer = Math.max(h, answer);
        }    
        
        return answer;
    }
}