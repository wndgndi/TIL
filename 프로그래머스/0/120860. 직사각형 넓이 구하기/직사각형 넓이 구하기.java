class Solution {
    public int solution(int[][] dots) {
        int a, b;
        
        if(dots[0][0] - dots[1][0] == 0) {
            a = Math.abs(dots[0][0] - dots[2][0]);
        } else {
            a = Math.abs(dots[0][0] - dots[1][0]);
        }
        
        if(dots[0][1] - dots[1][1] == 0) {
            b = Math.abs(dots[0][1] - dots[2][1]);
        } else {
            b = Math.abs(dots[0][1] - dots[1][1]);
        }
        
        return a * b;
    }
}