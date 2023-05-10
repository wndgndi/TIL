class Solution {
    public int solution(int n) {
        int answer = 0;
        int x = (int) Math.sqrt(n);
        
        if(x*x == n) {
            answer = 1;
        } else {
            answer = 2;
        }
        
        return answer;
    }
}