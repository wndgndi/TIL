class Solution {
    public int solution(int n) {
        int num = 1;
        int answer = 1;
        
        while(num <= n) { 
            answer++;
            num *= answer;
        }
        
        return answer-1;
    }
}