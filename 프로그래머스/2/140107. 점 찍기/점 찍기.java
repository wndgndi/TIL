class Solution {
    public long solution(int k, int d) {
        long answer =  0;
        
        for(int i=0; i<=d; i+=k) {
            int y = calculate(i, d);
            
            answer += y / k + 1;
        }
        
        return answer;
    }
    
    private int calculate(int x, int d) {
        double x2 = Math.pow(x, 2);
        double d2 = Math.pow(d, 2);
        
        int y  = (int) Math.sqrt(d2 - x2);
        return y;
    }
}